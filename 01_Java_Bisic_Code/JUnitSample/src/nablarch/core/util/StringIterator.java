package nablarch.core.util;

import java.util.NoSuchElementException;

/**
 * 文字列を走査するクラス。
 * 本クラスはサロゲートペアに対応している。
 *
 * @author T.Kawasaki
 */
class StringIterator {

	/** 走査対象の文字列 */
	private final String string;

	/** 走査用のインデックス */
	private int index = 0;

	/**
	 * コンストラクタ。
	 *
	 * @param orig 走査対象となる文字列
	 */
	private StringIterator(String orig) {
		this.string = orig;
	}

	/**
	 * 現在位置から、未走査の文字があるかどうか判定する。
	 * @return 未走査の文字がある場合、真
	 */
	public boolean hasNext() {
		return index < string.length();
	}

	/**
	 * 現在位置から1文字取得する。
	 * 取得した文字がサロゲートペアの場合、戻り値の配列の要素数は2となる.
	 *
	 * @return 文字
	 */
	public char[] next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int cp = string.codePointAt(index);
		char[] chars = Character.toChars(cp);
		index += chars.length;
		return chars;
	}

	/**
	 * 現在位置を起点として、指定された文字数の部分文字列を取得する。
	 *
	 * @param numberOfLetters 取得したい文字数
	 * @return 部分文字列
	 */
	String next(int numberOfLetters) {
		StringBuilder chars = new StringBuilder();
		for (int i = 0; i < numberOfLetters && hasNext(); i++) {
			chars.append(next());
		}
		return chars.toString();
	}

	/**
	 * 現在位置を起点として、残りの部分文字列を取得する。
	 *
	 * @return 残りの部分文字列
	 */
	String rest() {
		String rest = string.substring(index);
		index = string.length();
		return rest;
	}

	/**
	 * 正順のイテレータを生成する。
	 *
	 * @param string 走査対象となる文字列
	 * @return 正順のイテレータ
	 */
	static StringIterator forward(String string) {
		checkArgument(string);
		return new StringIterator(string);
	}

	/**
	 * 逆順のイテレータを生成する。
	 *
	 * @param string 操作対象となる文字列
	 * @return 逆順のイテレータ
	 */
	static StringIterator reverse(String string) {
		checkArgument(string);
		return new StringIterator(new StringBuilder(string).reverse().toString());
	}

	/**
	 * 引数のチェックを行う。
	 *
	 * @param string 引数
	 * @throws IllegalArgumentException 引数がnullの場合
	 */
	private static void checkArgument(String string) {
		if (string == null) {
			throw new IllegalArgumentException("argument must not be null.");
		}
	}
}
