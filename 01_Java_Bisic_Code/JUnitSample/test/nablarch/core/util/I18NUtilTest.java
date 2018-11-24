package nablarch.core.util;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import nablarch.core.ThreadContext;

public class I18NUtilTest {

	@Test
	public void testCreateLocale() {
		{
			Locale locale = I18NUtil.createLocale("ja");

			assertThat(locale.getLanguage(), CoreMatchers.is("ja"));
		}

		{
			Locale locale = I18NUtil.createLocale("ja_JP");

			assertThat(locale.getLanguage(), CoreMatchers.is("ja"));
			assertThat(locale.getCountry(), CoreMatchers.is("JP"));
		}

		{
			Locale locale = I18NUtil.createLocale("ja_JP_VARIANT");

			assertThat(locale.getLanguage(), CoreMatchers.is("ja"));
			assertThat(locale.getCountry(), CoreMatchers.is("JP"));
			assertThat(locale.getVariant(), CoreMatchers.is("VARIANT"));
		}
	}

	@Test
	public void testCreateLocaleFail() {
		try {
			I18NUtil.createLocale("");
			fail("例外が発生するはず");
		} catch (IllegalArgumentException e) {
			// OK
		}
	}

	/**
	 * {@link I18NUtil#formatDateTime(java.util.Date, String)}と
	 * {@link I18NUtil#formatDateTime(java.util.Date, String, java.util.TimeZone)}のテスト。
	 */
	@Test
	public void testFormatDateTime() {

		TimeZone.setDefault(asTimeZone("Asia/Tokyo"));
		Date date = asDate("2011/02/12 14:18:50");
		String format = "yyyy-MM-dd HH.mm.ss";

		ThreadContext.setTimeZone(asTimeZone("America/New_York")); // -14時間
		TimeZone timeZone = asTimeZone("Europe/Madrid"); // -8時間

		TimeZone defaultTimeZone = TimeZone.getDefault();
		TimeZone.setDefault(asTimeZone("Asia/Tokyo"));

		Locale.setDefault(Locale.JAPANESE);
		Locale locale = Locale.ENGLISH;

		// dateパラメータがnullの場合。
		try {
			I18NUtil.formatDateTime(null, format);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("date must not be null."));
		}

		try {
			I18NUtil.formatDateTime(null, format, locale, timeZone);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("date must not be null."));
		}

		// formatパラメータがnullの場合。
		try {
			I18NUtil.formatDateTime(date, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("format must not be null."));
		}

		try {
			I18NUtil.formatDateTime(date, format, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("locale must not be null."));
		}

		try {
			I18NUtil.formatDateTime(date, null, locale, timeZone);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("format must not be null."));
		}

		// timeZoneパラメータがnullの場合。
		try {
			I18NUtil.formatDateTime(date, format, locale, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("timeZone must not be null."));
		}

		// タイムゾーンを指定しない場合。
		assertThat(I18NUtil.formatDateTime(date, format), is("2011-02-12 00.18.50"));

		// タイムゾーンを指定した場合。
		assertThat(I18NUtil.formatDateTime(date, format, locale, timeZone), is("2011-02-12 06.18.50"));

		// 不正なフォーマットの場合。
		String invalidFormat = "yyyyMMddA";
		try {
			I18NUtil.formatDateTime(date, invalidFormat);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, containsString("format failed."));
			assertThat(msg, containsString("format = [yyyyMMddA]"));
			assertThat(msg, containsString("timeZone = [America/New_York]"));
		}
		try {
			I18NUtil.formatDateTime(date, invalidFormat, locale, timeZone);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, containsString("format failed."));
			assertThat(msg, containsString("format = [yyyyMMddA]"));
			assertThat(msg, containsString("timeZone = [Europe/Madrid]"));
		}

		ThreadContext.setLanguage(Locale.CANADA.JAPANESE);
		assertThat("スレッドコンテキストのタイムゾーンでフォーマットされる", I18NUtil.formatDateTime(date, format), is("2011-02-12 00.18.50"));

		ThreadContext.setTimeZone(null);
		ThreadContext.setLanguage(null);
		assertThat("デフォルトのタイムゾーンでフォーマットされる", I18NUtil.formatDateTime(date, format), is("2011-02-12 14.18.50"));
		assertThat("デフォルトのタイムゾーンでフォーマットされる", I18NUtil.formatDateTime(date, format, Locale.JAPAN),
				is("2011-02-12 14.18.50"));

		TimeZone.setDefault(defaultTimeZone);
	}

	/**
	 * {@link I18NUtil#formatDecimal(Number, String)}と
	 * {@link I18NUtil#formatDecimal(Number, String, Locale)}のテスト。
	 */
	@Test
	public void testFormatDecimal() {

		Number number = BigDecimal.valueOf(123456789.123D);
		String format = "###,###,###.000";
		Locale language = new Locale("es");

		ThreadContext.setLanguage(new Locale("ja"));

		// numberパラメータがnullの場合。
		try {
			I18NUtil.formatDecimal(null, format);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("number must not be null."));
		}

		try {
			I18NUtil.formatDecimal(null, format, language);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("number must not be null."));
		}

		// formatパラメータがnullの場合。
		try {
			I18NUtil.formatDecimal(number, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("format must not be null."));
		}

		try {
			I18NUtil.formatDecimal(number, null, language);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("format must not be null."));
		}

		// languageパラメータがnullの場合。
		try {
			I18NUtil.formatDecimal(number, format, null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("language must not be null."));
		}

		// 言語を指定しない場合。
		assertThat(I18NUtil.formatDecimal(number, format), is("123,456,789.123"));

		// 言語を指定した場合。
		assertThat(I18NUtil.formatDecimal(number, format, language), is("123.456.789,123"));

		// 不正なフォーマットの場合。
		String invalidFormat = "###,###,###...000";
		try {
			I18NUtil.formatDecimal(number, invalidFormat);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, containsString("format failed."));
			assertThat(msg, containsString("format = [###,###,###...000]"));
			assertThat(msg, containsString("language = [ja]"));
		}
		try {
			I18NUtil.formatDecimal(number, invalidFormat, language);
			fail("IllegalArgumentExceptionがスローされる。");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			assertThat(msg, containsString("format failed."));
			assertThat(msg, containsString("format = [###,###,###...000]"));
			assertThat(msg, containsString("language = [es]"));
		}
	}

	private Date asDate(String source) {
		try {
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(source);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	private TimeZone asTimeZone(String id) {
		return TimeZone.getTimeZone(id);
	}
}
