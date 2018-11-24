package nablarch.core.text;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import nablarch.core.repository.ObjectLoader;
import nablarch.core.repository.SystemRepository;

/**
 * {@link FormatterUtil}のテストクラス
 *
 * @author Ryota Yoshinouchi
 */
public class FormatterUtilTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@After
	public void tearDown() {
		SystemRepository.clear();
	}

	@Test
	public void デフォルトのパターンでフォーマットできること() throws Exception {
		// デフォルトパターンはyyyy/MM/dd
		assertThat(FormatterUtil.format("dateTime", new SimpleDateFormat("yyyy/MM/dd").parse("2018/01/01")),
				is("2018/01/01"));
		assertThat(FormatterUtil.format("dateTime", "20180101"), is("2018/01/01"));
		// デフォルトパターンは#,###,##0.000
		assertThat(FormatterUtil.format("number", BigDecimal.valueOf(123456789.123)), is("123,456,789.123"));
		assertThat(FormatterUtil.format("number", "123456789.123"), is("123,456,789.123"));
	}

	@Test
	public void 指定したパターンでフォーマットできること() throws Exception {
		assertThat(
				FormatterUtil.format("dateTime", new SimpleDateFormat("yyyy/MM/dd").parse("2018/01/01"), "yyyy年MM月dd日"),
				is("2018年01月01日"));
		assertThat(FormatterUtil.format("dateTime", "20180101", "yyyy年MM月dd日"), is("2018年01月01日"));
		assertThat(FormatterUtil.format("number", BigDecimal.valueOf(1234567890), "#,###,###,### 円"),
				is("1,234,567,890 円"));
		assertThat(FormatterUtil.format("number", "1,234,567,890", "#,###,###,### 円"), is("1,234,567,890 円"));
	}

	@Test
	public void システムリポジトリにフォーマッタコンフィグを登録した場合登録したフォーマッタを使用できること() throws Exception {
		SystemRepository.load(new ObjectLoader() {
			@Override
			public Map<String, Object> load() {
				DateTimeFormatter dateTimeFormatter = new DateTimeFormatter();
				dateTimeFormatter.setFormatterName("customDateTime");
				dateTimeFormatter.setDefaultPattern("yyyy年MM月dd日");

				NumberFormatter numberFormatter = new NumberFormatter();
				numberFormatter.setFormatterName("customNumber");
				numberFormatter.setDefaultPattern("#,###,###,### 円");

				DateTimeStrFormatter dateTimeStrFormatter = new DateTimeStrFormatter();
				dateTimeStrFormatter.setFormatterName("customDateTimeStr");
				dateTimeStrFormatter.setDefaultPattern("yyyy年MM月dd日");
				dateTimeStrFormatter.setDateStrPattern("yyyyMMdd");

				NumberStrFormatter numberStrFormatter = new NumberStrFormatter();
				numberStrFormatter.setFormatterName("customNumberStr");
				numberStrFormatter.setDefaultPattern("#,###,###,### 円");

				List<Formatter<?>> list = new ArrayList<Formatter<?>>();
				list.add(dateTimeFormatter);
				list.add(numberFormatter);
				list.add(dateTimeStrFormatter);
				list.add(numberStrFormatter);

				FormatterConfig formatterConfig = new FormatterConfig();
				formatterConfig.setFormatters(list);

				final Map<String, Object> result = new HashMap<String, Object>();
				result.put("formatterConfig", formatterConfig);
				return result;
			}
		});

		assertThat(FormatterUtil.format("customDateTime", new SimpleDateFormat("yyyy/MM/dd").parse("2018/01/01")),
				is("2018年01月01日"));
		assertThat(FormatterUtil.format("customNumber", BigDecimal.valueOf(1234567890)), is("1,234,567,890 円"));
		assertThat(FormatterUtil.format("customDateTimeStr", "20180101"), is("2018年01月01日"));
		assertThat(FormatterUtil.format("customNumberStr", "1,234,567,890"), is("1,234,567,890 円"));
	}

	@Test
	public void システムリポジトリに登録していないフォーマッタを指定した場合例外が送出されること() throws Exception {
		expectedException.expect(IllegalArgumentException.class);
		FormatterUtil.format("invalidFormatter", new SimpleDateFormat("yyyy/MM/dd").parse("2018/01/01"));
	}

	@Test
	public void フォーマット対象がnullの場合nullが返却されること() {
		assertThat(FormatterUtil.format("dateTime", null), is(nullValue()));
		assertThat(FormatterUtil.format("dateTime", null, "yyyy/MM/dd"), is(nullValue()));
	}
}
