package nablarch.core.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import nablarch.core.ThreadContext;
import nablarch.core.util.annotation.Published;

/**
 * 日付ユーティリティ。
 *
 * @author Miki Habu
 */
public final class DateUtil {

	/** privateコンストラクタ */
	private DateUtil() {
	}

	/**
	 * 日付文字列(yyyyMMdd形式)から{@link java.util.Date}クラスのインスタンスを取得する。
	 *
	 * @param date 日付文字列(yyyyMMdd形式)
	 * @return 日付文字列の日付が設定された、{@link java.util.Date}クラスのインスタンス
	 * @throws IllegalArgumentException 日付文字列のフォーマットが yyyyMMdd形式ではなかった場合
	 */
	@Published
	public static Date getDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date ret;
		try {
			ret = sdf.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(
					"the string was not formatted yyyyMMdd. date = " + date
							+ ".",
					e);
		}
		return ret;
	}

	/**
	 * 日付文字列(yyyyMMdd形式)を指定された形式でフォーマットする。
	 *
	 * @param date フォーマット対象の日付文字列(yyyyMMdd形式)
	 * @param pattern 日付のフォーマットを記述するパターン(yyyy/MM/ddなど。{@link java.text.SimpleDateFormat}参照)
	 * @return フォーマットされた日付文字列
	 * @throws IllegalArgumentException 日付文字列のフォーマットが yyyyMMdd形式ではなかった場合
	 */
	@Published
	public static String formatDate(String date, String pattern) {
		String des;
		SimpleDateFormat srcFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat desFormat = new SimpleDateFormat(pattern);
		try {
			des = desFormat.format(srcFormat.parse(date));
		} catch (ParseException e) {
			throw new IllegalArgumentException(
					"the string was not formatted yyyyMMdd. date = " + date
							+ '.',
					e);
		}
		return des;
	}

	/**
	 * 指定された日付(yyyyMMdd形式)を指定された日数分加減算する。<br/>
	 * <p/>
	 * 負の値が指定された場合は、減算を行う。
	 * <p/>
	 * 例）addDay("19991231", 1) //--> "20000101"<br>
	 *
	 * @param date 日付文字列（yyyyMMdd形式）
	 * @param days 加減算する日数（負の値の場合は、減算を行う。)
	 * @return 計算後の日付文字列（yyyyMMdd形式）
	 */
	@Published
	public static String addDay(String date, int days) {
		Calendar cal = getCalendar(date);
		cal.add(Calendar.DATE, days);
		return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
	}

	/**
	 * 指定された日付(yyyyMMdd or yyyyMM形式)を指定された月数分加減算する。<br/>
	 * <p/>
	 * 負の値が指定された場合は、減算を行う。
	 * <p/>
	 * 例）addMonth("19991231", 1) //--> "20000131"<br>
	 *
	 * @param date 日付文字列(yyyyMMdd or yyyyMM形式)
	 * @param month 加減算する月数(負の値の場合は、減算を行う。)
	 * @return 計算後の日付文字列
	 */
	@Published
	public static String addMonth(String date, int month) {

		String returnFormat = "yyyyMMdd";
		if (date.length() == 6) {
			returnFormat = "yyyyMM";
			date += "01";
		}

		Calendar cal = getCalendar(date);
		cal.add(Calendar.MONTH, month);
		SimpleDateFormat sdf = new SimpleDateFormat(returnFormat);
		return sdf.format(cal.getTime());
	}

	/**
	 * 指定された日付間の日数を取得する。<br/>
	 * <p/>
	 * 例）getDays("19991231", "20000101") //--> 1<br>
	 *
	 * @param dateFrom 開始日付文字列（yyyyMMdd形式）
	 * @param dateTo 終了日付文字列（yyyyMMdd形式）
	 * @return 日数（同一日であれば0、 開始日付文字列 ＞ 終了日付文字列であればマイナス値）
	 */
	@Published
	public static long getDays(String dateFrom, String dateTo) {
		Calendar calFrom = getCalendar(dateFrom);
		Calendar calTo = getCalendar(dateTo);
		return (calTo.getTime().getTime() - calFrom.getTime().getTime())
				/ (60 * 60 * 24 * 1000);
	}

	/**
	 * 指定された日付(yyyyMMdd or yyyyMM形式)間の月数を取得する。
	 * <p/>
	 * 例)<br/>
	 * <code>
	 * DateUtil.getMonths("201102", "201103"); //--> 1
	 * </code>
	 *
	 * @param monthFrom 開始日付文字列(yyyyMMdd or yyyyMM形式)
	 * @param monthTo 終了日付文字列(yyyyMMdd or yyyyMM形式)
	 * @return 月数（同一日であれば0、 開始日付文字列 ＞ 終了日付文字列であればマイナス値）
	 */
	@Published
	public static int getMonths(String monthFrom, String monthTo) {
		int passedYear = Integer.parseInt(monthTo.substring(0, 4))
				- Integer.parseInt(monthFrom.substring(0, 4));
		int passedMonth = Integer.parseInt(monthTo.substring(4, 6))
				- Integer.parseInt(monthFrom.substring(4, 6));

		return (12 * passedYear) + passedMonth;
	}

	/**
	 * 指定された日付(yyyyMMdd or yyyyMM形式)の月末日を取得する。
	 *
	 * @param date 日付(yyyyMMdd or yyyyMM形式)
	 * @return 指定された日付の月末日
	 */
	@Published
	public static String getMonthEndDate(String date) {
		if (date.length() == 6) {
			date += "01";
		}
		Calendar calendar = getCalendar(date);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
	}

	/**
	 * 与えられた日付に設定された{@link java.util.Calendar}インスタンスを返す。
	 *
	 * @param date 日付文字列(yyyyMMdd形式)
	 * @return 与えられた日付に設定された{@link java.util.Calendar}インスタンス
	 */
	private static Calendar getCalendar(String date) {
		Calendar ret = Calendar.getInstance();

		ret.set(Integer.parseInt(date.substring(0, 4)),
				Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)),
				0, 0, 0);
		ret.set(Calendar.MILLISECOND, 0);
		return ret;
	}

	/**
	 * このメソッドはロケールに{@link Locale#getDefault()}を使用して、{@link #isValid(String, String, Locale)}を呼び出す。 <br/>
	 *
	 * @param date   バリデーション対象日付文字列
	 * @param format フォーマット
	 * @return dateがformat形式で、実在する日であれば{@code true}
	 * @throws IllegalArgumentException dateが{@code null}か、formatが{@code null}または空文字の場合
	 */
	@Published
	public static boolean isValid(String date, String format) {
		return isValid(date, format, Locale.getDefault());
	}

	/**
	 * 指定された日付文字列がフォーマットどおりであり、実在する日であることをバリデーションする。<br>
	 * フォーマットには{@link SimpleDateFormat}にて定められたフォーマットを指定する。</br>
	 * 例)<br/>
	 * <code><pre>
	 * //2016年3月31日は存在するため、true。
	 * DateUtil.isValid("20160331", "yyyyMMdd"); //--> true
	 *
	 * //2016年3月32日は存在しないため、false。
	 * DateUtil.isValid("20160332", "yyyyMMdd"); //--> false
	 * </pre></code>
	 *
	 * @param date   バリデーション対象日付文字列
	 * @param format フォーマット
	 * @param locale フォーマットに使用するロケール
	 * @return dateがformat形式で、実在する日であれば{@code true}
	 * @throws IllegalArgumentException dateが{@code null}か、formatが{@code null}または空文字の場合
	 */
	@Published
	public static boolean isValid(String date, String format, Locale locale) {
		return getParsedDate(date, format, locale) != null;
	}

	/**
	 * このメソッドはロケールに{@link Locale#getDefault()}を使用して {@link #getParsedDate(String, String, Locale)}を呼び出す。
	 *
	 * @param date   パース対象日付文字列
	 * @param format 日付文字列フォーマット
	 * @return dateをformat形式でパースした結果の{@link java.util.Date}インスタンス
	 * @throws IllegalArgumentException dateが{@code null}か、formatが{@code null}または空文字の場合
	 */
	@Published(tag = "architect")
	public static Date getParsedDate(String date, String format) {
		return getParsedDate(date, format, Locale.getDefault());
	}

	/**
	 * dateをformat形式でパースした結果の{@link java.util.Date}インスタンスを返却する。</br>
	 * dateがformat形式ではない場合、または実在しない日付である場合、{@code null}を返却する。</br>
	 * 例)<br/>
	 * <pre><code>
	 * //正常処理
	 * DateUtil.getParsedDate("20160307160112", "yyyyMMddHHmmss", Locale.JAPANESE); // Mon Mar 07 12:12:12 JST 2016
	 *
	 * //20160304(date)の形式が、yyyymm形式でないため、null。
	 * DateUtil.getParsedDate("20160304", "yyyyMM", Locale.JAPANESE); //--> null
	 *
	 * //2016年3月32日が存在しない日付のため、null。
	 * DateUtil.getParsedDate("20160332", "yyyyMMdd", Locale.JAPANESE); //--> null
	 * </pre></code>
	 *
	 * @param date   パース対象日付文字列
	 * @param format 日付文字列フォーマット
	 * @param locale フォーマットに使用するロケール
	 * @return dateをformat形式でパースした結果の{@link java.util.Date}インスタンス
	 * @throws IllegalArgumentException dateが{@code null}か、formatが{@code null}または空文字の場合
	 */
	@Published(tag = "architect")
	public static Date getParsedDate(String date, String format, Locale locale) {

		if (StringUtil.isNullOrEmpty(format)) {
			throw new IllegalArgumentException("format mustn't be null or empty. format=" + format);
		}
		if (date == null) {
			throw new IllegalArgumentException("date mustn't be null.");
		}

		SimpleDateFormat df = new SimpleDateFormat(format, locale);
		df.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		Date resultDate = df.parse(date, pos);
		if (resultDate == null) {
			return null;
		}
		if (!df.format(resultDate).equals(date)) {
			return null;
		}
		return resultDate;
	}

	/** 年月日の区切り文字にマッチするパターン */
	private static final Pattern YMD_SEPARATOR_PATTERN = Pattern.compile("[^yMd]");

	/**
	 * フォーマット文字列から年月日の区切り文字を取り除いた値を返す。
	 * <pre>
	 * フォーマットのパターン文字は、y(年)、M(月)、d(月における日)のみ指定可能。
	 * 
	 * フォーマット文字列に年月日の区切り文字が含まれない場合は{@code null}を返す。
	 * 下記に「フォーマット文字列 //--> 戻り値」形式で例を示す。
	 * 
	 * "yyyy/MM/dd" //--> "yyyyMMdd"
	 * "yyyy-MM-dd" //--> "yyyyMMdd"
	 * "MM/dd/yyyy" //--> "MMddyyyy"
	 * "yyyyMMdd"   //--> {@code null}
	 * 
	 * </pre>
	 * @param yyyyMMddFormat フォーマット文字列
	 * @return フォーマット文字列から年月日の区切り文字を取り除いた値
	 */
	@Published(tag = "architect")
	public static String getNumbersOnlyFormat(String yyyyMMddFormat) {
		String numbersOnlyFormat = YMD_SEPARATOR_PATTERN.matcher(yyyyMMddFormat).replaceAll("");
		return yyyyMMddFormat.length() == numbersOnlyFormat.length() ? null : numbersOnlyFormat;
	}

	/**
	 * このメソッドは{@link ThreadContext}から取得したロケールを指定して
	 * {@link #formatDate(Date, String, Locale)}を呼び出す。
	 * 
	 * @param date 日付({@code null}不可)
	 * @param format フォーマット({@code null}不可)
	 * @return 変換した値
	 */
	@Published(tag = "architect")
	public static String formatDate(Date date, String format) {
		return formatDate(date, format,
				ThreadContext.getLanguage() == null ? Locale.getDefault() : ThreadContext.getLanguage());
	}

	/**
	 * 指定されたフォーマットとロケールを使用して日付を変換する。
	 * <p/>
	 * 指定するフォーマットは{@link SimpleDateFormat}の仕様に準拠すること。
	 * <p/>
	 * 例:
	 * <code><pre>
	 * Date date = Calendar.getInstance().getTime();              //--> 2012/11/13
	 * 
	 * I18NUtil.formatDate(date, "yyyy/MMM/dd", Locale.JAPANESE); //--> 2012/11/13
	 * I18NUtil.formatDate(date, "dd MMM yyyy", Locale.ENGLISH);  //--> 13 Nov 2012
	 * </pre></code>
	 * @param date 日付
	 * @param format フォーマット
	 * @param locale ロケール
	 * @return 変換した値
	 * @throws IllegalArgumentException 日付、フォーマット、ロケールが{@code null}の場合、または日付の変換に失敗した場合
	 */
	@Published(tag = "architect")
	public static String formatDate(Date date, String format, Locale locale) {

		if (date == null) {
			throw new IllegalArgumentException("date must not be null.");
		}
		if (format == null) {
			throw new IllegalArgumentException("format must not be null.");
		}
		if (locale == null) {
			throw new IllegalArgumentException("locale must not be null.");
		}

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);
			return dateFormat.format(date);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(
					String.format("format failed. date = [%s] format = [%s] locale = [%s]",
							date, format, locale),
					e);
		}
	}
}
