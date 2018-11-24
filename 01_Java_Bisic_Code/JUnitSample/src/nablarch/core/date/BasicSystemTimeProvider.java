package nablarch.core.date;

import java.sql.Timestamp;
import java.util.Date;

/**
 * {@link Date#Date()}を現在日時とする{@link SystemTimeProvider}。
 * 
 * @author Kiyohito Itoh
 */
public class BasicSystemTimeProvider implements SystemTimeProvider {

	/**
	 * 現在日時を取得する。
	 * 
	 * @return 現在日時
	 */
	public Date getDate() {
		return new Date();
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
