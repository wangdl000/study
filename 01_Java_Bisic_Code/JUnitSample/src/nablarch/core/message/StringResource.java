package nablarch.core.message;

import java.util.Locale;

import nablarch.core.util.annotation.Published;

/**
 * ユーザに通知するメッセージの元となる文字列リソースを保持するインタフェース。<br/>
 * 複数言語に対応するアプリケーションでは、文字列リソースから言語ごとに異なる文字列を取得できる。
 * 
 * 
 * @author Koichi Asano
 *
 */
@Published
public interface StringResource {

	/**
	 * 文字列リソースのメッセージIDを取得する。
	 * @return メッセージID
	 */
	String getId();

	/**
	 * 言語に対応する文字列を取得する。
	 * 
	 * @param locale 言語
	 * @return 言語に対応する文字列
	 */
	String getValue(Locale locale);
}
