package nablarch.core.message;

import nablarch.core.util.annotation.Published;

/**
 * メッセージの通知レベルを表す列挙型。
 * 
 * @author Koichi Asano
 *
 */
@Published
public enum MessageLevel {

	/**
	 * 情報レベルのメッセージ。
	 * <p/>
	 * 正常に処理が行なわれている際に表示するメッセージに指定する。
	 */
	INFO,
	/**
	 * 警告レベルのメッセージ。
	 * <p/>
	 * 処理を継続可能であるが、確認が必要な情報を通知するメッセージに指定する。
	 */
	WARN,
	/**
	 * エラーレベルのメッセージ。
	 * <p/>
	 * 処理を継続できない問題の発生を通知するメッセージに指定する。
	 */
	ERROR
}
