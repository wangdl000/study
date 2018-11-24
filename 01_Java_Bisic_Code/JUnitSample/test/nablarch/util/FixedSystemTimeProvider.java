package nablarch.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import nablarch.core.date.SystemTimeProvider;

/**
 * 固定日時を提供するクラス。
 * <br>
 * 固定日時は{@link #setFixedDate(String)}で指定する。
 * 
 * @author Kiyohito Itoh
 */
public class FixedSystemTimeProvider implements SystemTimeProvider {

	/**
	 * 固定日時
	 */
	private Date fixedDate;

	/** デフォルトコンストラクタ。 */
	public FixedSystemTimeProvider() {
	}

	/**
	 * コンストラクタ。
	 * 指定された引数で初期化を行う。
	 * @param yyyyMMddHHmmss 固定日時(形式：yyyyMMddHHmmss)
	 */
	public FixedSystemTimeProvider(String yyyyMMddHHmmss) {
		setFixedDate(yyyyMMddHHmmss);
	}

	/**
	 * 固定日時を設定する。
	 * @param yyyyMMddHHmmss 固定日時(形式：yyyyMMddHHmmss)
	 */
	public void setFixedDate(String yyyyMMddHHmmss) {
		try {
			fixedDate = new SimpleDateFormat("yyyyMMddHHmmss").parse(yyyyMMddHHmmss);
		} catch (ParseException e) {
			throw new IllegalArgumentException("invalid date format. expected=yyyyMMddHHmmss, actual=" + yyyyMMddHHmmss,
					e);
		}
	}

	/**
	 * 現在日時を取得する。
	 * 
	 * @return 現在日時
	 */
	public Date getDate() {
		if (fixedDate == null) {
			throw new IllegalStateException("uninitialized.");
		}
		return fixedDate;
	}

	/**
	 * 現在日時を取得する。
	 * 
	 * @return 現在日時
	 */
	public Timestamp getTimestamp() {
		return new Timestamp(getDate().getTime());
	}
}
