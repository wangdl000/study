package nablarch.fw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;
import nablarch.core.message.ApplicationException;
import nablarch.core.util.annotation.Published;

/**
 * 一連のハンドラ実行において、共通して読み書きするデータを保持するクラス。
 * <p/>
 * 具体的には以下の情報を保持する。
 * <ul>
 *     <li>ハンドラキュー</li>
 *     <li>データリーダ もしくは データリーダファクトリ</li>
 *     <li>ユーザセッションスコープ情報</li>
 *     <li>リクエストスコープ情報</li>
 * </ul>
 * 本クラスのセッションスコープはスレッドアンセーフである。
 * 複数スレッドから使用する場合はセッションスコープにスレッドセーフなMap実装を設定すること。
 *
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
public class ExecutionContext extends HandlerQueueManager<ExecutionContext> {

	/**
	 * 各種スコープ上の変数をフレームワークが使用する際に
	 * 名前に付けるプレフィックス（予約名）
	 */
	public static final String FW_PREFIX = "nablarch_";

	// ------------------------------------------------ Internal structure
	/** ハンドラキュー */
	@SuppressWarnings("rawtypes")
	private final ArrayList<Handler> handlerQueue;

	/** データリーダ */
	private DataReader<?> reader = null;

	/** データリーダファクトリ */
	private DataReaderFactory<?> readerFactory = null;

	/** セッションスコープ上の変数を格納したMap */
	private Map<String, Object> sessionScopeMap = null;

	/** セッションストア上の変数を格納したMap */
	private Map<String, Object> sessionStoreMap = null;

	/** リクエストスコープ上の変数を格納するMap */
	private Map<String, Object> requestScopeMap = null;

	/** この実行コンテキストによって最後に読み込まれたデータ */
	private Object lastReadData = null;

	/** 現在、物理的に読み込んでいるレコードのレコード番号 */
	private int lastRecordNumber;

	/** 処理結果 */
	private boolean processSucceeded = true;

	/** 現在処理中のリクエストオブジェクト */
	private Object currentRequestObject;

	//----------------------------------------------- HandlerQueue Management
	@SuppressWarnings("rawtypes")
	@Override
	public List<Handler> getHandlerQueue() {
		return handlerQueue;
	}

	/**
	 * ハンドラキュー上の次のハンドラに処理を委譲する。
	 *
	 * @param <TData>   処理対象データの型
	 * @param <TResult> 処理結果データの型
	 * @param data 処理対象データ
	 * @return 実行結果
	 * @throws NoMoreHandlerException
	 *     次のハンドラが存在しない場合。
	 * @throws ClassCastException
	 *     ハンドラの型変数と実際のハンドラの戻り値の型が異なる場合。
	 */
	@Published
	@SuppressWarnings("unchecked")
	public <TData, TResult> TResult handleNext(TData data)
			throws NoMoreHandlerException, ClassCastException {
		Object previous = getCurrentRequestObject();
		setCurrentRequestObject(data);
		TResult result = null;
		try {
			result = (TResult) getNextHandler().handle(data, this);
		} finally {
			// 処理中データが後続ハンドラで変更されることを考慮し、呼び出し元ハンドラに戻る前に元に戻す。
			setCurrentRequestObject(previous);
		}
		return result;
	}

	/**
	 * ハンドラキュー上の次のハンドラを取得する。
	 *
	 * @param <TData>   処理対象データの型
	 * @param <TResult> 処理結果データの型
	 * @return 次のハンドラ
	 * @throws NoMoreHandlerException
	 *     次のハンドラが存在しない場合。
	 * @throws ClassCastException
	 *     ハンドラの型変数と実際のハンドラの戻り値の型が異なる場合。
	 */
	@SuppressWarnings("unchecked")
	public <TData, TResult> Handler<TData, TResult> getNextHandler()
			throws NoMoreHandlerException, ClassCastException {
		if (getHandlerQueue().isEmpty()) {
			throw new NoMoreHandlerException();
		}
		return getHandlerQueue().remove(0);
	}

	/**
	 * ハンドラキュー上の後続ハンドラのうち、
	 * 指定されたクラスもしくはインタフェースを実装している直近のハンドラを返す。
	 * <p/>
	 * 該当するハンドラが登録されていなかった場合は{@code null}を返す。
	 *
	 * @param <T>        検索対象のハンドラ型
	 * @param data       このハンドラに対する入力オブジェクト
	 * @param targetType 検索対象のハンドラ型
	 * @param stopType   このタイプのハンドラよりも後続にあるハンドラを検索対象から除外する。
	 * @return 検索結果 (該当するハンドラが存在しなかった場合は{@code null}を返す。)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T findHandler(Object data, Class<T> targetType, Class<?> stopType) {
		List<Object> handlers = new ArrayList<Object>();
		handlers.addAll(getHandlerQueue());

		while (!handlers.isEmpty()) {
			Object handler = handlers.remove(0);
			if (targetType.isAssignableFrom(handler.getClass())) {
				return (T) handler;
			}
			if (stopType.isAssignableFrom(handler.getClass())) {
				return null;
			}
			// HandlerWrapperの内容を展開する。
			if (handler instanceof HandlerWrapper) {
				HandlerWrapper wrapper = (HandlerWrapper) handler;
				handlers.addAll(0, wrapper.getDelegates(data, this));
			}
		}
		return null;
	}

	/**
	 * ハンドラキュー上の後続ハンドラのうち、
	 * 指定されたクラスもしくはインタフェースを実装しているものを全て返す。
	 * <p/>
	 * 該当するハンドラが登録されていなかった場合は空のリストを返す。
	 *
	 * @param <T>        検索対象のハンドラ型
	 * @param data       このハンドラに対する入力オブジェクト
	 * @param targetType 検索対象のハンドラ型
	 * @param stopType   このタイプのハンドラよりも後続にあるハンドラを検索対象から除外する。
	 * @return 検索結果
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> selectHandlers(Object data, Class<T> targetType, Class<?> stopType) {
		List<Object> handlers = new ArrayList<Object>();
		handlers.addAll(getHandlerQueue());

		List<T> results = new ArrayList<T>();

		while (!handlers.isEmpty()) {
			Object handler = handlers.remove(0);
			if (targetType.isAssignableFrom(handler.getClass())) {
				results.add((T) handler);
			}
			if (stopType.isAssignableFrom(handler.getClass())) {
				return results;
			}
			// HandlerWrapperの内容を展開する。
			if (handler instanceof HandlerWrapper) {
				HandlerWrapper wrapper = (HandlerWrapper) handler;
				handlers.addAll(0, wrapper.getDelegates(data, this));
			}
		}
		return results;
	}

	// ---------------------------------------------- Constructors
	/**
	 * デフォルトコンストラクタ
	 */
	@SuppressWarnings("rawtypes")
	@Published(tag = "architect")
	public ExecutionContext() {
		handlerQueue = new ArrayList<Handler>();
		requestScopeMap = new HashMap<String, Object>();
		sessionStoreMap = new HashMap<String, Object>();
		sessionScopeMap = new HashMap<String, Object>();
	}

	/**
	 * 元となる実行コンテキストから、新たな実行コンテキストのオブジェクトを作成する。
	 * <p/>
	 * 作成される実行コンテキストの状態は以下の通り。
	 * <ul>
	 *     <li>ハンドラキューには、元のオブジェクトからシャローコピーを作成して設定する。</li>
	 *     <li>リクエストスコープには、新規インスタンスを設定する(コピーされない)。</li>
	 *     <li>それ以外のフィールドには、元のオブジェクトの参照を設定する。</li>
	 * </ul>
	 *
	 * @param original 元となる実行コンテキスト
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ExecutionContext(ExecutionContext original) {
		handlerQueue = (ArrayList<Handler>) original.handlerQueue.clone();
		requestScopeMap = new HashMap<String, Object>();
		sessionStoreMap = original.sessionStoreMap;
		sessionScopeMap = original.sessionScopeMap;
		reader = original.reader;
		readerFactory = original.readerFactory;
		setMethodBinder(original.<Object, Object> getMethodBinder());
	}

	/***
	 * 自身の複製を返す。
	 * <p/>
	 * 複製処理の本体は{@link ExecutionContext#copyInternal()}に委譲している。
	 *
	 * @return 自身の複製。
	 */
	public final ExecutionContext copy() {
		ExecutionContext copied = copyInternal();
		if (!this.getClass().equals(copied.getClass())) {
			throw new UnsupportedOperationException("copyInternal method is not properly implemented.");
		}
		return copied;
	}

	/***
	 * 自身の複製を返す。
	 * <p/>
	 * 当メソッドが返すインスタンスはレシーバと同じ型でなければいけない。<br/>
	 * つまりobj.getClass() == obj.copy().getClass()がtrueでなければいけない。当メソッドをサブクラスでオーバーライドする場合はこの制約に注意して実装すること。
	 *
	 * @return 自身の複製。
	 */
	protected ExecutionContext copyInternal() {
		return new ExecutionContext(this);
	}

	//--------------------------------------------------------- DataReader
	/**
	 * この実行コンテキスト上のデータリーダを使用して、次のデータを読み込む。
	 *
	 * @param <TData> データリーダが読み込むデータの型
	
	 * @return 読み込んだデータ
	 */
	public <TData> TData readNextData() {
		DataReader<TData> reader = getDataReader();
		if (reader == null) {
			return null;
		}
		TData readData = reader.hasNext(this) ? reader.read(this)
				: null;
		lastReadData = readData;
		return readData;
	}

	/**
	 * この実行コンテキストが最後に読み込んだデータオブジェクトを返す。
	 *
	 * @param <TData> データオブジェクトの型
	 * @return この実行コンテキストが最後に読み込んだデータオブジェクト
	 */
	@SuppressWarnings("unchecked")
	public <TData> TData getLastReadData() {
		return (TData) lastReadData;
	}

	/**
	 * この実行コンテキストが最後に読み込んだデータオブジェクトをクリアする。
	 */
	public void clearLastReadData() {
		lastReadData = null;
	}

	/**
	 * 例外に関連するデータを追加する。
	 * <p/>
	 * 指定された例外およびデータはリクエストスコープに保持する。
	 *
	 * @param e 例外
	 * @param data 例外に関連するデータ
	 */
	public void putDataOnException(Throwable e, Object data) {
		getDataProcessedWhenThrownMap().put(e, data);
	}

	/**
	 * 指定した例外を送出したスレッドが、例外発生時に処理していた入力データを返す。
	 *
	 * @param e 例外
	 * @return 指定した例外を送出したスレッドが例外発生時に処理していた入力データ。存在しない場合はnull
	 */
	public Object getDataProcessedWhenThrown(Throwable e) {
		return getDataProcessedWhenThrownMap().get(e);
	}

	/** 例外を送出したスレッドが例外発生時に処理していた入力データをリクエストスコープに格納する際に使用するキー */
	private static final String DATA_PROCESSED_WHEN_THROWN_MAP_KEY = FW_PREFIX + "dataProcessedWhenThrownMap";

	/**
	 * 例外を送出したスレッドが例外発生時に処理していた入力データを格納したマップをリクエストスコープから取得する。
	 * <p/>
	 * 存在しない場合はマップを新規に作成しリクエストスコープに追加する。
	 *
	 * @return 例外を送出したスレッドが例外発生時に処理していた入力データを格納したマップ
	 */
	@SuppressWarnings("unchecked")
	private Map<Throwable, Object> getDataProcessedWhenThrownMap() {
		if (!getRequestScopeMap().containsKey(DATA_PROCESSED_WHEN_THROWN_MAP_KEY)) {
			getRequestScopeMap().put(DATA_PROCESSED_WHEN_THROWN_MAP_KEY, new HashMap<Throwable, Object>());
		}
		return (Map<Throwable, Object>) getRequestScopeMap().get(DATA_PROCESSED_WHEN_THROWN_MAP_KEY);
	}

	/**
	 * この実行コンテキスト上のデータリーダから次に読み出すことができるデータが残っているかどうか。
	 *
	 * @return 次に読み出すデータが存在する場合は{@code true}
	 */
	public boolean hasNextData() {
		DataReader<?> reader = getDataReader();
		return (reader == null) ? false
				: reader.hasNext(this);
	}

	/**
	 * データリーダを取得する。
	 *<p/>
	 * データリーダが設定されていない場合は、
	 * データリーダファクトリを使用してリーダを生成し、その結果を返す。
	 * ファクトリも設定されていない場合はnullを返す。
	 *
	 * @param <TData> データリーダが読み込むデータ型
	 * @return データリーダ
	 */
	@SuppressWarnings("unchecked")
	public <TData> DataReader<TData> getDataReader() {
		if (reader != null) {
			return (DataReader<TData>) reader;
		}
		if (readerFactory != null) {
			reader = readerFactory.createReader(this);
			return (DataReader<TData>) reader;
		}
		return null;
	}

	/**
	 * データリーダを設定する。
	 *
	 * @param <TData> データリーダが読み込むデータ型
	 * @param reader データリーダ
	 * @return このオブジェクト自体
	 */
	public <TData> ExecutionContext setDataReader(DataReader<TData> reader) {
		this.reader = reader;
		return this;
	}

	/**
	 * データリーダのファクトリを設定する。
	 *
	 * @param <TData> ファクトリが生成するデータリーダが読み込むデータ型
	 * @param factory 設定するデータリーダファクトリ
	 * @return このオブジェクト自体
	 */
	public <TData> ExecutionContext setDataReaderFactory(DataReaderFactory<TData> factory) {
		this.readerFactory = factory;
		return this;
	}

	/**
	 * 現在使用しているデータリーダを閉じる。
	 * <p/>
	 * リーダを閉じる際に例外が発生した場合は、ワーニングログを出力し、
	 * 処理を継続する。
	 *
	 * @return このオブジェクト自体
	 */
	public ExecutionContext closeReader() {
		// 使用していたデータリーダを閉じる
		try {
			if (reader != null) {
				reader.close(this);
			}

			// リーダを閉じる際にエラーが発生しても処理を継続する。
		} catch (Exception e) {
			LOGGER.logWarn("An error occurred while closing the reader.", e);
		} catch (Error e) {
			LOGGER.logWarn("An error occurred while closing the reader.", e);
		}
		return this;
	}

	//------------------------------------------------------- RequestScope

	/** 例外をリクエストスコープから取得する際に使用するキー */
	public static final String THROWN_EXCEPTION_KEY = FW_PREFIX + "error";

	/** {@link ApplicationException}をリクエストスコープから取得する際に使用するキー */
	public static final String THROWN_APPLICATION_EXCEPTION_KEY = FW_PREFIX + "application_error";

	/**
	 * リクエストスコープから例外を取得する。
	 * <p/>
	 * {@link #THROWN_EXCEPTION_KEY}キーを使用する。
	 *
	 * @return 例外。リクエストスコープに例外が設定されていない場合はnull
	 */
	public Throwable getException() {
		return getRequestScopedVar(THROWN_EXCEPTION_KEY);
	}

	/**
	 * リクエストスコープから{@link ApplicationException}を取得する。
	 * <p/>
	 * {@link #THROWN_APPLICATION_EXCEPTION_KEY}キーを使用する。
	 *
	 * @return {@link ApplicationException}。
	 *          リクエストスコープに{@link ApplicationException}が設定されていない場合はnull
	 */
	public ApplicationException getApplicationException() {
		return getRequestScopedVar(THROWN_APPLICATION_EXCEPTION_KEY);
	}

	/**
	 * リクエストスコープに例外を設定する。
	 * <p/>
	 * {@link #THROWN_EXCEPTION_KEY}キーに例外を設定する。
	 * さらに、例外が{@link ApplicationException}の場合は、
	 * {@link #THROWN_APPLICATION_EXCEPTION_KEY}キーにも設定する。
	 *
	 * @param e 例外
	 */
	public void setException(Throwable e) {
		setRequestScopedVar(THROWN_EXCEPTION_KEY, e);
		setProcessSucceeded(false);
		if (e instanceof ApplicationException) {
			setRequestScopedVar(THROWN_APPLICATION_EXCEPTION_KEY, e);
		}
	}

	/**
	 * 処理が正常終了したかどうかを取得する。
	 *
	 * @return 正常終了した場合{@code true}
	 */
	public boolean isProcessSucceeded() {
		return processSucceeded;
	}

	/**
	 * 現在処理中のリクエストオブジェクトを設定する。
	 *
	 * @param currentRequestObject 現在処理中のリクエストオブジェクト
	 */
	public void setCurrentRequestObject(Object currentRequestObject) {
		this.currentRequestObject = currentRequestObject;
	}

	/**
	 * 現在処理中のリクエストオブジェクトを取得する。
	 * <p/>
	 * 本メソッドは、{@ref InboundHandleable}または{@ref OutboundHandleable}の処理中にリクエストオブジェクトを取得する際に使用する。
	 *
	 * @return 現在処理中のリクエストオブジェクト
	 */
	public Object getCurrentRequestObject() {
		return currentRequestObject;
	}

	/**
	 * 処理が正常終了したかどうかを設定する。
	 *
	 * @param processSucceeded 正常終了の場合{@code true}
	 */
	public void setProcessSucceeded(boolean processSucceeded) {
		this.processSucceeded = processSucceeded;
	}

	/**
	 * リクエストスコープを設定する。
	 *
	 * @param m リクエストスコープ上の変数を格納するMap
	 * @return このオブジェクト自体
	 */
	public ExecutionContext setRequestScopeMap(Map<String, Object> m) {
		this.requestScopeMap = m;
		return this;
	}

	/**
	 * リクエストスコープ上の変数を格納したMapオブジェクトへの参照を返す。
	 * <p/>
	 * このMapへの変更はリクエストスコープに直接反映される。
	 *
	 * @return リクエストスコープへの参照
	 */
	@Published
	public Map<String, Object> getRequestScopeMap() {
		return requestScopeMap;
	}

	/**
	 * リクエストスコープ上の変数の値を取得する。
	 *
	 * @param <T> 期待する変数の型
	 * @param varName 変数名
	 * @return 変数の値
	 * @throws ClassCastException
	 *           実際の変数の型が期待する変数の型と適合しなかった場合。
	 */
	@SuppressWarnings("unchecked")
	@Published
	public <T> T getRequestScopedVar(String varName) throws ClassCastException {
		return (T) getRequestScopeMap().get(varName);
	}

	/**
	 * リクエストスコープ上の変数の値を設定する。
	 * <p/>
	 * 既に定義済みの変数は上書きされる。
	 *
	 * @param varName  変数名
	 * @param varValue 変数の値
	 * @return このオブジェクト自体
	 */
	@Published
	public ExecutionContext setRequestScopedVar(String varName, Object varValue) {
		getRequestScopeMap().put(varName, varValue);
		return this;
	}

	//------------------------------------------------------ SessionStore
	/**
	 * セッションストア上の変数を格納したMapを設定する。
	 *
	 * @param m セッションストア上の変数を格納したMap
	 * @return このオブジェクト自体
	 */
	public ExecutionContext setSessionStoreMap(Map<String, Object> m) {
		sessionStoreMap = m;
		return this;
	}

	/**
	 * セッションストア情報を格納したMapオブジェクトへの参照を返す。
	 * <p/>
	 * このMapへの変更はセッションストアに直接反映される。
	 *
	 * @return セッションストアへの参照
	 */
	public Map<String, Object> getSessionStoreMap() {
		return sessionStoreMap;
	}

	/**
	 * セッションストア上の変数の値を取得する。
	 *
	 * @param <T> 期待する変数の型
	 * @param varName 変数名
	 * @return 変数の値
	 * @throws ClassCastException
	 *           実際の変数の型が期待する変数の型と適合しなかった場合。
	 */
	@SuppressWarnings("unchecked")
	public <T> T getSessionStoredVar(String varName) throws ClassCastException {
		return (T) getSessionStoreMap().get(varName);
	}

	/**
	 * セッションストア上の変数の値を設定する。
	 * <p/>
	 * 既に定義済みの変数は上書きされる。
	 *
	 * @param varName  変数名
	 * @param varValue 変数の値
	 * @return このオブジェクト自体
	 */
	public ExecutionContext setSessionStoredVar(String varName, Object varValue) {
		getSessionStoreMap().put(varName, varValue);
		return this;
	}

	//------------------------------------------------------ SessionScope
	/**
	 * セッションスコープ上の変数を格納したMapを設定する。
	 *
	 * @param m リクエストスコープ上の変数を格納したMap
	 * @return このオブジェクト自体
	 */
	public ExecutionContext setSessionScopeMap(Map<String, Object> m) {
		sessionScopeMap = m;
		return this;
	}

	/**
	 * セッションスコープ情報を格納したMapオブジェクトへの参照を返す。
	 * <p/>
	 * このMapへの変更はセッションスコープに直接反映される。
	 *
	 * @return セッションスコープへの参照
	 */
	@Published
	public Map<String, Object> getSessionScopeMap() {
		return sessionScopeMap;
	}

	/**
	 * セッションスコープ上の変数の値を取得する。
	 *
	 * @param <T> 期待する変数の型
	 * @param varName 変数名
	 * @return 変数の値
	 * @throws ClassCastException
	 *           実際の変数の型が期待する変数の型と適合しなかった場合。
	 */
	@SuppressWarnings("unchecked")
	@Published
	public <T> T getSessionScopedVar(String varName) throws ClassCastException {
		return (T) getSessionScopeMap().get(varName);
	}

	/**
	 * セッションスコープ上の変数の値を設定する。
	 * <p/>
	 * 既に定義済みの変数は上書きされる。
	 *
	 * @param varName  変数名
	 * @param varValue 変数の値
	 * @return このオブジェクト自体
	 */
	@Published
	public ExecutionContext setSessionScopedVar(String varName, Object varValue) {
		getSessionScopeMap().put(varName, varValue);
		return this;
	}

	/**
	 * 現在のリクエストに紐付けられたセッションスコープを無効化する。
	 *
	 * @return このオブジェクト自体
	 */
	@Published
	public ExecutionContext invalidateSession() {
		sessionScopeMap.clear();
		return this;
	}

	/**
	 * 新規セッションであるかどうか。
	 *
	 * @return 新規セッションである場合は{@code true}
	 */
	@Published
	public boolean isNewSession() {
		// dummy implementation: always returns false.
		return false;
	}

	/**
	 * セッションがあるかどうか。
	 *
	 * @return セッションがある場合[@code true}
	 */
	public boolean hasSession() {
		// dummy implementation: always returns true.
		return true;
	}

	/**
	 * データリーダが、現時点で物理的に読み込んでいるレコードのレコード番号を設定する。
	 *
	 * @param lastRecordNumber 現時点で物理的に読み込んでいるレコードのレコード番号
	 */
	public void setLastRecordNumber(int lastRecordNumber) {
		this.lastRecordNumber = lastRecordNumber;
	}

	/**
	 * データリーダが、現時点で物理的に読み込んでいるレコードのレコード番号を返却する。
	 * <p/>
	 * 本メソッドは、{@link nablarch.fw.reader.FileDataReader}を使用してファイルを読み込んでいる場合にのみ値を返却する。
	 * FileDataReader以外を使用している場合は0を返す。
	 *
	 * @return 現時点で物理的に読み込んでいるレコードのレコード番号
	 */
	@Published
	public int getLastRecordNumber() {
		return lastRecordNumber;
	}

	/** ロガー */
	private static final Logger LOGGER = LoggerManager.get(ExecutionContext.class);

}
