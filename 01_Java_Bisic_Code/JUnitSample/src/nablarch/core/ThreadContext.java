package nablarch.core;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import nablarch.core.util.annotation.Published;

/**
 * スレッド内で共有すべきオブジェクトを保持するクラス。
 * <p/>
 * 本クラスで保持する値は、子スレッドが起動された場合、
 * 暗黙的に全ての情報を子スレッドに引き継ぐ仕様となっている。
 * このため、子スレッドでは個別に値を設定することなく、親スレッドで設定した値を使用することが出来る。
 * また、子スレッドで個別に値を変更することも出来るが、ThreadLocalに格納したオブジェクトは各スレッドで共有され、
 * 別スレッドの動作に影響を与える危険があるので、イミュータブルな値とスレッドセーフな値のみを格納すること。
 *
 * @author Koichi Asano
 */
@Published(tag = "architect")
public final class ThreadContext {

	/** 言語のキー。 */
	public static final String LANG_KEY = "LANG";

	/** タイムゾーンのキー。 */
	public static final String TIME_ZONE_KEY = "TIME_ZONE";

	/** ユーザIDのキー。 */
	public static final String USER_ID_KEY = "USER_ID";

	/** リクエストIDのキー。 */
	public static final String REQUEST_ID_KEY = "REQUEST_ID";

	/** 内部リクエストIDのキー。 */
	public static final String INTERNAL_REQUEST_ID_KEY = "INTERNAL_REQUEST_ID";

	/** 実行時IDのキー。 */
	public static final String EXECUTION_ID_KEY = "EXECUTION_ID";

	/** 並行実行スレッド数のキー。 */
	public static final String CONCURRENT_NUMBER_KEY = "CONCURRENT_NUMBER_KEY";

	/** スレッド内で共有するオブジェクトを保持するThreadLocal。 */
	private static ThreadLocal<Map<String, Object>> genericObjects = new InheritableThreadLocal<Map<String, Object>>() {
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}

		@Override
		protected Map<String, Object> childValue(
				Map<String, Object> parentValue) {
			return new HashMap<String, Object>(parentValue);
		}
	};

	/** 隠蔽コンストラクタ。 */
	private ThreadContext() {
	}

	/**
	 * スレッドローカルから言語を取得する。
	 * @return 言語
	 */
	@Published
	public static Locale getLanguage() {
		return (Locale) genericObjects.get().get(LANG_KEY);
	}

	/**
	 * スレッドローカルに言語を設定する。
	 * @param locale 言語
	 */
	public static void setLanguage(Locale locale) {
		genericObjects.get().put(LANG_KEY, locale);
	}

	/**
	 * スレッドローカルからタイムゾーンを取得する。
	 * @return タイムゾーン
	 */
	@Published
	public static TimeZone getTimeZone() {
		return (TimeZone) genericObjects.get().get(TIME_ZONE_KEY);
	}

	/**
	 * スレッドローカルにタイムゾーンを設定する。
	 * @param timeZone タイムゾーン
	 */
	public static void setTimeZone(TimeZone timeZone) {
		genericObjects.get().put(TIME_ZONE_KEY, timeZone);
	}

	/**
	 * スレッドローカルからユーザIDを取得する。
	 * @return ユーザID
	 */
	@Published
	public static String getUserId() {
		return (String) getObject(USER_ID_KEY);
	}

	/**
	 * スレッドローカルにユーザIDを設定する。
	 * @param userId ユーザID
	 */
	public static void setUserId(String userId) {
		setObject(USER_ID_KEY, userId);
	}

	/**
	 * スレッドローカルからリクエストIDを取得する。
	 * @return リクエストID
	 */
	@Published
	public static String getRequestId() {
		return (String) getObject(REQUEST_ID_KEY);
	}

	/**
	 * スレッドローカルにリクエストIDを設定する。
	 * @param requestId リクエストID
	 */
	public static void setRequestId(String requestId) {
		setObject(REQUEST_ID_KEY, requestId);
	}

	/**
	 * スレッドローカルから内部リクエストIDを取得する。
	 * @return 内部リクエストID
	 */
	@Published
	public static String getInternalRequestId() {
		return (String) getObject(INTERNAL_REQUEST_ID_KEY);
	}

	/**
	 * スレッドローカルに内部リクエストIDを設定する。
	 * @param requestId 内部リクエストID
	 */
	public static void setInternalRequestId(String requestId) {
		setObject(INTERNAL_REQUEST_ID_KEY, requestId);
	}

	/**
	 * スレッドローカルから実行時IDを取得する。
	 * @return 実行時ID
	 */
	@Published
	public static String getExecutionId() {
		return (String) getObject(EXECUTION_ID_KEY);
	}

	/**
	 * スレッドローカルに実行時IDを設定する。
	 * @param executionId 実行時ID
	 */
	public static void setExecutionId(String executionId) {
		setObject(EXECUTION_ID_KEY, executionId);
	}

	/**
	 * スレッドコンテキストにオブジェクトを設定する。
	 * 
	 * @param key オブジェクトのキー
	 * @param object 設定するオブジェクト
	 */
	public static void setObject(String key, Object object) {
		ThreadContext.genericObjects.get().put(key, object);
	}

	/**
	 * スレッドコンテキストからオブジェクトを取得する。
	 * 
	 * @param key オブジェクトのキー
	 * @return 取得したオブジェクト
	 */
	public static Object getObject(String key) {
		return ThreadContext.genericObjects.get().get(key);
	}

	/**
	 * スレッドコンテキストの内容をクリアする。
	 */
	public static void clear() {
		genericObjects.remove();
	}

	/**
	 * スレッドコンテキストから並行実行スレッド数を取得する。
	 * @return 並行実行スレッド数
	 */
	public static int getConcurrentNumber() {
		Integer concurrentNumber = (Integer) ThreadContext.genericObjects.get().get(CONCURRENT_NUMBER_KEY);
		if (concurrentNumber == null) {
			return 1;
		}
		return concurrentNumber.intValue();
	}

	/**
	 * スレッドコンテキストに並行実行スレッド数を設定する。
	 * 
	 * @param value 並行実行スレッド数
	 */
	public static void setConcurrentNumber(int value) {
		ThreadContext.genericObjects.get().put(CONCURRENT_NUMBER_KEY, value);
	}

}
