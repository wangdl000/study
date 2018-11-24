package nablarch.core.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * {@link StringUtil}のテストクラス。
 *
 * @author Hisaaki Sioiri
 */
public class StringUtilTest {

	/** {@link StringUtil#lowerAndTrimUnderScore(String)}のテスト。 */
	@Test
	public void testLowerAndTrimUnderScore() throws Exception {
		assertThat(StringUtil.lowerAndTrimUnderScore("abc"), is("abc"));
		assertThat(StringUtil.lowerAndTrimUnderScore("abc"), is("abc"));
		assertThat(StringUtil.lowerAndTrimUnderScore("ABC"), is("abc"));
		assertThat(StringUtil.lowerAndTrimUnderScore("a_B_c"), is("abc"));
		assertThat(StringUtil.lowerAndTrimUnderScore("A-B-C"), is("a-b-c"));

		assertThat(StringUtil.lowerAndTrimUnderScore(
				"!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"),
				is("!\"#$%&'()*+,-./0123456789:;<=>?@abcdefghijklmnopqrstuvwxyz[\\]^`abcdefghijklmnopqrstuvwxyz{|}~"));

		assertThat("サロゲートペア以外は無視されて小文字化されること",
				StringUtil.lowerAndTrimUnderScore("A\uD85A\uDD51\uD83C\uDF7AB"),
				is("a\uD85A\uDD51\uD83C\uDF7Ab"));
	}

	/** {@link StringUtil#lpad(String, int, char)}のテスト。 */
	@Test
	public void lpad() {
		assertThat("指定桁数まで、指定文字がパディングされること。", StringUtil.lpad("1", 10, '0'), is("0000000001"));
		assertThat("指定桁数より1文字短い文字列を指定", StringUtil.lpad("1", 2, '0'), is("01"));
		assertThat("指定桁数と同じ文字列を指定", StringUtil.lpad("1111111111", 10, 'a'), is("1111111111"));
		assertThat("指定桁数より１文字長い文字列を指定", StringUtil.lpad("123456", 5, '0'), is("123456"));
		assertThat("指定文字に全角文字を指定", StringUtil.lpad("1", 5, '０'), is("００００1"));

		assertThat("サロゲートペアが扱えること", StringUtil.lpad("😂😂", 5, '⚽'), is("⚽⚽⚽😂😂"));
	}

	/**
	 * {@link nablarch.core.util.StringUtil#lpad(String, int, char)}のテスト。
	 *
	 * 長さがマイナスの場合例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void lpadLengthMinus() {
		StringUtil.lpad("1", -1, '0');
	}

	/** {@link StringUtil#rpad(String, int, char)}のテスト。 */
	@Test
	public void rpad() {
		assertThat("指定桁数まで、指定文字がパディングされること。", StringUtil.rpad("1", 10, '0'), is("1000000000"));
		assertThat("指定桁数より1文字短い文字列を指定", StringUtil.rpad("1", 2, '0'), is("10"));
		assertThat("指定桁数と同じ文字列を指定", StringUtil.rpad("1111111111", 10, 'a'), is("1111111111"));
		assertThat("指定桁数より１文字長い文字列を指定", StringUtil.rpad("123456", 5, '0'), is("123456"));
		assertThat("指定文字に全角文字を指定", StringUtil.rpad("1", 5, '０'), is("1００００"));
		assertThat("サロゲートペアが扱えること", StringUtil.rpad("😂😂", 5, '⚽'), is("😂😂⚽⚽⚽"));
	}

	/**
	 * {@link StringUtil#rpad(String, int, char)}のテスト。
	 *
	 * 長さがマイナスの場合例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void rpadLengthMinus() {
		StringUtil.rpad("1", -1, '0');
	}

	/** {@link StringUtil#isNullOrEmpty(String)} のテスト。 */
	@Test
	public void isNullOrEmpty() {
		assertThat(StringUtil.isNullOrEmpty((String) null), is(true));
		assertThat(StringUtil.isNullOrEmpty(""), is(true));
		assertThat(StringUtil.isNullOrEmpty(" "), is(false));
		assertThat(StringUtil.isNullOrEmpty("null"), is(false));

		assertThat("サロゲートペアを指定",
				StringUtil.isNullOrEmpty("\uD85A\uDD6F"), is(false));
	}

