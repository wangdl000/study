package nablarch.core.text;

import nablarch.core.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日付文字列をフォーマットするクラス
 *
 * @author Ryota Yoshinouchi
 */
public class DateTimeStrFormatter implements Formatter<String> {

	/**
	 * フォーマッタの名前
	 */
	private String formatterName = "dateTime";

	/**
	 * デフォルトのフォーマットパターン
	 */
	private String defaultPattern = "yyyy/MM/dd";

	/**
	 * デフォルトの日付文字列のパターン
	 */
	private String dateStrPattern = "yyyyMMdd";

	@Override
	public Class<String> getFormatClass() {
		return String.class;
	}

	@Override
	public String getFormatterName() {
		return formatterName;
	}

	/**
	 * デフォルトの書式で日付文字列をフォーマットする。
	 * フォーマット対象がnullの場合はnullを返却する。
	 * フォーマット対象の日付文字列が日付型にパース出来ない場合はフォーマットせずに返却する。
	 *
	 * @param input フォーマット対象
	 * @return フォーマットされた文字列
	 */
	@Override
	public String format(String input) {
		return format(input, defaultPattern);
	}

	/**
	 * 指定された書式で日付をフォーマットする。
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 * フォーマット対象がnullの場合はnullを返却する。
	 * フォーマット対象の日付文字列が日付型にパース出来ない場合はフォーマットせずに返却する。
	 *
	 * @param input   フォーマット対象
	 * @param pattern フォーマットの書式
	 * @return フォーマットされた文字列
	 */
	@Override
	public String format(String input, String pattern) {
		if (StringUtil.isNullOrEmpty(pattern)) {
			throw new IllegalArgumentException("pattern must not be null.");
		}
		if (StringUtil.isNullOrEmpty(dateStrPattern)) {
			throw new IllegalArgumentException("dateStrPattern must not be null.");
		}
		if (StringUtil.isNullOrEmpty(input)) {
			return input;
		}

		Locale locale = Locale.getDefault();
		SimpleDateFormat dateFormat;
		try {
			dateFormat = new SimpleDateFormat(dateStrPattern, locale);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					String.format("dateStrPattern is invalid pattern.  dateStrPattern = [%s]",
							dateStrPattern),
					e);
		}
		Date date;
		try {
			date = dateFormat.parse(input);
		} catch (ParseException pe) {
			return input;
		}
		try {
			return new SimpleDateFormat(pattern, locale).format(date);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					String.format("format failed. input = [%s] pattern = [%s] locale = [%s]",
							input, pattern, locale),
					e);
		}
	}

	/**
	 * フォーマッタの名前を設定する。
	 *
	 * @param formatterName フォーマッタの名前
	 */
	public void setFormatterName(String formatterName) {
		this.formatterName = formatterName;
	}

	/**
	 * フォーマットのデフォルトの書式を設定する。
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 *
	 * @param defaultPattern フォーマットのデフォルトの書式
	 */
	public void setDefaultPattern(String defaultPattern) {
		this.defaultPattern = defaultPattern;
	}

	/**
	 * フォーマットする日付文字列の形式を設定する。
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 *
	 * @param dateStrPattern フォーマットする日付文字列の形式
	 */
	public void setDateStrPattern(String dateStrPattern) {
		this.dateStrPattern = dateStrPattern;
	}
}
