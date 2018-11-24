package nablarch.core.exception;

/**
 * 設定不備を表す例外クラス。
 *
 * @author siosio
 */
public class IllegalConfigurationException extends RuntimeException {

	/**
	 * 例外を生成する。
	 */
	public IllegalConfigurationException() {
		super();
	}

	/**
	 * メッセージを元に例外を生成する。
	 *
	 * @param message メッセージ
	 */
	public IllegalConfigurationException(final String message) {
		super(message);
	}

	/**
	 * メッセージと元例外を元に例外を生成する。
	 * @param message メッセージ
	 * @param cause 元例外
	 */
	public IllegalConfigurationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * 元例外を元に例外を生成する。
	 * @param cause 元例外
	 */
	public IllegalConfigurationException(final Throwable cause) {
		super(cause);
	}
}
