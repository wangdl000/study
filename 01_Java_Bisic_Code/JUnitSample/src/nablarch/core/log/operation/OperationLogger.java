package nablarch.core.log.operation;

import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;
import nablarch.core.log.basic.LogLevel;
import nablarch.core.util.annotation.Published;

/**
 * 運用担当者向けの通知ログを出力するロガー
 *
 * @author Naoki Yamamoto
 */
@Published
public final class OperationLogger {

	/** 隠蔽コンストラクタ */
	private OperationLogger() {
	}

	/** ロガー */
	private static final Logger LOGGER = LoggerManager.get("operator");

	/**
	 * メッセージをログに出力する。
	 *
	 * @param level ログレベル
	 * @param message メッセージ
	 */
	public static void write(final LogLevel level, final String message) {
		switch (level) {
		case FATAL:
			LOGGER.logFatal(message);
			break;
		case ERROR:
			LOGGER.logError(message);
			break;
		case WARN:
			LOGGER.logWarn(message);
			break;
		case INFO:
			LOGGER.logInfo(message);
			break;
		case DEBUG:
			LOGGER.logDebug(message);
			break;
		case TRACE:
			LOGGER.logTrace(message);
			break;
		}
	}

	/**
	 * メッセージをログに出力する。
	 * @param level ログレベル
	 * @param message メッセージ
	 * @param throwable 例外
	 */
	public static void write(final LogLevel level, final String message, final Throwable throwable) {
		switch (level) {
		case FATAL:
			LOGGER.logFatal(message, throwable);
			break;
		case ERROR:
			LOGGER.logError(message, throwable);
			break;
		case WARN:
			LOGGER.logWarn(message, throwable);
			break;
		case INFO:
			LOGGER.logInfo(message, throwable);
			break;
		case DEBUG:
			LOGGER.logDebug(message, throwable);
			break;
		case TRACE:
			LOGGER.logTrace(message, throwable);
			break;
		}
	}
}
