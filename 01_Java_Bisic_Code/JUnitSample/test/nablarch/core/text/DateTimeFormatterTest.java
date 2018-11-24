package nablarch.core.text;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link DateTimeFormatter}のテストクラス
 *
 * @author Ryota Yoshinouchi
 */
public class DateTimeFormatterTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void フォーマッタの名前が取得できること() {
		DateTimeFormatter sut = new DateTimeFormatter();
		assertThat(sut.getFormatterName(), is("dateTime"));
	}

	@Test
	public void パターンを指定しない場合デフォルトのパターンでフォーマットできること() throws Exception {
		DateTimeFormatter sut = new DateTimeFormatter();
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2018/02/16");

		assertThat(sut.format(date), is("2018/02/16"));
	}

	@Test
	public void 指定したパターンでフォーマットできること() throws Exception {
		DateTimeFormatter sut = new DateTimeFormatter();
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2018/02/16");
		String pattern = "yyyy年MM月dd日";

		assertThat(sut.format(date, pattern), is("2018年02月16日"));
	}

	@Test
	public void パターン文字列がnullの場合例外が送出されること() throws Exception {
		DateTimeFormatter sut = new DateTimeFormatter();
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2018/02/16");

		expectedException.expect(IllegalArgumentException.class);
		sut.format(date, null);
	}

	@Test
	public void パターン文字列が不正な場合例外が送出されること() throws Exception {
		DateTimeFormatter sut = new DateTimeFormatter();
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2018/02/16");
		String pattern = "yyyy-MM-ddA";

		expectedException.expect(IllegalArgumentException.class);
		sut.format(date, pattern);
	}

	@Test
	public void フォーマット対象がnullの場合nullが返却されること() {
		DateTimeFormatter sut = new DateTimeFormatter();
		String pattern = "yyyy-MM-dd";

		assertThat(sut.format(null), is(nullValue()));
		assertThat(sut.format(null, pattern), is(nullValue()));
	}
}
