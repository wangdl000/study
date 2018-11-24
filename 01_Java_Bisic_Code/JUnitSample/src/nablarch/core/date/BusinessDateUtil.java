package nablarch.core.date;

import java.util.Map;

import nablarch.core.repository.SystemRepository;
import nablarch.core.util.annotation.Published;

/**
 * 業務日付を取得するユーティリティクラス。
 * <p/>
 * 業務日付の取得処理は{@link BusinessDateProvider}によって提供される。
 * BusinessDateProviderの実装は、{@link SystemRepository}からコンポーネント名 businessDateProvider で取得される。
 * <p/>
 * 業務日付の複数設定について<br/>
 * 本フレームワークでは、オンラインとバッチで別の業務日付を使用するなど、用途ごとに複数の業務日付を管理できる。
 * 業務日付には、それぞれを識別するための「区分」が設定される。
 * 本クラスは、区分を指定して業務日付を取得する機能を提供する。
 *
 * @author Miki Habu
 */
@Published
public final class BusinessDateUtil {

	/**
	 * 業務日付取得コンポーネント名。
	 */
	private static final String DATE_PROVIDER = "businessDateProvider";

	/**
	 * 隠蔽コンストラクタ
	 */
	private BusinessDateUtil() {
	}

	/**
	 * 業務日付を取得する。区分はデフォルトを使用する。
	 * 
	 * @return 業務日付(yyyyMMdd形式)
	 */
	public static String getDate() {
		return getProvider().getDate();
	}

	/**
	 * 区分を指定して、業務日付を取得する。
	 * 
	 * @param segment 区分
	 * @return 指定された区分の業務日付(yyyyMMdd形式)
	 */
	public static String getDate(String segment) {
		return getProvider().getDate(segment);
	}

	/**
	 * 全区分の業務日付を取得する。
	 * 
	 * @return 区分をキー、対応する業務日付(yyyyMMdd形式)を値としたMap
	 */
	public static Map<String, String> getAllDate() {
		return getProvider().getAllDate();
	}

	/**
	 * 業務日付取得コンポーネントを取得する。
	 * 
	 * @return 業務日付取得コンポーネント
	 */
	private static BusinessDateProvider getProvider() {
		BusinessDateProvider provider = (BusinessDateProvider) SystemRepository.get(DATE_PROVIDER);
		if (provider == null) {
			throw new IllegalArgumentException(
					"specified " + DATE_PROVIDER + " is not registered in SystemRepository.");
		}
		return provider;
	}
}
