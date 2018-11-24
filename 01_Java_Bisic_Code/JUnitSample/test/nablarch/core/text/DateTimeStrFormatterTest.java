package nablarch.core.text;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link DateTimeStrFormatter}のテストクラス
 *
 * @author Ryota Yoshinouchi
 */
public class DateTimeStrFormatterTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void フォーマッタの名前が取得できること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		assertThat(sut.getFormatterName(), is("dateTime"));
	}

	@Test
	public void パターンを指定しない場合デフォルトのパターンでフォーマットできること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();

		assertThat(sut.format("20180216"), is("2018/02/16"));
	}

	@Test
	public void 指定したパターンでフォーマットできること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		String pattern = "yyyy年MM月dd日";

		assertThat(sut.format("20180216", pattern), is("2018年02月16日"));
	}

	@Test
	public void パターン文字列がnullの場合例外が送出されること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();

		expectedException.expect(IllegalArgumentException.class);
		sut.format("20180216", null);
	}

	@Test
	public void パターン文字列が不正な場合例外が送出されること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		String pattern = "yyyy-MM-ddA";

		expectedException.expect(IllegalArgumentException.class);
		sut.format("20180216", pattern);
	}

	@Test
	public void フォーマット対象がnullの場合nullが返却されること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		String pattern = "yyyy-MM-dd";

		assertThat(sut.format(null), is(nullValue()));
		assertThat(sut.format(null, pattern), is(nullValue()));
	}

	@Test
	public void フォーマット対象の文字列が不正なパターンだった場合フォーマットされずに返却されること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		assertThat(sut.format("201801"), is("201801"));
	}

	@Test
	public void フォーマット対象のパターン指定がnullの場合例外が送出されること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		sut.setDateStrPattern(null);

		expectedException.expect(IllegalArgumentException.class);
		sut.format("20180101");
	}

	@Test
	public void フォーマット対象のパターン指定が不正なパターンだった場合例外が送出されること() {
		DateTimeStrFormatter sut = new DateTimeStrFormatter();
		sut.setDateStrPattern("yyyyMMddA");

		expectedException.expect(IllegalArgumentException.class);
		sut.format("20180101");
	}
}
