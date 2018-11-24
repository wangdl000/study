package nablarch.core.log;

import nablarch.core.util.annotation.Published;

/**
 * ログを出力するインタフェース。<br/>
 * ログ出力機能の実装毎に本インタフェースの実装クラスを作成する。
 * <p>
 * アプリケーションから障害ログ出力を行う必要がある場合は、本インタフェースを直接使用するのではなく、
 * {@link nablarch.core.log.app.FailureLogUtil}を使用すること。
 * また、TRACEレベルのログ出力については、アプリケーション開発での使用は想定していない為、
 * 非公開としている。
 * </p>
 *
 * @author Kiyohito Itoh
 */
@Published(tag = "architect")
public interface Logger {

	/** システムプロパティ(line.separator)から取得した行区切り記号 */
	String LS = System.getProperty("line.separator");

	/**
	 * FATALレベルのログ出力が有効か否かを判定する。
	 * @return 有効な場合は<code>true</code>
	 */
	boolean isFatalEnabled();

	/**
	 * FATALレベルでログを出力する。
	 * @param message メッセージ
	 * @param options オプション情報(nullでも可)
	 */
	void logFatal(String message, Object... options);

	/**
	 * FATALレベルでログを出力する。
	 * @param message メッセージ
	 * @param error エラー情報(nullでも可)
	 * @param options オプション情報(nullでも可)
	 */
	void logFatal(String message, Throwable error, Object... options);

	/**
	 * ERRORレベルのログ出力が有効か否かを判定する。
	 * @return 有効な場合は<code>true</code>
	 */
	boolean isErrorEnabled();

	/**
	 * ERRORレベルでログを出力する。
	 * @param message メッセージ
	 * @param options オプション情報(nullでも可)
	 */
	void logError(String message, Object... options);

	/**
	 * ERRORレベルでログを出力する。
	 * @param message メッセージ
	 * @param error エラー情報(nullでも可)
	 * @param options オプション情報(nullでも可)
	 */
	void logError(String message, Throwable error, Object... options);

	/**
	 * WARNレベルのログ出力が有効か否かを判定する。
	 * @return 有効な場合は<code>true</code>
	 */
	@Published
	boolean isWarnEnabled();

	/**
	 * WARNレベルでログを出力する。
	 * @param message メッセージ
	 * @param options オプション情報(nullでも可)
	 */
	@Published
	void logWarn(String message, Object... options);

	/**
	 * WARNレベルでログを出力する。
	 * @param message メッセージ
	 * @param error エラー情報(nullでも可)
	 * @param options オプション情報(nullでも可)
	 */
	@Published
	void logWarn(String message, Throwable error, Object... options);

	/**
	 * INFOレベルのログ出力が有効か否かを判定する。
	 * @return 有効な場合は<code>true</code>
	 */
	@Published
	boolean isInfoEnabled();

	/**
	 * INFOレベルでログを出力する。
	 * @param message メッセージ
	 * @param options オプション情報(nullでも可)
	 */
	@Published
	void logInfo(String message, Object... options);

	/**
	 * INFOレベルでログを出力する。
	 * @param message メッセージ
	 * @param error エラー情報(nullでも可)
	 * @param options オプション情報(nullでも可)
	 */
	@Published
	void logInfo(String message, Throwable error, Object... options);

	/**
	 * DEBUGレベルのログ出力が有効か否かを判定する。
	 * @return 有効な場合は<code>true</code>
	 */
	@Published
	boolean isDebugEnabled();

	/**
	 * DEBUGレベルでログを出力する。
	 * @param message メッセージ
	 * @param options オプション情報(nullでも可)
	 */
	@Published
	void logDebug(String message, Object... options);

	/**
	 * DEBUGレベルでログを出力する。
	 * @param message メッセージ
	 * @param error エラー情報(nullでも可)
	 * @param options オプション情報(nullでも可)
	 */
	@Published
	void logDebug(String message, Throwable error, Object... options);

	/**
	 * TRACEレベルのログ出力が有効か否かを判定する。
	 * @return 有効な場合は<code>true</code>
	 */
	boolean isTraceEnabled();

	/**
	 * TRACEレベルでログを出力する。
	 * @param message メッセージ
	 * @param options オプション情報(nullでも可)
	 */
	void logTrace(String message, Object... options);

	/**
	 * TRACEレベルでログを出力する。
	 * @param message メッセージ
	 * @param error エラー情報(nullでも可)
	 * @param options オプション情報(nullでも可)
	 */
	void logTrace(String message, Throwable error, Object... options);
}
