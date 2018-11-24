package nablarch.core.log;

import java.text.DateFormat;
import java.util.Date;

import nablarch.core.util.annotation.Published;

/**
 * 日時を取得する出力項目の実装をサポートするクラス。
 * @author Kiyohito Itoh
 * @param <CTX> ログ出力項目の取得に使用するコンテキストの型
 */
@Published(tag = "architect")
public abstract class DateItemSupport<CTX> implements LogItem<CTX> {

	/** 日時フォーマット */
	private DateFormat dateFormat;

	/**
	 * コンストラクタ。
	 * @param dateFormat 日時フォーマット
	 */
	protected DateItemSupport(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * 日時を取得する。<br>
	 * {@link DateFormat}を排他制御した上で日時をフォーマットする。
	 * @param context ログ出力項目の取得に使用するコンテキスト
	 * @return フォーマット済みの日時
	 */
	public String get(CTX context) {
		synchronized (dateFormat) {
			return dateFormat.format(getDate(context));
		}
	}

	/**
	 * 日時を取得する。
	 * @param context ログ出力項目の取得に使用するコンテキスト
	 * @return 日時
	 */
	protected abstract Date getDate(CTX context);
}
