package nablarch.core.date;

import java.sql.Timestamp;
import java.util.Date;

import nablarch.core.util.annotation.Published;

/**
 * システム日時を提供するクラスのインタフェース。
 * 
 * @author Kiyohito Itoh
 */
@Published(tag = "architect")
public interface SystemTimeProvider {

	/**
	 * システム日時を取得する。
	 * 
	 * @return システム日時
	 */
	Date getDate();

	/**
	 * システム日時を取得する。
	 * 
	 * @return システム日時
	 */
	Timestamp getTimestamp();
}
