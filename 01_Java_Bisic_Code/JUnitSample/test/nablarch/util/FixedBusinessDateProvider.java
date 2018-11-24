package nablarch.util;

import java.util.Map;

import nablarch.core.date.BusinessDateProvider;

/**
 * 固定業務日付を提供するクラス<br>
 * 固定業務日付は、{@link #setFixedDate(String)}で設定する。<br>
 * デフォルト区分は、{@link #setDefaultSegment(String)}で設定する。
 * @author Miki Habu
 */
public class FixedBusinessDateProvider implements BusinessDateProvider {

	/**
	 * 固定日付 
	 */
	private Map<String, String> fixedDate;

	/**
	 * デフォルト区分
	 */
	private String defaultSegment;

	/**
	 * 固定日付を設定する。
	 * 
	 * @param fixedDate 区分をキー、日付を値としたマップ 
	 */
	public void setFixedDate(Map<String, String> fixedDate) {
		this.fixedDate = fixedDate;
	}

	/**
	 * デフォルト区分を設定する。
	 * @param defaultSegment デフォルト区分
	 */
	public void setDefaultSegment(String defaultSegment) {
		this.defaultSegment = defaultSegment;
	}

	/**
	 * {@inheritDoc}<br>
	 */
	public String getDate() {
		return getDate(defaultSegment);
	}

	/**
	 * {@inheritDoc}<br>
	 */
	public Map<String, String> getAllDate() {
		// 固定日付が初期化されていなければ例外
		if (fixedDate == null) {
			throw new IllegalStateException("fixed date was not initialized.");
		}

		return fixedDate;
	}

	/**
	 * {@inheritDoc}<br>
	 */
	public String getDate(String segment) {

		// 固定日付が初期化されていなければ例外
		if (fixedDate == null) {
			throw new IllegalStateException("fixed date was not initialized.");
		}

		// 日付の取得
		String ret = fixedDate.get(segment);

		// 日付が取得できなければ例外
		if (ret == null || ret.length() == 0) {
			throw new IllegalStateException(String.format("segment was not found. segment:%s.", segment));
		}

		return ret;
	}

	/**
	 *  本クラスは固定の業務日付を提供するため、このメソッドを使用して業務日付を設定することはできない。<br>
	 *  固定日付を設定する場合は、{@link #setFixedDate(String)}を使用すること。<br>
	 *
	 *  @param segment 区分値
	 *  @param date 日付
	 */
	public void setDate(String segment, String date) {
		throw new UnsupportedOperationException("fixed date can not change.");
	}

}
