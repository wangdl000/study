package nablarch.core.util;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
//import java.util.List;
import java.util.regex.Pattern;

import nablarch.core.util.annotation.Published;

/**
 * 文字列ユーティリティクラス。<br/>
 * 文字列に関する汎用的な処理を提供する。
 * <p/>
 * 本クラスのメソッドには、{@link #insert(String, String, int...)}のように
 * 文字列編集用途に使用するメソッドも用意されている。これらのメソッドは、
 * 例えば、電話番号をハイフン区切りに整形する等のフォーマット処理用に使用されることを想定している。
 * プロジェクトでフォーマット用のユーティリティを作成する場合、これらのメソッドを使用するとよい。
 *
 * 本クラスはサロゲートペアに対応している。
 *
 * @author Hisaaki Sioiri
 */
public final class StringUtil {
	/** privateコンストラクタ。 */
	private StringUtil() {
	}

	/**
	 * 文字列の左側に、指定された文字を指定された文字列長に到達するまで加える。
	 * <p/>
	 * {@code string}の文字数 >= {@code length} の場合は{@code string}の文字列をそのまま返却。<br/>
	 * 例:
	 * <code><pre>
	 * StringUtil.lpad("100", 10, '0'); //--> "0000000100"
	 * </pre></code>
	 *
	 * @param string  文字列({@code null}不可)
	 * @param length  変換後文字列のサイズ(0以上)
	 * @param padChar 加える文字
	 * @return フォーマット後文字列
	 */
	@Published
	public static String lpad(String string, int length, char padChar) {
		assertNotNull(string, "string");
		assertNotTrue(length < 0, "length must not be negative.");

		StringBuilder sb = new StringBuilder(length);



//		StringBuffer sb2 = new StringBuffer(30);



		String aaa = "";





		int countToPad = length - string.codePointCount(0, string.length());


		for (int i = 0; i < countToPad; i++) {
			sb.append(padChar);
		}



		sb.append(string);
		return sb.toString();
	}

	/**
	 * 文字列の右側に、指定された文字を指定された文字列長に到達するまで加える。
	 * <p/>
	 * {@code string}の文字数 >= {@code length} の場合は{@code string}の文字列をそのまま返却。<br/>
	 * 例:
	 * <code><pre>
	 * StringUtil.rpad("100", 10, '0'); //--> "1000000000"
	 * </pre></code>
	 *
	 * @param string  文字列({@code null}不可)
	 * @param length  変換後文字列のサイズ(0以上)
	 * @param padChar 加える文字
	 * @return フォーマット後文字列
	 */
	@Published
	public static String rpad(String string, int length, char padChar) {
		assertNotNull(string, "string");
		assertNotTrue(length < 0, "length must not be negative.");


		Person aaa = new Person();

		StringBuilder sb = new StringBuilder(length);
		sb.append(string);
		int countToPad = length - string.codePointCount(0, string.length());
		for (int i = 0; i < countToPad; i++) {
			sb.append(padChar);
		}
		return sb.toString();
	}

	/**
	 * {@code null}または空文字列判定を行う。
	 * <pre>
	 * |引数                | 戻り値
	 * +--------------------+--------
	 * | null               | true
	 * | ""                 | true
	 * | "hoge"             | false
	 * | " " (半角スペース) | false
	 * | "　"(全角スペース) | false
	 * </pre>
	 *
	 * @param string 文字列
	 * @return {@code null}または空文字列の場合は{@code true}
	 */
	@Published
	public static boolean isNullOrEmpty(String string) {
		return string == null || string.length() == 0;
	}

	/**
	 * {@code null}または空文字列判定を行う。
	 * <p/>
	 * 与えられた文字列配列内の要素全てが{@code null}または空文字であれば{@code true}を返却する。
	 * <pre>
	 * |引数                | 戻り値
	 * +--------------------+--------
	 * | null               | true
	 * | {}                 | true
	 * | {"", null}         | true
	 * | { null, "a" }      | false
	 * | " " (半角スペース) | false
	 * | "　"(全角スペース) | false
	 * </pre>
	 *
	 * @param strings 文字列配列
	 * @return 全要素が{@code null}または空文字の時、{@code true}
	 * @see #isNullOrEmpty(String)
	 */
	@Published
	public static boolean isNullOrEmpty(String... strings) {
		return strings == null || isNullOrEmpty(Arrays.asList(strings));
	}

