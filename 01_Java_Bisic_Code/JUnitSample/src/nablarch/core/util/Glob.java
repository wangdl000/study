package nablarch.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Glob書式を{@link Pattern}オブジェクトに変換するユーティリティクラス。
 * @author Iwauo Tajima
 * @see Pattern
 */
public final class Glob {

	/** このクラスはインスタンスを生成しない。  */
	private Glob() {
		// Doesn't need any instances.
	}

	/**
	 * グロブ書式を等価な正規表現に変換しコンパイルする。
	 * <pre>
	 *   例)
	 *     ============      ==========================
	 *       グロブ式           等価な正規表現
	 *     ============      ==========================
	 *     "*"           =>  /^[^/]*$/
	 *     ""            =>  /^[^/]*$/
	 *     "*Test.java"  =>  /^[^/]*?Test\.java$/
	 *     "/src/*.java" =>  /^\/src\/[^/]*?\.java$/
	 *     "Test?.java"  =>  /^Test[^/]\.java$/
	 *     ============      ==========================
	 * </pre>
	 * [],|,()に対応する必要がある。
	 *
	 * @param glob グロブ式
	 * @return コンパイル済み正規表現オブジェクト
	 * @see Pattern
	 */
	public static Pattern compile(String glob) {
		if (StringUtil.isNullOrEmpty(glob)) {
			return MATCH_ANY;
		}
		StringBuilder buff = new StringBuilder();
		Matcher m = WILDCARD.matcher(glob);
		int head = 0;
		while (m.find()) {
			String pattern = m.group().equals("*")
					? "[^/]*?"
					: "[^/]";

			buff.append(
					Pattern.quote(glob.substring(head, m.start()))).append(pattern);
			head = m.end();
		}
		buff.append(Pattern.quote(glob.substring(head, glob.length())));
		return Pattern.compile("^" + buff.toString() + "$");
	}

	/** Glob式の"*"に相当するパターン。 */
	private static final Pattern MATCH_ANY = Pattern.compile("[^/]*");
	/** ワイルドカード文字列("*", "?") */
	private static final Pattern WILDCARD = Pattern.compile("[?*]");
}
