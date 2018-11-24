package nablarch.core.log;

import nablarch.core.util.annotation.Published;

/**
 * ログの出力項目を取得するインタフェース。
 * @author Kiyohito Itoh
 * @param <CTX> ログ出力項目の取得に使用するコンテキストの型
 */
@Published(tag = "architect")
public interface LogItem<CTX> {
	/**
	 * ログの出力項目を取得する。
	 * @param context ログの出力項目の取得に使用するコンテキスト
	 * @return ログの出力項目
	 */
	String get(CTX context);
}
