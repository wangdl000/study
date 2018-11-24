package nablarch.core.log;

import static org.hamcrest.CoreMatchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

import nablarch.core.log.basic.LogLevel;

/**
 * ログ出力のテスト用ユーティリティ。<br>
 * <br>
 * "./log"をベースディレクトリとしてログファイル関連の処理を提供する。
 * 
 * @author Kiyohito Itoh
 */
public class LogTestUtil {

	/** 隠蔽コンストラクタ。 */
	private LogTestUtil() {
	}

	public static Date parseDate(String actual, DateFormat format, Pattern pattern) {
		Matcher m = pattern.matcher(actual);
		m.find();
		try {
			return format.parse(m.group(1));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 全てのログレベルでログ出力を行う。
	 */
	public static void logForAllLevels(Logger logger) {
		logger.logFatal("[[[FATALメッセージ]]]", "[[[FATALオプション情報]]]");
		logger.logFatal("[[[FATAL例外メッセージ]]]", new IllegalArgumentException("[[[FATAL例外]]]"), "[[[FATAL例外オプション情報]]]");
		logger.logError("[[[ERRORメッセージ]]]", "[[[ERRORオプション情報]]]");
		logger.logError("[[[ERROR例外メッセージ]]]", new IllegalArgumentException("[[[ERROR例外]]]"), "[[[ERROR例外オプション情報]]]");
		logger.logWarn("[[[WARNメッセージ]]]", "[[[WARNオプション情報]]]");
		logger.logWarn("[[[WARN例外メッセージ]]]", new IllegalArgumentException("[[[WARN例外]]]"), "[[[WARN例外オプション情報]]]");
		logger.logInfo("[[[INFOメッセージ]]]", "[[[INFOオプション情報]]]");
		logger.logInfo("[[[INFO例外メッセージ]]]", new IllegalArgumentException("[[[INFO例外]]]"), "[[[INFO例外オプション情報]]]");
		logger.logDebug("[[[DEBUGメッセージ]]]", "[[[DEBUGオプション情報]]]");
		logger.logDebug("[[[DEBUG例外メッセージ]]]", new IllegalArgumentException("[[[DEBUG例外]]]"), "[[[DEBUG例外オプション情報]]]");
		logger.logTrace("[[[TRACEメッセージ]]]", "[[[TRACEオプション情報]]]");
		logger.logTrace("[[[TRACE例外メッセージ]]]", new IllegalArgumentException("[[[TRACE例外]]]"), "[[[TRACE例外オプション情報]]]");
	}

	/**
	 * 指定されたレベルでログ出力を行う。
	 */
	public static void log(Logger logger, LogLevel level, String message, Throwable error, Object... options) {
		switch (level) {
		case FATAL:
			logger.logFatal(message, error, options);
			break;
		case ERROR:
			logger.logError(message, error, options);
			break;
		case WARN:
			logger.logWarn(message, error, options);
			break;
		case INFO:
			logger.logInfo(message, error, options);
			break;
		case DEBUG:
			logger.logDebug(message, error, options);
			break;
		case TRACE:
			logger.logTrace(message, error, options);
		}
	}

	/**
	 * {@link #logForAllLevels(Logger)}に対するアサーションを行う。
	 */
	public static void assertLog(String log, LogLevel[] enabled, LogLevel[] disabled) {
		assertLog(log, enabled, disabled, true, true);
	}

	/**
	 * {@link #logForAllLevels(Logger)}に対するアサーションを行う。
	 */
	public static void assertLog(File logFile, LogLevel[] enabled, LogLevel[] disabled) {
		assertLog(logFile, enabled, disabled, true);
	}

	/**
	 * {@link #logForAllLevels(Logger)}に対するアサーションを行う。
	 */
	public static void assertLog(File logFile, LogLevel[] enabled, LogLevel[] disabled, boolean isOptionCheck) {
		assertLog(getLog(logFile), enabled, disabled, isOptionCheck, true);
	}

	/**
	 * {@link #logForAllLevels(Logger)}に対するアサーションを行う。
	 */
	public static void assertLog(String log, LogLevel[] enabled, LogLevel[] disabled, boolean isOptionCheck) {
		assertLog(log, enabled, disabled, isOptionCheck, true);
	}

	/**
	 * {@link #logForAllLevels(Logger)}に対するアサーションを行う。
	 */
	public static void assertLog(File logFile, LogLevel[] enabled, LogLevel[] disabled, boolean isOptionCheck,
			boolean isStackTraceCheck) {
		assertLog(getLog(logFile), enabled, disabled, isOptionCheck, isStackTraceCheck);
	}

	/**
	 * {@link #logForAllLevels(Logger)}に対するアサーションを行う。
	 */
	public static void assertLog(String log, LogLevel[] enabled, LogLevel[] disabled, boolean isOptionCheck,
			boolean isStackTraceCheck) {
		for (LogLevel level : enabled) {
			Assert.assertThat("[[[" + level.name() + "メッセージ]]]" + Logger.LS + log,
					log.indexOf("[[[" + level.name() + "メッセージ]]]"), not(is(-1)));
			if (isOptionCheck) {
				Assert.assertThat("[[[" + level.name() + "オプション情報]]]" + Logger.LS + log,
						log.indexOf("[[[" + level.name() + "オプション情報]]]"), not(is(-1)));
				Assert.assertThat("[[[" + level.name() + "オプション情報]]]" + Logger.LS + log,
						log.indexOf("[[[" + level.name() + "オプション情報]]]"), not(is(-1)));
			}
			Assert.assertThat("[[[" + level.name() + "例外メッセージ]]]" + Logger.LS + log,
					log.indexOf("[[[" + level.name() + "例外メッセージ]]]"), not(is(-1)));
			if (isStackTraceCheck) {
				Assert.assertThat("[[[" + level.name() + "例外]]]" + Logger.LS + log,
						log.indexOf("[[[" + level.name() + "例外]]]"), not(is(-1)));
			}
		}
		for (LogLevel level : disabled) {
			Assert.assertThat("[[[" + level.name() + "メッセージ]]]" + Logger.LS + log,
					log.indexOf("[[[" + level.name() + "メッセージ]]]"), is(-1));
			if (!isOptionCheck) {
				Assert.assertThat("[[[" + level.name() + "オプション情報]]]" + Logger.LS + log,
						log.indexOf("[[[" + level.name() + "オプション情報]]]"), is(-1));
				Assert.assertThat("[[[" + level.name() + "オプション情報]]]" + Logger.LS + log,
						log.indexOf("[[[" + level.name() + "オプション情報]]]"), is(-1));
			}
			Assert.assertThat("[[[" + level.name() + "例外メッセージ]]]" + Logger.LS + log,
					log.indexOf("[[[" + level.name() + "例外メッセージ]]]"), is(-1));
			if (!isStackTraceCheck) {
				Assert.assertThat("[[[" + level.name() + "例外]]]" + Logger.LS + log,
						log.indexOf("[[[" + level.name() + "例外]]]"), is(-1));
			}
		}
	}

	/**
	 * ファイルを生成する。
	 * @param filePath ファイルパス
	 * @return ファイル
	 */
	public static File createFile(String filePath) {
		return new File("./log" + filePath);
	}

	/**
	 * テストで使用するログファイルを作成する。
	 * @param filePath 新規に作成するファイルのパス
	 * @return 作成したログファイル
	 */
	public static File cleanupLog(String filePath) {
		String dirName = "./log";
		File dir = new File(dirName);
		if (!dir.exists()) {
			boolean isMadeDir = dir.mkdir();
			if (isMadeDir) {
				System.out.println(dir.getAbsolutePath() + "を作成しました。");
			}
		}
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (!list[i].isFile()) {
				continue;
			}
			boolean isDeleted = list[i].delete();
			if (isDeleted) {
				System.out.println(list[i].getAbsolutePath() + "を削除しました。");
			}
		}
		return new File(dirName + filePath);
	}

	/**
	 * テストで出力したログを取得する。
	 * @param file ログファイル
	 * @return テストで出力したログ
	 */
	public static String getLog(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[(int) file.length()];
			System.out.println(file.getName() + ": " + file.length());
			fis.read(b);
			fis.close();
			return new String(b);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}