	/** {@link StringUtil#isNullOrEmpty(String...)} のテスト。 */
	@Test
	public void isNullOrEmptyVararg() {
		assertThat(StringUtil.isNullOrEmpty((String[]) null), is(true));
		assertThat(StringUtil.isNullOrEmpty(new String[0]), is(true));
		assertThat(StringUtil.isNullOrEmpty("", null), is(true));
		assertThat(StringUtil.isNullOrEmpty("", null, "not empty"), is(false));

		assertThat("サロゲートペアを指定",
				StringUtil.isNullOrEmpty("", null, "\uD83D\uDE0E"), is(false));
	}

	/** {@link StringUtil#isNullOrEmpty(Collection)} のテスト。 */
	@Test
	public void isNullOrEmptyCollection() {
		assertThat(StringUtil.isNullOrEmpty((Collection) null), is(true));
		assertThat(StringUtil.isNullOrEmpty(Collections.<String> emptyList()), is(true));
		assertThat(StringUtil.isNullOrEmpty(Arrays.asList("", "")), is(true));
		assertThat(StringUtil.isNullOrEmpty(Arrays.asList("", null, "not empty")), is(false));

		assertThat("サロゲートペアを指定",
				StringUtil.isNullOrEmpty(Arrays.asList("", null, "😅")), is(false));
	}

	/** {@link StringUtil#isNullOrEmpty(String)} のテスト。 */
	@Test
	public void hasValue() {
		assertThat(StringUtil.hasValue((String) null), is(false));
		assertThat(StringUtil.hasValue(""), is(false));
		assertThat(StringUtil.hasValue(" "), is(true));
		assertThat(StringUtil.hasValue("null"), is(true));

		assertThat("サロゲートペアを指定", StringUtil.hasValue("\uD83D\uDE05"), is(true));
	}

	/** {@link StringUtil#isNullOrEmpty(String...)} のテスト。 */
	@Test
	public void testHasValueVararg() {
		assertThat(StringUtil.hasValue("", null, "not empty"), is(true));
		assertThat(StringUtil.hasValue("", null), is(false));
		assertThat(StringUtil.hasValue(new String[0]), is(false));
		assertThat(StringUtil.hasValue((String[]) null), is(false));

		assertThat("サロゲートペアを指定",
				StringUtil.hasValue("", null, "\uD83D\uDE05"), is(true));
	}

	/** {@link StringUtil#isNullOrEmpty(Collection)} のテスト。 */
	@Test
	public void testHasValueCollection() {
		assertThat(StringUtil.hasValue(Arrays.asList("", null, "not empty")), is(true));
		assertThat(StringUtil.hasValue(Arrays.asList("", null)), is(false));
		assertThat(StringUtil.hasValue(Collections.<String> emptyList()), is(false));
		assertThat(StringUtil.hasValue((Collection) null), is(false));

		assertThat("サロゲートペアを指定",
				StringUtil.hasValue(Arrays.asList("", null, "\ud83d\ude05")), is(true));
	}

	private static final Charset UTF8 = Charset.forName("UTF-8");

