package nablarch.core.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nablarch.core.util.annotation.Published;

/**
 * List・Map・String 等の基本型からなるオブジェクトグラフの生成を簡略化する
 * ユーティリティメソッドを提供する。
 *
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
public final class Builder {

	/** 本クラスはインスタンスを持たない。 */
	private Builder() {
	} // Doesn't need any instances.

	/** 改行文字 */
	public static final String LS = "\n";

	/**
	 * linesの各要素のtoString()の結果を、separatorで連結した文字列を返す。
	 * <pre>
	 * {@code
	 * List<String> list = Arrays.asList("あ", "い", "う");
	 * String str = Builder.join(list, ","); //--> "あ,い,う"
	 * }
	 * </pre>
	 *
	 * @param lines 連結される要素文字列
	 * @param separator 要素間に連結される文字列
	 * @return 連結後の文字列
	 */
	@Published(tag = "architect")
	public static String join(Iterable<?> lines, String separator) {
		StringBuilder buff = new StringBuilder();
		Iterator<?> itr = lines.iterator();
		while (itr.hasNext()) {
			Object line = itr.next();
			line = (line == null) ? "" : line;
			buff.append(line.toString());
			if (itr.hasNext()) {
				buff.append(separator);
			}
		}
		return buff.toString();
	}

	/**
	 * linesの各要素のtoString()の結果を、separatorで連結した文字列を返す。
	 * <pre>
	 * {@code
	 * String[] lines = {"あ", "い", "う"};
	 * String str = Builder.join(lines, ","); //--> "あ,い,う"
	 * }
	 * </pre>
	 *
	 * @param lines 連結される要素文字列
	 * @param separator 要素間に連結される文字列
	 * @return 連結後の文字列
	 */
	@Published(tag = "architect")
	public static String join(Object[] lines, String separator) {
		return (lines == null) ? "null"
				: join(Arrays.asList(lines), separator);
	}

	/**
	 * elementsの各要素のtoString()の結果を単純に連結した文字列を返す。
	 * 大量の文字列連結を行う場合、+演算子による連結より処理効率がよい。
	 * <pre>
	 * {@code
	 * String str = Builder.concat("あ", "い", "う"); //--> "あいう"
	 * }
	 * </pre>
	 *
	 * @param elements 要素
	 * @return 連結文字列
	 */
	@Published(tag = "architect")
	public static String concat(Object... elements) {
		return join(elements, "");
	}

	/**
	 * linesの各要素のtoString()の結果を{@link #LS}で連結した文字列を返す。
	 * <pre>
	 * {@code
	 * List<String> list = Arrays.asList("あ", "い", "う");
	 * String str = Builder.join(list); //--> "あ\nい\nう"
	 * }
	 * </pre>
	 *
	 * @param lines 連結される要素文字列
	 * @return 連結後の文字列
	 */
	@Published(tag = "architect")
	public static String join(Iterable<?> lines) {
		return join(lines, LS);
	}

	/**
	 * 改行文字によって文字列を分割する。
	 * <pre>
	 * このメソッドの処理は以下のコードと同等である。
	 *     split(string,  System.getProperty("line.separator"));
	 * </pre>
	 *
	 * @param string 分割対象文字列
	 * @return 分割後文字列
	 */
	public static List<String> split(Object string) {
		return split(string, LS);
	}

	/**
	 * 指定した連結文字によって文字列を分割する。
	 * <pre>
	 * 分割対象文字列がString型でない場合はそのtoString()の結果を対象とする。
	 * 分割対象文字列がnullであった場合は空文字列を返す。
	 * </pre>
	 *
	 * @param string 分割対象文字列
	 * @param lineSeparator 連結文字もしくはその正規表現
	 * @return 分割後文字列
	 */
	public static List<String> split(Object string, String lineSeparator) {
		String str = (string == null) ? ""
				: string.toString();
		return Arrays.asList(str.split(lineSeparator));
	}

	/**
	 * 各引数に対するtoString()の結果を改行文字(line.separator)で連結した文字列を返す。
	 * <pre>
	 * 引数にnullが渡された場合は単に無視される。
	 *  (空行が出力されるわけではない。)
	 * </pre>
	 *
	 * @param lines 各行の文字列を保持するオブジェクト
	 * @return 連結後文字列
	 */
	public static String lines(final Object... lines) {
		return lines(false, lines);
	}

	/**
	 * lines()メソッドにテンプレート文字列を解釈する機能を追加したもの。
	 * <pre>
	 * 引数文字列に"%"が含まれる場合はテンプレート文字列とみなされ、
	 * 埋め込みパラメータ数と同数の後続引数がString.format()の仕様に従って埋め込まれる。
	 * この際、埋め込まれる引数に対するテンプレート文字列の評価は行わない。
	 * </pre>
	 *
	 * @param lines 連結対象文字列
	 * @return 連結後文字列
	 * @see #lines(Object...)
	 */
	public static String linesf(final Object... lines) {
		return lines(true, lines);
	}

	/**
	 * lines()・linesf()の実装実体。
	 *
	 * @param usesFormatting フォーマット文字列を認識させるか否か
	 * @param lines 連結対象文字列
	 * @return 連結後文字列
	 */
	private static String lines(boolean usesFormatting, Object... lines) {
		StringBuilder buffer = new StringBuilder();
		if (usesFormatting) {
			lines = applyFormat(lines);
		}
		for (Object line : lines) {
			if (line == null) {
				continue;
			}
			buffer.append(line.toString()).append(LS);
		}
		return buffer.substring(0, buffer.length() - LS.length());
	}

	/**
	 * printf型のテンプレートを適用し、その結果を返す。
	 *
	 * @param elements テンプレート文字列とその引数。
	 * @return テンプレート適用後の文字列
	 */
	private static Object[] applyFormat(Object... elements) {
		List<Object> result = new ArrayList<Object>();
		for (int i = 0; i < elements.length; i++) {
			Object element = elements[i];
			if (element == null || !(element instanceof String)) {
				result.add(element);
				continue;
			}
			String str = element.toString();
			Matcher embedParams = HAS_EMBED_PARAMS.matcher(str);
			if (embedParams.find()) {
				int paramNum = 1;
				while (embedParams.find()) {
					paramNum++;
				}
				Object[] params = new Object[paramNum];
				System.arraycopy(elements, i + 1, params, 0, paramNum);
				//Arrays.copyOfRange(elements, i + 1, i + 1 + paramNum);
				i += paramNum;
				str = String.format(str, params);
			}
			result.add(str);
		}
		return result.toArray();
	}

	/** テンプレート文字列が含まれるかどうか。 */
	private static final Pattern HAS_EMBED_PARAMS = Pattern.compile(
			"(?<!%)%([0-9]+(.[0-9]+)?)?[dxofegascbhn]");

	/**
	 * elementType型のインスタンスを要素とするList(ArrayList)を生成する。
	 * <pre>
	 * 引数elementsの各要素は以下の規則に従ってelementType型、もしくはnullに変換され、
	 *  戻り値の対応する要素に設定される。
	 *    1. 引数の要素がnullだった場合
	 *       戻り値の対応する要素にはnullが設定される。
	 *    2. 引数の要素がelementTypeに適合する型のインスタンスだった場合
	 *       戻り値の対応する要素には、そのインスタンスがそのまま設定される。
	 *    3. 引数の要素がelementTypeに適合しないインスタンスだった場合。
	 *       下記の条件を満たすメソッドがelementTypeに定義されていれば、
	 *       その実行結果を戻り値の対応する要素に設定する。
	 *       条件を満たすメソッドが存在しない場合、実行時例外を送出する。
	 *       a. スタティックメソッド elementType.valueOf("引数の要素の型")
	 *       b. コンストラクタ elementType("引数の要素の型")
	 *    使用例::
	 *        List<java.sql.Date> leapDays = Builder.listf(java.sql.Date.class
	 *        , java.sql.Date.valueOf("2004-02-29") // elementTypeのオブジェクトを設定。
	 *        , "2008-02-29"                        // java.sql.Date.valueOf(String) の結果が格納される。
	 *        );
	 * </pre>
	 *
	 * @param <T> 生成されるListの要素型
	 * @param memberType 生成されるListの要素型
	 * @param elements 生成されるListの要素
	 * @return elementType型のインスタンスを要素とするList
	 */
	public static <T> List<T> list(Class<T> memberType, Object... elements) {
		return list(false, memberType, elements);
	}

	/**
	 * {@link #list(Class, Object...)} をprintf型の埋め込みパラメータが使用できるように拡張したもの。
	 * <pre>
	 *    使用例::
	 *      String leapDate = "02-29";
	 *      List<java.sql.Date> leapDays = Builder.listf(java.sql.Date.class
	 *      , java.sql.Date.valueOf("2004-02-29") // elementTypeのオブジェクトを設定。
	 *      , "2008-02-29"                        // java.sql.Date.valueOf(String) の結果が格納される。
	 *      , "2012-%s", leapDate                 // 埋め込みパラメータを使用。
	 *      );
	 * </pre>
	 *
	 * @param <T> 生成されるListの要素型
	 * @param memberType 生成されるListの要素型
	 * @param elements 生成されるListの要素と埋め込みパラメータ
	 * @return elementType型のインスタンスを要素とするList
	 */
	public static <T> List<T> listf(Class<T> memberType, Object... elements) {
		return list(true, memberType, elements);
	}

	/**
	 * listf・list の実装実体
	 *
	 * @param <T> 生成されるListの要素型
	 * @param usesFormatting printf型のテンプレート文字列を解釈するか否か
	 * @param memberType 生成されるListの要素型
	 * @param elements 生成されるListの要素と埋め込みパラメータ
	 * @return elementType型のインスタンスを要素とするList
	 */
	@SuppressWarnings("unchecked")
	static <T> List<T> list(boolean usesFormatting,
			Class<T> memberType,
			Object... elements) {
		List<T> result = new ArrayList<T>();
		if (usesFormatting) {
			elements = applyFormat(elements);
		}
		for (Object element : elements) {
			if (element instanceof String) {
				element = valueOf(memberType, element);
			}
			result.add((T) element);
		}
		return result;
	}

	/**
	 * 文字列から適切なデータ型を自動判別してオブジェクトを生成する。
	 * @param literal データオブジェクトの文字列表現
	 * @return オブジェクト
	 */
	public static Object valueOf(String literal) {
		Class<?> clazz = typeOf(literal);
		if (clazz.equals(String.class)) {
			Matcher m = QUOTED_STRING.matcher(literal);
			if (m.matches()) {
				literal = m.group().substring(1, literal.length() - 1);
			}
		}
		return (Object) valueOf(clazz, literal);
	}

	/**
	 * 文字列から適切なデータ型を自動判別する。
	 * @param literal データオブジェクトの文字列表現
	 * @return データ型
	 */
	public static Class<?> typeOf(String literal) {
		if (QUOTED_STRING.matcher(literal).matches()) {
			return String.class;
		}
		if (literal.matches("^\\d+$")) {
			return Integer.class;
		}
		if (literal.matches("^\\d+(\\.\\d+)?$")) {
			return Double.class;
		}
		return String.class;
	}

	/** 引用符付き文字列 */
	static final Pattern QUOTED_STRING = Pattern.compile(
			"^('[^']*'|\"[^\"]*\")$");

	/**
	 * 指定された文字列表現から、指定された型のオブジェクトを生成する。
	 * @param <T>   変換先の型
	 * @param type  変換先の型
	 * @param value 変換対象文字列
	 * @return 変換結果
	 */
	@SuppressWarnings("unchecked")
	public static <T> T valueOf(Class<T> type, Object value) {
		if (type.equals(Class.class)) {
			try {
				return (T) Class.forName(value.toString());
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		if (type.equals(String.class)) {
			return (T) value.toString();
		}
		Method staticConstructor = getStaticConstructorFromString(type, value);
		if (staticConstructor == null) {
			throw new RuntimeException(
					"Static constructor 'valueOf(...)' wasn't found in " + type);
		}
		try {
			return (T) staticConstructor.invoke(null, value);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 指定されたクラスの文字列引数のスタティックコンストラクタを取得する。
	 *
	 * @param elementType コンストラクタの型
	 * @param value 文字列変換対象のオブジェクト
	 * @return スタティックコンストラクタ
	 */
	static Method getStaticConstructorFromString(Class<?> elementType, Object value) {
		Method result = null;
		for (Method method : elementType.getDeclaredMethods()) {
			if (method.getName().equals("valueOf")
					&& Modifier.isStatic(method.getModifiers())
					&& method.getReturnType().equals(elementType)
					&& method.getParameterTypes().length == 1
					&& method.getParameterTypes()[0].isAssignableFrom(value.getClass())) {
				result = method;
				break;
			}
		}
		return result;
	}
}
