package nablarch.fw;

import nablarch.core.util.annotation.Published;

/**
 * ハンドラーキュー上に処理を委譲するためのハンドラが存在しない場合に
 * 送出される例外。
 * 
 * @author Iwauo Tajima
 */
@Published(tag = "architect")
public class NoMoreHandlerException extends Result.NotFound {
	/**
	 * デフォルトコンストラクタ
	 */
	public NoMoreHandlerException() {
		this("There were no handlers that process your request.");
	}

	/**
	 * コンストラクタ
	 * @param message エラーメッセージ
	 */
	public NoMoreHandlerException(String message) {
		super(message);
	}
}