	/**
	 * {@link StringUtil#toString(byte[], java.nio.charset.Charset)} のテスト。<br/>
	 *
	 * @throws java.io.UnsupportedEncodingException
	 *          発生しない
	 */
	@Test
	public void testToString() throws UnsupportedEncodingException {

		byte[] bytes = "―～".getBytes(UTF8.name());

		for (String charsetName : new String[] { "UTF-8", "Shift_JIS" }) {
			Charset charset = Charset.forName(charsetName);
			String expected = new String(bytes, charsetName);
			assertThat(StringUtil.toString(bytes, charset), is(expected));
		}

		// 対象バイト配列がnullの場合、nullが返却されること
		assertThat(StringUtil.toString(null, UTF8), is(nullValue()));

		// 対象バイト配列が要素数0の場合、空文字が返却されること
		assertThat(StringUtil.toString(new byte[0], UTF8), is(""));

		// サロゲートペア
		assertThat("サロゲートペアが正しく扱えること",
				StringUtil.toString("[\uD83D\uDE05\uD83D\uDE05\uD83D\uDE05]".getBytes(UTF8), UTF8),
				is("[\uD83D\uDE05\uD83D\uDE05\uD83D\uDE05]"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testToStringNull() throws UnsupportedEncodingException {
		byte[] bytes = "―～".getBytes(UTF8.name());
		StringUtil.toString(bytes, null);
	}

	/**
	 * Object -> Stringの変換ができること
	 * @throws Exception
	 */
	@Test
	public void testObjectToString() throws Exception {
		assertThat("文字列を指定", StringUtil.toString("あいうえお"), is("あいうえお"));
		assertThat("Integerを指定", StringUtil.toString(Integer.valueOf(100)), is("100"));
		assertThat("BigDecimalを指定", StringUtil.toString(new BigDecimal("0.0000000001")), is("0.0000000001"));

		class OverrideToString {

			@Override
			public String toString() {
				return "test class";
			}
		}
		assertThat("toStringをオーバライドしたクラスを指定", StringUtil.toString(new OverrideToString()), is("test class"));
	}

	/**
	 * {@link StringUtil#getBytes(String, Charset)} のテスト。<br/>
	 *
	 * @throws java.io.UnsupportedEncodingException
	 *          発生しない
	 */
	@Test
	public void testGetBytes() throws UnsupportedEncodingException {

		String string = "―～";

		for (String charsetName : new String[] { "UTF-8", "Shift_JIS" }) {
			Charset charset = Charset.forName(charsetName);
			byte[] expected = string.getBytes(charsetName);
			assertThat(StringUtil.getBytes(string, charset), is(expected));
		}

		// 対象文字列がnullの場合、nullが返却されること
		assertThat(StringUtil.getBytes(null, UTF8), is(nullValue()));

		// 対象文字列が空文字の場合、要素数0のバイト配列が返却されること
		assertThat(StringUtil.getBytes("", UTF8), is(new byte[0]));

		// サロゲートペア
		assertThat("サロゲートペアが正しく扱えること",
				StringUtil.getBytes("[\uD83D\uDE05\uD83D\uDE05\uD83D\uDE05]", UTF8),
				is("[\uD83D\uDE05\uD83D\uDE05\uD83D\uDE05]".getBytes(UTF8)));
	}

	/**
	 * {@link StringUtil#getBytes(String, Charset)} のテスト。<br/>
	 * Charsetがnullの場合、例外が発生すること。
	 *
	 * @throws java.io.UnsupportedEncodingException
	 *          発生しない
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetBytesNull() throws UnsupportedEncodingException {
		StringUtil.getBytes("hoge", null);
	}

	/** {@link StringUtil#insert(String, String, int...)}のテスト。 */
	@Test
	public void testInsert() {
		// 全ての位置に区切り文字が挿入されるケース
		assertThat(StringUtil.insert("0123456789", "-", 2, 3, 4), is("01-234-5678-9"));
		// 最後の位置の区切り文字が挿入されないケース
		assertThat(StringUtil.insert("012345678", "-", 2, 3, 4), is("01-234-5678"));
		// 全く区切り文字が挿入されないケース
		assertThat(StringUtil.insert("12", "-", 2, 3, 4), is("12"));
		// 空文字のケース
		assertThat(StringUtil.insert("", "-", 2, 3, 4), is(""));
		// サロゲートペア
		assertThat("サロゲートペアが正しく扱えること",
				StringUtil.insert("\uD83C\uDF63\uD83C\uDF63\uD83C\uDF63", // SUSHI
						"\uD83C\uDF7A", // BEER
						1, 1, 1),
				is("\uD83C\uDF63\uD83C\uDF7A\uD83C\uDF63\uD83C\uDF7A\uD83C\uDF63"));
	}

	/**
	 * {@link StringUtil#insert(String, String, int...)}のテスト。<br/>
	 * 対象文字列がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertTargetNull() {
		StringUtil.insert(null, "-", 4, 4, 4);
	}

	/**
	 * {@link StringUtil#insert(String, String, int...)}のテスト。<br/>
	 * 区切り文字がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertDelimiterNull() {
		StringUtil.insert("1234567890123456", null, 4, 4, 4);
	}

	/**
	 * {@link StringUtil#insert(String, String, int...)}のテスト。<br/>
	 * 挿入間隔がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertIntervalsNull() {
		StringUtil.insert("1234567890123456", "-", null);
	}

	/**
	 * {@link StringUtil#insert(String, String, int...)}のテスト。<br/>
	 * 挿入間隔の要素数が0の場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertIntervalsEmpty() {
		StringUtil.insert("1234567890123456", "-", new int[0]);
	}

	/**
	 * {@link StringUtil#insert(String, String, int...)}のテスト。<br/>
	 * 挿入間隔がマイナスの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertIntervalsMinus() {
		StringUtil.insert("1234567890123456", "-", new int[] { 1, -1 });
	}

	/** {@link StringUtil#insertFromRight(String, String, int...)}のテスト。<br/> */
	@Test
	public void testInsertFromRight() {
		// 全ての位置に区切り文字が挿入されるケース
		assertThat(StringUtil.insertFromRight("1234567890", "-", 4, 3, 2), is("1-23-456-7890"));
		// 最後の位置の区切り文字が挿入されないケース
		assertThat(StringUtil.insertFromRight("123456789", "-", 4, 3, 2), is("12-345-6789"));
		// 全く区切り文字が挿入されないケース
		assertThat(StringUtil.insertFromRight("1234", "-", 4, 3, 2), is("1234"));
		// 空文字のケース
		assertThat(StringUtil.insertFromRight("", "-", 4, 3, 2), is(""));
		// サロゲートペア
		assertThat("サロゲートペアが正しく扱えること",
				StringUtil.insertFromRight("\uD83C\uDF63\uD83C\uDF63\uD83C\uDF63", "\ud83c\udf7a", 1, 1, 1),
				is("\uD83C\uDF63\ud83c\udf7a\uD83C\uDF63\ud83c\udf7a\uD83C\uDF63"));
	}

	/**
	 * {@link StringUtil#insertFromRight(String, String, int...)}のテスト。<br/>
	 * 対象文字列がnullの場合、例外が発生すること
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertFromRightTargetNull() {
		StringUtil.insertFromRight(null, "-", 4, 3, 2);
	}

	/**
	 * {@link StringUtil#insertFromRight(String, String, int...)}のテスト。<br/>
	 * 区切り文字がnullの場合、例外が発生すること
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertFromRightDelimiterNull() {
		StringUtil.insertFromRight("12345", null, 4, 3, 2);
	}

	/** {@link StringUtil#insertRepeatedly(String, String, int)}のテスト。<br/> */
	@Test
	public void testInsertRepeatedly() {
		// 対象文字列数が挿入間隔ちょうど（区切り文字の倍数）のケース
		assertThat(StringUtil.insertRepeatedly("1234567890123456", "-", 4), is("1234-5678-9012-3456"));
		// 対象文字列数が挿入間隔ちょうど（区切り文字の倍数）でないケース
		assertThat(StringUtil.insertRepeatedly("123456789012345", "-", 4), is("1234-5678-9012-345"));
		// 対象文字列数が挿入間隔以下のケース
		assertThat(StringUtil.insertRepeatedly("1234", "-", 4), is("1234"));
		// 空文字のケース
		assertThat(StringUtil.insertRepeatedly("", "-", 4), is(""));
		// サロゲートペア
		assertThat("サロゲートペアが正しく扱えること",
				StringUtil.insertRepeatedly("\uD83C\uDF63\uD83C\uDF63\uD83C\uDF63",
						"\uD83C\uDF7A",
						1),
				is("\uD83C\uDF63\uD83C\uDF7A\uD83C\uDF63\uD83C\uDF7A\uD83C\uDF63"));
	}

	/**
	 * {@link StringUtil#insertRepeatedly(String, String, int)}のテスト。<br/>
	 * 対象文字列がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertRepeatedlyStringNull() {
		StringUtil.insertRepeatedly(null, ",", 4);
	}

	/**
	 * {@link StringUtil#insertRepeatedly(String, String, int)}のテスト。<br/>
	 * 区切り文字がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertRepeatedlyDelimiterNull() {
		StringUtil.insertRepeatedly("12345", null, 4);
	}

	/** {@link StringUtil#insertRepeatedlyFromRight(String, String, int)} のテスト。<br/> */
	@Test
	public void testInsertRepeatedlyFromRight() {
		// 対象文字列数が挿入間隔ちょうど（区切り文字の倍数）のケース
		assertThat(StringUtil.insertRepeatedlyFromRight("123456789", ",", 3), is("123,456,789"));
		// 対象文字列数が挿入間隔ちょうど（区切り文字の倍数）でないケース
		assertThat(StringUtil.insertRepeatedlyFromRight("1234567890", ",", 3), is("1,234,567,890"));
		// 対象文字列数が挿入間隔以下のケース
		assertThat(StringUtil.insertRepeatedlyFromRight("123", ",", 3), is("123"));
		// 空文字のケース
		assertThat(StringUtil.insertRepeatedlyFromRight("", ",", 3), is(""));
		// サロゲートペア
		assertThat("サロゲートペアが正しく扱えること",
				StringUtil.insertRepeatedlyFromRight("\uD83C\uDF63\uD83C\uDF63\uD83C\uDF63",
						"\uD83C\uDF7A",
						1),
				is("\uD83C\uDF63\uD83C\uDF7A\uD83C\uDF63\uD83C\uDF7A\uD83C\uDF63"));
	}

	/**
	 * {@link StringUtil#insertRepeatedlyFromRight(String, String, int)} のテスト。<br/>
	 * 対象文字列がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertRepeatedlyFromRightTargetNull() {
		StringUtil.insertRepeatedlyFromRight(null, ",", 3);
	}

	/**
	 * {@link StringUtil#insertRepeatedlyFromRight(String, String, int)} のテスト。<br/>
	 * 区切り文字がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInsertRepeatedlyFromRightDelimiterNull() {
		StringUtil.insertRepeatedlyFromRight("12345", null, 3);
	}

	/** {@link StringUtil#repeat(Object, int)}のテスト。<br/> */
	@Test
	public void testRepeat() {
		assertThat(StringUtil.repeat("1", 10), is("1111111111"));
		assertThat(StringUtil.repeat("1", 1), is("1"));
		assertThat(StringUtil.repeat("123", 2), is("123123"));
		assertThat(StringUtil.repeat("", 10), is(""));
		assertThat(StringUtil.repeat("1", 0), is(""));
		assertThat("サロゲートペアが扱えること",
				StringUtil.repeat("\uD83C\uDF63", 3),
				is("\uD83C\uDF63\uD83C\uDF63\uD83C\uDF63"));
	}

	/**
	 * {@link StringUtil#repeat(Object, int)}のテスト。<br/>
	 * 繰り返し対象文字列がnullの場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRepeatNull() {
		StringUtil.repeat(null, 1);
	}

	/**
	 * {@link StringUtil#repeat(Object, int)}のテスト。<br/>
	 * 繰り返し回数が負数の場合、例外が発生すること。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRepeatNegative() {
		StringUtil.repeat("1", -1);
	}

	/**
	 * {@link StringUtil#toArray(java.util.Collection)}のテスト。<br/>
	 * コレクションが文字列配列に変換されること。
	 */
	@Test
	public void testToArray() {
		final List<String> list = Arrays.asList("foo", "bar", "\uD83C\uDF63");
		assertThat(StringUtil.toArray(list), is(new String[] { "foo", "bar", "\uD83C\uDF63" }));
	}

	/** nullが許容されないこと */
	@Test(expected = IllegalArgumentException.class)
	public void testToArrayFail() {
		StringUtil.toArray(null);
	}

	/** 行末の文字列が切り落とされること。 */
	@Test
	public void testChomp() {
		assertThat(StringUtil.chomp("hoge\n", "\n"), is("hoge")); // 行末の文字が切り落とされる
		assertThat(StringUtil.chomp("fuga", "\n"), is("fuga")); // マッチしないので切り落とされない
		assertThat(StringUtil.chomp("", "\n"), is("")); // 空文字OK
		assertThat(StringUtil.chomp("hoge", ""), is("hoge")); // 空文字OK

		assertThat("サロゲートペアが扱えること",
				StringUtil.chomp("\uD83C\uDF63\uD83C\uDF63!!\uD83C\uDF7A",
						"\uD83C\uDF7A"),
				is("\uD83C\uDF63\uD83C\uDF63!!"));
	}

	/** nullが許容されないこと */
	@Test(expected = IllegalArgumentException.class)
	public void testTChompTargetNull() {
		StringUtil.chomp(null, "aaa");
	}

	/** nullが許容されないこと */
	@Test(expected = IllegalArgumentException.class)
	public void testTChompEndNull() {
		StringUtil.chomp("end", null);
	}

	/** 配列が結合されること。 */
	@Test
	public void testMerge() {
		assertThat(StringUtil.merge(
				new String[] { "1", "2" },
				new String[] { "3", "4" },
				new String[] { "5" },
				new String[0]), is(new String[] { "1", "2", "3", "4", "5" }));
		assertThat(StringUtil.merge(new String[0]), is(new String[0]));
	}

	/** nullが許容されないこと。 */
	@Test(expected = IllegalArgumentException.class)
	public void testMergeFail() {
		StringUtil.merge((String[][]) null);
	}

	/** {@link StringUtil#nullToEmpty(String)}のテスト */
	@Test
	public void testNullToEmpty() {
		assertThat(StringUtil.nullToEmpty(null), is(""));
		assertThat(StringUtil.nullToEmpty(""), is(""));
		assertThat(StringUtil.nullToEmpty("hoge"), is("hoge"));
		assertThat("サロゲートペアを指定",
				StringUtil.nullToEmpty("\ud83c\udf7a"),
				is("\ud83c\udf7a"));
	}

	/**
	 * {@link StringUtil#join(String, List)} のテスト
	 */
	@Test
	public void testJoin() {
		{
			List<String> list = new ArrayList<String>();
			list.add("val1");
			list.add("val2");
			list.add("val3");
			list.add("\uD83C\uDF7A\uD83C\uDF7A");
			assertThat(StringUtil.join(",", list), is("val1,val2,val3,\uD83C\uDF7A\uD83C\uDF7A"));
			assertThat(StringUtil.join(":", list), is("val1:val2:val3:\uD83C\uDF7A\uD83C\uDF7A"));
		}
		{
			List<String> list = new ArrayList<String>();
			assertThat(StringUtil.join(",", list), is(""));
		}
		{
			List<String> list = new ArrayList<String>();
			list.add("");
			assertThat(StringUtil.join(",", list), is(""));
		}
		{
			try {
				StringUtil.join(",", null);
				fail("例外が発生するはず。");
			} catch (NullPointerException ne) {
				// OK
			}
		}
	}

	/**
	 * {@link StringUtil#split(String, String)}および{@link StringUtil#split(String, String, boolean)} のテスト
	 */
	@Test
	public void testSplit() {
		{

			List<String> list = new ArrayList<String>();
			list.add(" val1 ");
			list.add(" val2 ");
			list.add(" val3 ");
			list.add(" \uD83C\uDF7A");
			assertThat(StringUtil.split(" val1 , val2 , val3 , \uD83C\uDF7A", ","), is(list));
		}
		{
			List<String> list = new ArrayList<String>();
			list.add("");
			assertThat(StringUtil.split("", ","), is(list));
		}
		{

			List<String> list = new ArrayList<String>();
			list.add("val1");
			list.add("val2");
			list.add("val3");
			assertThat(StringUtil.split(" val1 , val2 , val3 ", ",", true), is(list));
		}
		{

			List<String> list = new ArrayList<String>();
			list.add(" val1 ");
			list.add(" val2 ");
			list.add(" val3 ");
			assertThat(StringUtil.split(" val1 , val2 , val3 ", ",", false), is(list));
		}
		{
			List<String> list = new ArrayList<String>();
			list.add("");
			assertThat(StringUtil.split("", ","), is(list));
		}
	}
}
