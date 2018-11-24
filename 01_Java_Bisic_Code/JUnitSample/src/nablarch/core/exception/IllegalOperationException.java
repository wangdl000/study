package nablarch.core.exception;

/**
 * 間違った呼び出しに対する例外クラス。
 *
 * @author tani takanori
 */
public class IllegalOperationException extends RuntimeException {

	/**
	 * コンストラクタ。
	 *
	 * @param message メッセージ
	 */
	public IllegalOperationException(String message) {
		super(message);
	}
}
