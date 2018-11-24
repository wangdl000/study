package nablarch.core.util;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import nablarch.core.ThreadContext;

/**
 * {@link DateUtil}のテストクラス
 *
 * @author Miki Habu
 */
public class DateUtilTest {

	@Before
	public void setUp() {
		ThreadContext.clear();
		// 強制的にロケールを変更
		Locale.setDefault(Locale.JAPANESE);
	}

	/** {@link DateUtil#getDate(String)}のテスト。 */
	@Test
	public void testGetDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String testDate = "20101123";
		Date expected = null;
		try {
			expected = sdf.parse(testDate);
		} catch (ParseException e) {
			fail();
		}
		assertThat("正常系", DateUtil.getDate(testDate), CoreMatchers.is(expected));

		try {
			DateUtil.getDate("2010/11/10");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat("例外発生", e.getMessage(),
					CoreMatchers.is("the string was not formatted yyyyMMdd. date = 2010/11/10."));
		}

	}

	/**
	 * ThreadLocalに依存しない{@link DateUtil#formatDate(Date, String)}のテスト
	 * @throws Exception
	 */
	@Test
	public void testFormatDateNotDependThreadLocal() throws Exception {
		// -------------------------------------------------- clear the ThreadContext
		ThreadContext.clear();

		// -------------------------------------------------- execute
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 0, 2);
		final String result = DateUtil.formatDate(calendar.getTime(), "GGGGyyyy-MM-dd");

		// -------------------------------------------------- assert
		assertThat("デフォルトロケールは、jaなので西暦とフォーマットされること", result, is("西暦2016-01-02"));
	}

	/** {@link DateUtil#formatDate}のテスト。 */
	@Test
	public void testFormatDate() {
		assertThat("正常系", DateUtil.formatDate("20100101",
				"yyyy年MM月dd日"), CoreMatchers.is("2010年01月01日"));

		try {
			DateUtil.formatDate("2010/11/10", "yyyyMMdd");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat("例外発生", e.getMessage(),
					CoreMatchers.is("the string was not formatted yyyyMMdd. date = 2010/11/10."));
		}
	}

	/** {@link nablarch.core.util.DateUtil#addDay}のテスト。 */
	@Test
	public void testAddDay() {
		assertThat("1日後", DateUtil.addDay("20101110", 1), CoreMatchers.is("20101111"));
		assertThat("2日後", DateUtil.addDay("20101110", 2), CoreMatchers.is("20101112"));
		assertThat("月跨ぎ(翌月)", DateUtil.addDay("20101130", 1), CoreMatchers.is("20101201"));
		assertThat("年跨ぎ(翌年)", DateUtil.addDay("20101231", 1), CoreMatchers.is("20110101"));
		assertThat("1日前", DateUtil.addDay("20101110", -1), CoreMatchers.is("20101109"));
		assertThat("2日前", DateUtil.addDay("20101110", -2), CoreMatchers.is("20101108"));
		assertThat("月跨ぎ(前月)", DateUtil.addDay("20101101", -1), CoreMatchers.is("20101031"));
		assertThat("年跨ぎ(前年)", DateUtil.addDay("20100101", -1), CoreMatchers.is("20091231"));
		assertThat("閏年", DateUtil.addDay("20080228", 1), CoreMatchers.is("20080229"));
		assertThat("閏年", DateUtil.addDay("20080229", 1), CoreMatchers.is("20080301"));
	}

	/** {@link nablarch.core.util.DateUtil#addMonth(String, int)}のテスト。 */
	@Test
	public void testAddMonth() {
		// 年月日
		assertThat("加算", DateUtil.addMonth("20100930", 1), CoreMatchers.is("20101030"));
		assertThat("減算", DateUtil.addMonth("20100930", -1), CoreMatchers.is("20100830"));
		assertThat("閏年", DateUtil.addMonth("20030429", 10), CoreMatchers.is("20040229"));

		// 年月
		assertThat("加算", DateUtil.addMonth("201009", 1), CoreMatchers.is("201010"));
		assertThat("減算", DateUtil.addMonth("201009", -1), CoreMatchers.is("201008"));
		assertThat("閏年", DateUtil.addMonth("200304", 10), CoreMatchers.is("200402"));
	}

	/** {@link nablarch.core.util.DateUtil#getDays}のテスト */
	@Test
	public void testGetDays() {
		assertThat("同日", DateUtil.getDays("20101110", "20101110"), is(0L));
		assertThat("1日(from < to)", DateUtil.getDays("20101110", "20101111"), is(1L));
		assertThat("2日(from < to)", DateUtil.getDays("20101110", "20101112"), is(2L));
		assertThat("月跨ぎ(from < to)", DateUtil.getDays("20101130", "20101201"), is(1L));
		assertThat("年跨ぎ(from < to)", DateUtil.getDays("20101231", "20110101"), is(1L));
		assertThat("1日(from > to)", DateUtil.getDays("20101110", "20101109"), is(-1L));
		assertThat("2日(from > to)", DateUtil.getDays("20101110", "20101108"), is(-2L));
		assertThat("月跨ぎ(from > to)", DateUtil.getDays("20101101", "20101031"), is(-1L));
		assertThat("年跨ぎ(from > to)", DateUtil.getDays("20100101", "20091231"), is(-1L));
	}

	/** {@link DateUtil#getMonths(String, String)}のテスト。 */
	@Test
	public void testGetMonths() {
		assertThat("同じ月(年月)", DateUtil.getMonths("201102", "201102"), CoreMatchers.is(0));
		assertThat("同じ月(年月日:日付は同じ)", DateUtil.getMonths("20110201",
				"20110201"), CoreMatchers.is(0));
		assertThat("同じ月(年月日:日付は異なる)", DateUtil.getMonths("20110201",
				"20110228"), CoreMatchers.is(0));

		assertThat("1ヶ月後(年月)", DateUtil.getMonths("201102", "201103"), CoreMatchers.is(1));
		assertThat("1ヶ月後(年月日)", DateUtil.getMonths("20110201",
				"20110301"), CoreMatchers.is(1));

		assertThat("1ヶ月前(年月)", DateUtil.getMonths("201102", "201101"), CoreMatchers.is(-1));
		assertThat("1ヶ月前(年月日)", DateUtil.getMonths("20110201",
				"20110101"), CoreMatchers.is(-1));

		assertThat("１年後(年月)", DateUtil.getMonths("201102", "201202"), CoreMatchers.is(12));
		assertThat("１年後(年月日)", DateUtil.getMonths("20110201",
				"20120228"), CoreMatchers.is(12));

		assertThat("１年前(年月)", DateUtil.getMonths("201102", "201002"), CoreMatchers.is(-12));
		assertThat("１年前(年月日)", DateUtil.getMonths("20110201",
				"20100228"), CoreMatchers.is(-12));

		assertThat("１年＋1ヶ月後(年月)", DateUtil.getMonths("201102", "201203"), CoreMatchers.is(13));
		assertThat("１年＋1ヶ月後(年月日)", DateUtil.getMonths("20110201",
				"20120315"), CoreMatchers.is(13));

		assertThat("１年＋1ヶ月前(年月)", DateUtil.getMonths("201102",
				"201001"), CoreMatchers.is(-13));
		assertThat("１年＋1ヶ月前(年月日)", DateUtil.getMonths("20111231",
				"20101125"), CoreMatchers.is(-13));

		assertThat("フォーマットが異なる場合", DateUtil.getMonths("20110331",
				"201104"), CoreMatchers.is(1));
		assertThat("フォーマットが異なる場合", DateUtil.getMonths("201103",
				"20100315"), CoreMatchers.is(-12));
	}

	/** {@link DateUtil#getMonthEndDate(String)}のテスト。 */
	@Test
	public void testGetMonthEndDate() {
		assertThat("年月指定", DateUtil.getMonthEndDate("201103"), CoreMatchers.is("20110331"));
		assertThat("年月指定", DateUtil.getMonthEndDate("201104"), CoreMatchers.is("20110430"));
		assertThat("年月指定(閏年2月)", DateUtil.getMonthEndDate(
				"200802"), CoreMatchers.is("20080229"));
		assertThat("年月指定(閏年以外2月)", DateUtil.getMonthEndDate(
				"201102"), CoreMatchers.is("20110228"));

		assertThat("年月日指定", DateUtil.getMonthEndDate("20110303"), CoreMatchers.is("20110331"));
		assertThat("年月指定", DateUtil.getMonthEndDate("20110429"), CoreMatchers.is("20110430"));
		assertThat("年月日指定(閏年2月)", DateUtil.getMonthEndDate(
				"20080205"), CoreMatchers.is("20080229"));
		assertThat("年月日指定(閏年以外2月)", DateUtil.getMonthEndDate(
				"20110201"), CoreMatchers.is("20110228"));
	}

	/**
	 * {@link DateUtil#isValid(String, String)}のテスト。<br/>
	 * {@link DateUtil#getParsedDate(String, String)}のテストも兼ねています。
	 */
	@Test
	public void testIsValid() {

		ThreadContext.setLanguage(Locale.JAPANESE);

		// null、空文字
		try {
			DateUtil.isValid(null, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), CoreMatchers.is("format mustn't be null or empty. format=null"));
		}
		try {
			DateUtil.isValid(null, "yyyy/MM/dd");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), CoreMatchers.is("date mustn't be null."));
		}

		try {
			DateUtil.isValid("20110909", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), CoreMatchers.is("format mustn't be null or empty. format=null"));
		}

		try {
			DateUtil.isValid("", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), CoreMatchers.is("format mustn't be null or empty. format="));
		}

		assertThat(DateUtil.isValid("", "yyyy/MM/dd"), CoreMatchers.is(false));

		try {
			DateUtil.isValid("20110909", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), CoreMatchers.is("format mustn't be null or empty. format="));
		}

		// フォーマット通り
		assertThat(DateUtil.isValid("20110909", "yyyyMMdd"), CoreMatchers.is(true));
		assertThat(DateUtil.isValid("14 11 2012", "dd MMM yyyy"), CoreMatchers.is(true));
		assertThat(DateUtil.isValid("14 Nov 2012", "dd MMM yyyy", Locale.ENGLISH), CoreMatchers.is(true));

		// フォーマット通りではない
		assertThat(DateUtil.isValid("20110909", "yyyy/MM/dd"), CoreMatchers.is(false));
		assertThat(DateUtil.isValid("2011/09/09a", "yyyy/MM/dd"), CoreMatchers.is(false));
		assertThat(DateUtil.isValid("2011/09/09aaa", "yyyy/MM/dd"), CoreMatchers.is(false));
		assertThat(DateUtil.isValid("2011/09/09 ", "yyyy/MM/dd"), CoreMatchers.is(false));
		assertThat(DateUtil.isValid("2011/09/012", "yyyy/MM/dd"), CoreMatchers.is(false));
		assertThat(DateUtil.isValid("14 Nov 2012", "dd MMM yyyy"), CoreMatchers.is(false));
		assertThat(DateUtil.isValid("14 11 2012", "dd MMM yyyy", Locale.ENGLISH), CoreMatchers.is(false));

		// 実在しない日
		assertThat(DateUtil.isValid("2011/09/32", "yyyy/MM/dd"), CoreMatchers.is(false));
	}

	/**
	 * {@link DateUtil#formatDate(java.util.Date, java.lang.String)}と
	 * {@link DateUtil#formatDate(java.util.Date, java.lang.String, java.util.Locale)}のテスト。
	 */
	@Test
	public void testFormatDateObject() throws Exception {

		Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2012/11/13");
		String format = "yyyy-MMM-dd";

		/*
		 * タイムゾーンに依存せずにフォーマットされることを確認するための設定。
		 * 
		 * タイムゾーンに依存すると、ブラジル時間で計算されてフォーマット結果が「2012/11/12」になります。
		 * フォーマットされるたびに日付が減っていくという不具合で、MULで実際に発生しました。
		 * 
		 */
		ThreadContext.setTimeZone(TimeZone.getTimeZone("Brasilia Time, Brazil/East"));

		ThreadContext.setLanguage(Locale.JAPANESE);
		Locale.setDefault(Locale.CHINESE);
		Locale locale = Locale.ENGLISH;

		// dateパラメータがnullの場合。
		try {
			DateUtil.formatDate((Date) null, format);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("date must not be null."));
		}

		try {
			DateUtil.formatDate(null, format, locale);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("date must not be null."));
		}

		// formatパラメータがnullの場合。
		try {
			DateUtil.formatDate(date, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("format must not be null."));
		}

		try {
			DateUtil.formatDate(date, null, locale);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("format must not be null."));
		}

		// ロケールを指定しない場合
		assertThat(DateUtil.formatDate(date, format), is("2012-11-13"));

		// ロケールを指定した場合。
		assertThat(DateUtil.formatDate(date, format, locale), is("2012-Nov-13"));

		// 不正なフォーマットの場合。
		String invalidFormat = "yyyyMMddA";
		try {
			DateUtil.formatDate(date, invalidFormat);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, containsString("format failed."));
			assertThat(msg, containsString("format = [yyyyMMddA]"));
			assertThat(msg, containsString("locale = [ja]"));
		}
		try {
			DateUtil.formatDate(date, invalidFormat, locale);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, containsString("format failed."));
			assertThat(msg, containsString("format = [yyyyMMddA]"));
			assertThat(msg, containsString("locale = [en]"));
		}

		try {
			DateUtil.formatDate(date, "yyyy/MM/dd", null);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, is("locale must not be null."));
		}

		Locale.setDefault(Locale.JAPANESE);
	}
}
