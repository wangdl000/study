package nablarch.core.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nablarch.core.ThreadContext;
import nablarch.core.util.annotation.Published;

/**
 * 国際化に使用するユーティリティクラス。
 * 
 * @author Koichi Asano
 */
@Published
public final class I18NUtil {

	/**
	 * 隠蔽コンストラクタ。
	 */
	private I18NUtil() {
	}

	/**
	 * ロケールの書式
	 */
	static final Pattern LOCALE_SYNTAX = Pattern.compile(Builder.lines(
			"^                     ", "  ([a-z]{2})          " //キャプチャ#1: 言語コード(ISO-639)
			, "  (?:                 ", "    _([A-Z]{2}|)      " //キャプチャ#2: 国コード(ISO-3166)
			, "    (?:               ", "      _([A-Za-z0-9]+) " //キャプチャ#3: 補助コード
			, "    )?                ", "  )?                  ", "$                     "), Pattern.COMMENTS);

	/**
	 * ロケール表現からロケールオブジェクトを作成する。
	 * <p/>
	 * {@code localeExpression}は以下のシンタックスに従って指定する。
	 * <pre>
	 * ([a-z]{2})                    // 言語コード(ISO-639)
	 *     (?:_([A-Z]{2}|)           // 国コード(ISO-3166)
	 *         (?:_([A-Za-z0-9]+))?  // 補助コード
	 *     )?
	 * </pre>
	 * ロケール表現の例
	 * <ul>
	 *     <li>ja</li>
	 *     <li>ja_JP</li>
	 *     <li>ja_JP_variant</li>
	 * </ul>
	 *
	 * @param localeExpression 文字列によるロケールの表現
	 * @return 作成したロケールオブジェクト
	 * @throws IllegalArgumentException {@code localeExpression}がシンタックスに適合しない場合
	 * @see Locale
	 */
	public static Locale createLocale(String localeExpression) {
		Matcher m = LOCALE_SYNTAX.matcher(localeExpression);
		if (!m.matches()) {
			throw new IllegalArgumentException(
					"Invalid locale: " + localeExpression);
		}

		String language = m.group(1);
		String country = m.group(2);
		String variant = m.group(3);
		return new Locale(
				language,
				(country == null) ? "" : country,
				(variant == null) ? "" : variant);
	}

	/**
	 * フォーマットを指定して日時を文字列に変換する。
	 * <p/>
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 * <p/>
	 * このメソッドは{@link #formatDateTime(Date, String, Locale, TimeZone)}}を呼び出す。
	 * ロケール及びタイムゾーンは、{@link ThreadContext}から取得する。
	 * 取得できなかった場合、デフォルトのロケール及びタイムゾーンを使用する。
	 *
	 * @param date 日時(null不可)
	 * @param format フォーマット(null不可)
	 * @return 変換した値
	 * @see #formatDateTime(Date, String, Locale, TimeZone)
	 */
	public static String formatDateTime(Date date, String format) {
		Locale locale = ThreadContext.getLanguage();
		if (locale == null) {
			locale = Locale.getDefault();
		}
		TimeZone tz = ThreadContext.getTimeZone();
		if (tz == null) {
			tz = TimeZone.getDefault();
		}
		return formatDateTime(date, format, locale, tz);
	}

	/**
	 * フォーマットと言語を指定して日時を文字列に変換する。
	 * <p/>
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 * <p/>
	 * このメソッドは{@link #formatDateTime(Date, String, Locale, TimeZone)} }を呼び出す。
	 * タイムゾーンは、{@link ThreadContext}から取得する。
	 * 取得できなかった場合、デフォルトのタイムゾーンを使用する。
	 *
	 * @param date 日時(null不可)
	 * @param format フォーマット(null不可)
	 * @param locale ロケール(null不可)
	 * @return 変換した値
	 * @see #formatDateTime(Date, String, Locale, TimeZone)
	 */
	public static String formatDateTime(Date date, String format, Locale locale) {
		TimeZone tz = ThreadContext.getTimeZone();
		if (tz == null) {
			tz = TimeZone.getDefault();
		}
		return formatDateTime(date, format, locale, tz);
	}

