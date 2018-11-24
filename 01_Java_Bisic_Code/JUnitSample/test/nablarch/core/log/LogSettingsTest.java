package nablarch.core.log;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * {@link LogSettings}のテスト。
 * @author Kiyohito Itoh
 */
public class LogSettingsTest extends LogTestSupport {

	@Override
	@After
	public void tearDown() {
		super.tearDown();
		System.clearProperty("loggerFactory.className");
		System.clearProperty("loggers.access.nameRegex");
		System.clearProperty("trim");
	}

	/**
	 * 設定不備に対応できること。
	 */
	@Test
	public void testInvalidSettings() {

		try {
			new LogSettings("classpath:unknown");
			fail("must be thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
		}
	}

	/**
	 * 設定内容をロードできること。
	 */
	@Test
	public void testLoading() {

		LogSettings settings = new LogSettings("classpath:nablarch/core/log/log-settings.properties");

		assertThat(settings.getFilePath(), is("classpath:nablarch/core/log/log-settings.properties"));
		assertThat(settings.getProps().get("loggerFactory.className"),
				is("nablarch.core.log.basic.BasicLoggerFactory"));
		assertThat(settings.getProps().get("loggers.access.nameRegex"),
				is("tis\\.w8\\.web\\.handler\\.AccessLogHandler"));
		// キーと値の前後にスペースが入っているプロパティ
		assertThat(settings.getProps().get("trim"), is("trim value"));

		try {
			settings.getRequiredProp("unknown");
			fail("must be thrown the IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			// success
		}
		try {
			settings.getRequiredProp("blank");
			fail("must be thrown the IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			// success
		}
	}

	/**
	 * 設定内容をシステムプロパティで上書きできること。
	 */
	@Test
	public void testOverride() {

		System.setProperty("loggerFactory.className", " test factory ");
		System.setProperty("loggers.access.nameRegex", " access test");
		System.setProperty("trim", "testtest ");

		LogSettings settings = new LogSettings("classpath:nablarch/core/log/log-settings.properties");

		assertThat(settings.getFilePath(), is("classpath:nablarch/core/log/log-settings.properties"));
		assertThat(settings.getProps().get("loggerFactory.className"), is("test factory"));
		assertThat(settings.getProps().get("loggers.access.nameRegex"), is("access test"));
		assertThat(settings.getProps().get("trim"), is("testtest"));
	}
}
