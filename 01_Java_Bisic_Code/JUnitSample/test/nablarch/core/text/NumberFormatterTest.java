package nablarch.core.text;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link NumberFormatter}のテストクラス
 *
 * @author Ryota Yoshinouchi
 */
public class NumberFormatterTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void フォーマッタの名前が取得できること() {
		NumberFormatter sut = new NumberFormatter();
		assertThat(sut.getFormatterName(), is("number"));
	}

	@Test
	public void パターンを指定しない場合デフォルトのパターンでフォーマットされること() {
		NumberFormatter sut = new NumberFormatter();
		Number number = BigDecimal.valueOf(123456789.123);

		assertThat(sut.format(number), is("123,456,789.123"));
	}

	@Test
	public void 指定されたパターンで数値をフォーマットできること() {
		NumberFormatter sut = new NumberFormatter();
		Number number = BigDecimal.valueOf(123.123);
		String pattern = "00,000.000";

		assertThat(sut.format(number, pattern), is("00,123.123"));
	}

	@Test
	public void パターン文字列がnulの場合例外が送出されること() {
		NumberFormatter sut = new NumberFormatter();
		Number number = BigDecimal.valueOf(123456789.123);

		expectedException.expect(IllegalArgumentException.class);
		sut.format(number, null);
	}

	@Test
	public void パターン文字列が不正な場合例外が送出されること() {
		NumberFormatter sut = new NumberFormatter();
		Number number = BigDecimal.valueOf(123456789.123);
		String pattern = "#,###...000";

		expectedException.expect(IllegalArgumentException.class);
		sut.format(number, pattern);

	}

	@Test
	public void フォーマット対象がnullの場合nullが返却されること() {
		NumberFormatter sut = new NumberFormatter();
		String pattern = "00,000.000";

		assertThat(sut.format(null), is(nullValue()));
		assertThat(sut.format(null, pattern), is(nullValue()));
	}
}