	/**
	 * フォーマット、言語、タイムゾーンを指定して日時を文字列に変換する。
	 * <p/>
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 * <p/>
	 * 例:
	 * <code><pre>
	 * TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");
	 * Date date = Calendar.getInstance(timeZone).getTime(); //--> 2011/09/09 17:22:48
	 * String format = "yyyy/MM/dd HH:mm:ss";
	 * 
	 * I18NUtil.formatDateTime(date, format, timeZone); //--> "2011/09/09 17:22:48"
	 * 
	 * timeZone = TimeZone.getTimeZone("Europe/Madrid");
	 * I18NUtil.formatDateTime(date, format, timeZone); //--> "2011/09/09 10:22:48"
	 * </pre></code>
	 * @param date 日時(null不可)
	 * @param format フォーマット(null不可)
	 * @param locale ロケール(null不可)
	 * @param timeZone タイムゾーン(null不可)
	 * @return 変換した値
	 * @throws IllegalArgumentException フォーマットが不正な場合
	 */
	public static String formatDateTime(Date date, String format, Locale locale, TimeZone timeZone) {

		if (date == null) {
			throw new IllegalArgumentException("date must not be null.");
		}
		if (format == null) {
			throw new IllegalArgumentException("format must not be null.");
		}
		if (locale == null) {
			throw new IllegalArgumentException("locale must not be null.");
		}
		if (timeZone == null) {
			throw new IllegalArgumentException("timeZone must not be null.");
		}

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);
			dateFormat.setTimeZone(timeZone);
			return dateFormat.format(date);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(
					String.format("format failed. date = [%s] format = [%s] timeZone = [%s]",
							date, format, timeZone.getID()),
					e);
		}
	}

	/**
	 * 指定されたフォーマットと言語を使用して10進数を変換する。
	 * <p/>
	 * このメソッドは{@link nablarch.core.util.I18NUtil#formatDecimal(Number, String, Locale)}を呼び出す。
	 * 言語は、{@link ThreadContext}から取得する。
	 *
	 * @param number 10進数(null不可)
	 * @param format フォーマット(null不可)
	 * @return 変換した値
	 * @see nablarch.core.util.I18NUtil#formatDecimal(Number, String, Locale)
	 */
	public static String formatDecimal(Number number, String format) {
		return formatDecimal(number, format, ThreadContext.getLanguage());
	}

	/**
	 * 指定されたフォーマットと言語を使用して10進数を変換する。
	 * <p/>
	 * 指定するフォーマットは{@link DecimalFormat}の仕様に準拠すること。
	 * <p/>
	 * 例:
	 * <code><pre>
	 * Number number = BigDecimal.valueOf(123456789.123D);
	 * String format = "###,###,###.000";
	 * 
	 * Locale language = new Locale("ja");
	 * I18NUtil.formatDecimal(number, format, language); //--> "123,456,789.123"
	 * 
	 * language = new Locale("es");
	 * I18NUtil.formatDecimal(number, format, language); //--> "123.456.789,123"
	 * </pre></code>
	 * @param number 10進数(null不可)
	 * @param format フォーマット(null不可)
	 * @param language 言語(null不可)
	 * @return 変換した値
	 * @throws IllegalArgumentException フォーマットが不正な場合
	 */
	public static String formatDecimal(Number number, String format, Locale language) {

		if (number == null) {
			throw new IllegalArgumentException("number must not be null.");
		}
		if (format == null) {
			throw new IllegalArgumentException("format must not be null.");
		}
		if (language == null) {
			throw new IllegalArgumentException("language must not be null.");
		}

		try {
			DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(language);
			decimalFormat.applyPattern(format);
			return decimalFormat.format(number);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(
					String.format("format failed. number = [%s] format = [%s] language = [%s]",
							number, format, language),
					e);
		}
	}
}
