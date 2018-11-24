package nablarch.core.date;

import java.util.Map;

import nablarch.core.util.annotation.Published;

/**
 * 業務日付を提供するクラスのインタフェース。
 * 
 * @author Kiyohito Itoh
 */
@Published(tag = "architect")
public interface BusinessDateProvider {

	/**
	 * デフォルトの区分を使用して業務日付を取得する。
	 * 
	 * @return 業務日付(yyyyMMdd形式)
	 */
	String getDate();

	/**
	 * 区分を指定して業務日付を取得する。
	 * 
	 * @param segment 区分値
	 * @return 業務日付(yyyyMMdd形式)
	 */
	String getDate(String segment);

	/**
	 * 全ての業務日付を取得する。
	 * 
	 * @return 区分をキー、対応する業務日付(yyyyMMdd形式)を値としたMap
	 */
	Map<String, String> getAllDate();

	/**
	 * 区分を指定して業務日付を設定する。
	 * @param segment 区分値
	 * @param date 業務日付(yyyyMMdd形式)
	 */
	void setDate(String segment, String date);
}
