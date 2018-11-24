package nablarch.fw;

import java.util.Collection;
import java.util.List;

import nablarch.core.util.StringUtil;

/**
 * ハンドラキューとその上の各ハンドラを管理する機能を実装した抽象クラス。
 * 
 * @param <TSelf> 具象クラスの型
 * @author Iwauo Tajima
 */
public abstract class HandlerQueueManager<TSelf> {

	// ------------------------------------- must be implemented by a subclass
	/**
	 * 現在のハンドラキューの内容を返す。
	 * @return 現在のハンドラキューの内容
	 */
	@SuppressWarnings("rawtypes")
	public abstract List<Handler> getHandlerQueue();

	// ---------------------------------------------- HandlerQueue Management    
	/**
	 * ハンドラキューの内容を入れ替える。
	 * @param handlers ハンドラキュー
	 * @return このオブジェクト自体
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TSelf setHandlerQueue(Collection<? extends Handler> handlers) {
		getHandlerQueue().clear();
		addHandlers(handlers);
		return (TSelf) this;
	}

	/**
	 * ハンドラキューにハンドラを登録する。
	 * @param handlers 登録するハンドラ
	 * @return このオブジェクト自体
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TSelf addHandlers(Collection<? extends Handler> handlers) {
		if (handlers == null) {
			return (TSelf) this;
		}
		for (Handler<?, ?> handler : handlers) {
			addHandler(handler);
		}
		return (TSelf) this;
	}

	/**
	 * ハンドラーキューの内容をクリアする。
	 * @return このオブジェクト自体
	 */
	@SuppressWarnings("unchecked")
	public TSelf clearHandlers() {
		getHandlerQueue().clear();
		return (TSelf) this;
	}

	/**
	 * ハンドラキューにハンドラを登録する。
	 * 
	 * @param handler 登録するハンドラ
	 * @return このインスタンス自体
	 */
	public TSelf addHandler(Handler<?, ?> handler) {
		return addHandler(getHandlerQueue().size(), handler);
	}

	/**
	 * ハンドラキューにハンドラを登録する。
	 * 
	 * @param pos     ハンドラの挿入位置
	 * @param handler 登録するハンドラ
	 * @return このインスタンス自体
	 */
	@SuppressWarnings("unchecked")
	public TSelf addHandler(int pos, Handler<?, ?> handler) {
		if (handler == null) {
			throw new IllegalArgumentException("handler must not be null.");
		}
		Handler<?, ?> wrapped = Interceptor.Factory.wrap(handler);
		getHandlerQueue().add(pos, wrapped);
		return (TSelf) this;
	}

	/**
	 * ハンドラを登録する。
	 * 
	 * @param <TRequest> 登録するハンドラのリクエストオブジェクトの型
	 * @param requestPattern
	 *             このハンドラがキューに積まれるリクエストパス(Glob書式)
	 * @param handler
	 *             登録するハンドラ
	 * @return このインスタンス自体
	 */
	@SuppressWarnings("unchecked")
	public <TRequest extends Request<?>> TSelf addHandler(String requestPattern, Handler<TRequest, ?> handler) {
		if (StringUtil.isNullOrEmpty(requestPattern)) {
			throw new IllegalArgumentException(
					"requestPath must not be null or blank.");
		}
		if (handler == null) {
			throw new IllegalArgumentException(
					"handler must not be null.");
		}
		return addHandler(
				new RequestHandlerEntry<TRequest, Object>()
						.setRequestPattern(requestPattern)
						.setHandler((Handler<TRequest, Object>) handler));
	}

	/**
	 * ハンドラキュー上の各ハンドラのうち、
	 * 指定されたクラスのものを返す。
	 * <pre>
	 * 指定されたクラスのインスタンスが複数登録されていた場合は、
	 * もっとも上位ハのンドラを返す。
	 * 該当するハンドラが登録されていなかった場合はnullを返す。
	 * </pre>
	 * 
	 * @param <T> ハンドラのクラス
	 * @param handlerClass ハンドラのクラス
	 * @return ハンドラのインスタンス
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends Handler<?, ?>> T getHandlerOf(Class<T> handlerClass) {
		for (Handler<?, ?> handler : getHandlerQueue()) {
			Class<? extends Handler> clazz = handler.getClass();
			if (handlerClass.isAssignableFrom(clazz)) {
				return (T) handler;
			}
		}
		return null;
	}

	//--------------------------------------------- Method Level Delegation
	/** メソッドレベルの処理委譲を行うコンポーネント */
	private MethodBinder<?, ?> methodBinder = null;

	/**
	 * リクエストハンドラを登録する。
	 * <pre>
	 * 登録するオブジェクトは暗黙的に{@link nablarch.fw.web.HttpMethodBinding}でラップされる。
	 * すなわち、このメソッドの処理は以下のソースコードと等価である。
	 *     addHandler(uriPattern, new HttpMethodBinder(handler));
	 * </pre>
	 *
	 * @param uriPattern
	 *     リクエストハンドラが実行されるリクエストURIのパターン
	 *     (null,空文字は不可)
	 * @param handler
	 *      リクエストハンドラ (null不可)
	 * @return
	 *     このオブジェクト自体
	 * @see nablarch.fw.web.HttpMethodBinding
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TSelf addHandler(String uriPattern, Object handler) {
		if (handler instanceof Handler) {
			return (TSelf) addHandler(uriPattern, (Handler) handler);
		}
		if (!allowsMethodLevelDelegation()) {
			throw new IllegalArgumentException(
					"a handler must implement Handler interface.");
		}
		return addHandler(uriPattern, methodBinder.bind(handler));
	}

	/**
	 * リクエストハンドラを登録する。
	 * @param handler リクエストハンドラ
	 * @return このオブジェクト自体
	 */
	@SuppressWarnings({ "rawtypes" })
	public TSelf addHandler(Object handler) {
		if (handler instanceof Handler) {
			return addHandler((Handler) handler);
		}
		if (!allowsMethodLevelDelegation()) {
			throw new IllegalArgumentException(
					"a handler must implement Handler interface.");
		}
		return addHandler(methodBinder.bind(handler));
	}

	/**
	 * メソッド単位の処理委譲を行うか否か。
	 * @return メソッド単位の処理委譲を行う場合は true
	 */
	private boolean allowsMethodLevelDelegation() {
		return (methodBinder != null);
	}

	/**
	 * メソッドレベルの処理委譲を行うコンポーネントを指定する。
	 * @param binder 処理委譲を行うコンポーネント
	 * @return このインスタンス自体
	 */
	@SuppressWarnings("unchecked")
	public TSelf setMethodBinder(MethodBinder<?, ?> binder) {
		this.methodBinder = binder;
		return (TSelf) this;
	}

	/**
	 * メソッドレベルの処理委譲を行うコンポーネントを返す。
	 * @param <TData>   入力データの型
	 * @param <TResult> 結果データの型
	 * @return 処理委譲を行うコンポーネント
	 */
	@SuppressWarnings("unchecked")
	public <TData, TResult> MethodBinder<TData, TResult> getMethodBinder() {
		return (MethodBinder<TData, TResult>) this.methodBinder;
	}
}