	/**
	 * {@code null}または空文字列判定を行う。
	 * <p/>
	 * 与えられたコレクション内の要素全てが{@code null}または空文字であれば{@code true}を返却する。
	 * <pre>
	 * |引数                | 戻り値
	 * +--------------------+--------
	 * | null               | true
	 * | {}                 | true
	 * | {"", null}         | true
	 * | { null, "a" }      | false
	 * | " " (半角スペース) | false
	 * | "　"(全角スペース) | false
	 * </pre>
	 *
	 * @param strings 文字列を格納したコレクション
	 * @return 全要素が{@code null}または空文字の時、{@code true}
	 * @see #isNullOrEmpty(String)
	 */
	@Published
	public static boolean isNullOrEmpty(Collection<String> strings) {
		if (strings == null) {
			return true;
		}
		for (String e : strings) {
			if (hasValue(e)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Stringインスタンスが何らかの文字を含んでいるか判定する。
	 * <p/>
	 * {@link StringUtil#isNullOrEmpty(String)}と逆の真偽値を返却する。
	 * 否定演算子を使用することで可読性が劣る場合は本メソッドを使用すると良い。<br/>
	 * 例を以下に示す。
	 * <code>
	 * <pre>
	 * private String something;
	 *
	 * public void hasSomething() {
	 *     return (!StringUtil.isNullOrEmpty(this.something)) {
	 * }
	 * </pre>
	 * </code>
	 * 以下のように書き換えることで、単純に読み下すことができる。
	 * <code>
	 * <pre>
	 * public void hasSomething() {
	 *     return StringUtil.hasValue(this.something);
	 * }
	 * </pre>
	 * </code>
	 *
	 * @param string 文字列
	 * @return なんらかの文字が含まれている場合は{@code true}
	 * @see #isNullOrEmpty(String)
	 */
	@Published
	public static boolean hasValue(String string) {
		return !isNullOrEmpty(string);
	}

	/**
	 * 文字列配列が何らかの文字列を含んでいるか判定する。
	 * <p/>
	 * {@link StringUtil#isNullOrEmpty(String...)}と逆の真偽値を返却する。
	 * 否定演算子を使用することで可読性が劣る場合は本メソッドを使用すると良い。
	 *
	 * @param strings 調査対象となる文字列配列
	 * @return 何らかの文字列を含む場合、{@code true}
	 * @see #isNullOrEmpty(String...)
	 * @see #hasValue(String)
	 */
	@Published
	public static boolean hasValue(String... strings) {
		return !isNullOrEmpty(strings);
	}

	/**
	 * コレクションが何らかの文字列を含んでいるか判定する。
	 * <p/>
	 * {@link StringUtil#isNullOrEmpty(Collection)}と逆の真偽値を返却する。
	 * 否定演算子を使用することで可読性が劣る場合は本メソッドを使用すると良い。
	 *
	 * @param strings 調査対象となるコレクション
	 * @return 何らかの文字列を含む場合、{@code true}
	 * @see #isNullOrEmpty(String...)
	 * @see #hasValue(String)
	 */
	@Published
	public static boolean hasValue(Collection<String> strings) {
		return !isNullOrEmpty(strings);
	}

	/**
	 * 指定された文字セットでバイト配列をデコードする。
	 * <p/>
	 * JDK1.6以上を使用する場合は、<code>java.lang.String(byte[], Charset)</code>を使用すること。<br/>
	 * {@code bytes}が{@code null}だった場合、{@code null}を返す。
	 *
	 * @param bytes   バイト配列
	 * @param charset 文字セット
	 * @return 文字列
	 */
	public static String toString(byte[] bytes, Charset charset) {
		assertNotNull(charset, "charset");
		if (bytes == null) {
			return null;
		}
		return charset.decode(ByteBuffer.wrap(bytes)).toString();
	}

	/**
	 * 指定された値を文字列に変換する。
	 * <p>
	 * 指定された値が{@link java.math.BigDecimal}の場合には、
	 * {@link BigDecimal#toPlainString()}を使用して文字列に変換する。
	 * それ以外のオブジェクトの場合には、{@code toString()}により文字列化を行う。
	 *
	 * @param value 文字列に変換する値
	 * @return 文字列に変換した値
	 */
	public static String toString(final Object value) {
		if (value instanceof BigDecimal) {
			return ((BigDecimal) value).toPlainString();
		} else {
			return value.toString();
		}
	}

	/**
	 * 指定された文字セットで文字列をエンコードする。
	 * <p/>
	 * JDK1.6以上を使用する場合は、<code>java.lang.String#getBytes(Charset)</code>を使用すること。<br/>
	 * {@code string}が{@code null}だった場合、{@code null}を返す。
	 * {@code string}が空文字だった場合、空のバイト配列を返す。
	 *
	 * @param string  文字列
	 * @param charset 文字セット
	 * @return バイト配列
	 */
	@Published(tag = "architect")
	public static byte[] getBytes(String string, Charset charset) {
		assertNotNull(charset, "charset");
		if (string == null) {
			return null;
		}
		if (string.length() == 0) {
			return new byte[0];
		}
		ByteBuffer buffer = charset.encode(string);
		byte[] bytes = new byte[buffer.limit()];
		System.arraycopy(buffer.array(), 0, bytes, 0, bytes.length);
		return bytes;
	}

	/**
	 * 文字列を繰り返す。
	 * <p/>
	 * 引数が文字列でない場合は、{@link String#valueOf(Object)}された文字列が繰り返される。
	 *
	 * @param repeated 繰り返し文字列({@code null}不可)
	 * @param times    繰り返し回数(0以上)
	 * @return 文字列
	 */
	@Published(tag = "architect")
	public static String repeat(Object repeated, int times) {
		assertNotNull(repeated, "repeated");
		assertNotTrue(times < 0, "times must not be negative.");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(repeated);
		}
		return sb.toString();
	}

	/**
	 * 区切り文字を文字列先頭から挿入する。
	 * <p/>
	 * 例:
	 * <code><pre>
	 * StringUtil.insert("あいうえお", ",", 1, 1, 1); //-->あ,い,う,えお
	 * </pre></code>
	 *
	 * @param target    対象文字列({@code null}不可)
	 * @param delimiter 区切り文字({@code null}不可)
	 * @param intervals 挿入間隔({@code null}不可・0不可)
	 * @return 区切り文字挿入後の文字列
	 */
	@Published(tag = "architect")
	public static String insert(String target, String delimiter, int... intervals) {
		// 引数チェック
		assertNotNull(target, "target");
		assertNotNull(delimiter, "delimiter");
		checkIntervals(intervals);

		StringBuilder result = new StringBuilder();
		StringIterator itr = StringIterator.forward(target);
		// 指定された間隔分、区切り文字を挿入する。
		for (int interval : intervals) {
			result.append(itr.next(interval));
			if (!itr.hasNext()) {
				break;
			}
			result.append(delimiter);
		}
		result.append(itr.rest());
		return result.toString();

	}

	/**
	 * 区切り文字を右側から挿入する。
	 * <p/>
	 * 例:
	 * <code><pre>
	 * StringUtil.insertFromRight("あいうえお", ",", 1, 1, 1); //-->あい,う,え,お
	 * </pre></code>
	 *
	 * @param target    対象文字列({@code null}不可)
	 * @param delimiter 区切り文字({@code null}不可)
	 * @param intervals 文字列後ろからの挿入間隔({@code null}不可・0不可)
	 * @return 区切り文字挿入後の文字列
	 */
	@Published(tag = "architect")
	public static String insertFromRight(String target, String delimiter, int... intervals) {
		// 引数チェック
		assertNotNull(target, "target");
		assertNotNull(delimiter, "delimiter");
		checkIntervals(intervals);

		StringBuilder result = new StringBuilder();
		StringIterator itr = StringIterator.reverse(target);
		int posIdx = 0, addCnt = 0;
		while (itr.hasNext()) { // 文字列を逆順に走査
			result.append(itr.next());
			addCnt++;
			if (posIdx < intervals.length // まだ区切り位置が残っていて、
					&& addCnt == intervals[posIdx] // 区切り位置に到達したら、
					&& itr.hasNext()) { // ただし、終端の場合は除く
				// 区切り文字を追加する。
				result.append(delimiter);
				posIdx++; // 次の挿入間隔へ
				addCnt = 0; // 区切り文字を入れたらリセット
			}
		}
		// 反転して返却
		return result.reverse().toString();
	}

	/**
	 * 区切り文字を等間隔で挿入する。
	 * <p/>
	 * 例:
	 * <code><pre>
	 * StringUtil.insertRepeatedly("あいうえお", ",", 1) //-->あ,い,う,え,お
	 * </pre></code>
	 *
	 * @param target    対象文字列({@code null}不可)
	 * @param delimiter 区切り文字({@code null}不可)
	 * @param interval  間隔(0不可)
	 * @return 区切り文字挿入後の文字列
	 */
	@Published(tag = "architect")
	public static String insertRepeatedly(String target, String delimiter, int interval) {

		StringBuilder result = insertAtRegularInterval(
				delimiter,
				interval,
				StringIterator.forward(target));
		return result.toString();
	}

	/**
	 * 区切り文字を右側から等間隔で挿入する。
	 * <p/>
	 * 例：
	 * <code><pre>
	 * StringUtil.insertRepeatedlyFromRight("あいうえお", ",", 1) //-->あ,い,う,え,お
	 * </pre></code>
	 *
	 * @param target    対象文字列
	 * @param delimiter 区切り文字
	 * @param interval  間隔(0不可)
	 * @return 区切り文字挿入後の文字列
	 */
	@Published(tag = "architect")
	public static String insertRepeatedlyFromRight(
			String target, String delimiter, int interval) {

		StringBuilder result = insertAtRegularInterval(
				delimiter,
				interval,
				StringIterator.reverse(target)); // 逆順に走査
		return result.reverse().toString(); // 反転して返却
	}

	/**
	 * 区切り文字を等間隔で挿入する。
	 *
	 * @param delimiter 区切り文字({@code null}不可)
	 * @param interval  間隔
	 * @param itr       文字列走査に使用するイテレータ
	 * @return 区切り文字挿入後の文字列
	 */
	private static StringBuilder insertAtRegularInterval(
			String delimiter, int interval, StringIterator itr) {

		assertNotNull(delimiter, "delimiter");
		checkInterval(interval);

		StringBuilder result = new StringBuilder();
		int addCnt = 0;
		while (itr.hasNext()) {
			result.append(itr.next());
			addCnt++;
			if (addCnt % interval == 0 && itr.hasNext()) {
				result.append(delimiter);
			}
		}
		return result;
	}

	/**
	 * 条件式が成り立たないことを表明する。<br/>
	 *
	 * @param conditionThatMustNotBeTrue {@code true}であってはならない条件
	 * @param msgWhenTrue                条件式が{@code true}であった場合のメッセージ
	 */
	private static void assertNotTrue(boolean conditionThatMustNotBeTrue, String msgWhenTrue) {
		if (conditionThatMustNotBeTrue) {
			throw new IllegalArgumentException(msgWhenTrue);
		}
	}

	/**
	 * 引数が{@code null}でないことを表明する。
	 *
	 * @param argumentThatMustNotBeNull {@code null}であってはならない引数
	 * @param argumentName              引数の名前
	 */
	private static void assertNotNull(Object argumentThatMustNotBeNull, String argumentName) {
		if (argumentThatMustNotBeNull == null) {
			throw new IllegalArgumentException(argumentName + " must not be null.");
		}
	}

	/**
	 * 文字列挿入の間隔チェックする。<br/>
	 * 以下の場合、例外を送出する。
	 * <ul>
	 * <li>引数が{@code null}または要素数が0の場合</li>
	 * <li>要素のうち、いずれかが0以下である場合</li>
	 * </ul>
	 *
	 * @param intervals 間隔
	 * @see #insert(String, String, int...)
	 * @see #insertFromRight(String, String, int...)
	 */
	private static void checkIntervals(int[] intervals) {
		assertNotTrue((intervals == null || intervals.length == 0),
				"intervals must not be null or empty.");

		for (int interval : intervals) {
			checkInterval(interval);
		}
	}

	/**
	 * 文字列挿入の間隔をチェックする。
	 * 0以下の場合は例外を送出する。
	 *
	 * @param interval 間隔
	 * @see #insertAtRegularInterval(String, int, StringIterator)
	 * @see #insertRepeatedly(String, String, int)
	 * @see #insertRepeatedlyFromRight(String, String, int)
	 */
	private static void checkInterval(int interval) {
		if (interval <= 0) {
			throw new IllegalArgumentException(
					"interval must not be zero or negative. but was [" + interval + "]");
		}
	}

	/**
	 * 行末の文字列を切り落とす。
	 * @param target 文字列({@code null}不可)
	 * @param end 取り除く文字列({@code null}不可)
	 * @return 行末を取り除いた文字列
	 * @throws {@link IllegalArgumentException} 引数が{@code null}の場合
	 */
	@Published
	public static String chomp(String target, String end) {
		if (target == null) {
			throw new IllegalArgumentException("target must not be null.");
		}
		if (end == null) {
			throw new IllegalArgumentException("end must not be null.");
		}
		return target.endsWith(end)
				? target.substring(0, target.length() - end.length())
				: target;
	}

	/**
	 * 文字列配列を連結する。
	 *
	 * @param arrays 配列({@code null}不可)
	 * @return 連結後の配列
	 * @throws {@link IllegalArgumentException} 配列が{@code null}の場合
	 */
	public static String[] merge(String[]... arrays) {
		if (arrays == null) {
			throw new IllegalArgumentException("argument must not be null.");
		}
		List<String> result = new ArrayList<String>();
		for (String[] array : arrays) {
			Collections.addAll(result, array);
		}
		return toArray(result);
	}

	/**
	 * コレクションを配列に変換する。
	 *
	 * @param collection 変換対象のコレクション({@code null}不可)
	 * @return 変換後の配列
	 * @throws {@link IllegalArgumentException} 変換対象のコレクションが{@code null}の場合
	 */
	public static String[] toArray(Collection<String> collection) {
		if (collection == null) {
			throw new IllegalArgumentException("argument must not be null.");
		}
		return collection.toArray(new String[collection.size()]);
	}

	/**
	 * 大文字を小文字にし、アンダースコアを削除する。
	 * <p/>
	 *
	 * @param value 変換対象の文字列({@code null}不可)
	 * @return 変換後の文字列
	 */
	public static String lowerAndTrimUnderScore(String value) {
		StringBuilder sb = new StringBuilder(value.length());
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c == '_') {
				continue;
			}
			sb.append(Character.toLowerCase(c));
		}
		return sb.toString();
	}

	/**
	 * 引数で渡された値が{@code null}の場合、空文字を返却する。<br/>
	 * そうでない場合は、引数をそのまま返却する。
	 * <pre>
	 * {@code
	 * StringUtil.nullToEmpty(null);   //--> ""
	 * StringUtil.nullToEmpty("");     //--> ""
	 * StringUtil.nullToEmpty("hoge"); //--> "hoge"
	 * }
	 * </pre>
	 * @param value 変換対象の値
	 * @return 変換後の値
	 */
	@Published
	public static String nullToEmpty(String value) {
		return value == null
				? ""
				: value;
	}

	/**
	 * 複数の文字列をセパレータを挟んで結合する。
	 *
	 * @param separator セパレータ
	 * @param params 結合する文字列
	 * @return セパレータで結合した文字列
	 */
	@Published
	public static String join(String separator, List<String> params) {
		StringBuilder sb = new StringBuilder();
		for (String param : params) {
			if (sb.length() != 0) {
				sb.append(separator);
			}
			sb.append(param);
		}
		return sb.toString();
	}

	/**
	 * 文字列をセパレータで分割する。
	 *
	 * @param str 分割対象文字列
	 * @param separator セパレータ
	 * @return 分割された文字列
	 */
	@Published
	public static List<String> split(String str, String separator) {
		return split(str, separator, false);
	}

	/**
	 * 文字列をセパレータで分割する。
	 *
	 * @param str 文字列
	 * @param separator セパレータ
	 * @param trim 分割後の文字列をトリムする場合、{@code true}
	 * @return 分割された文字列
	 */
	@Published
	public static List<String> split(String str, String separator, boolean trim) {

		Pattern pattern = Pattern.compile(separator);
		List<String> ret = new ArrayList<String>();
		for (String val : pattern.split(str)) {
			if (trim) {
				ret.add(val.trim());
			} else {
				ret.add(val);
			}
		}
		return ret;
	}
}
