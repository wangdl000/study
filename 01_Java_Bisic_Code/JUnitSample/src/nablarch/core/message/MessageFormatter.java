package nablarch.core.message;

/**
 * メッセージをフォーマットするインタフェース。
 *
 * @author Hissaki Shioiri
 */
public interface MessageFormatter {

	/**
	 * メッセージをフォーマットする。
	 *
	 * @param template フォーマット対象のメッセージテンプレート
	 * @param options オプション情報
	 * @return フォーマット後のメッセージ
	 */
	String format(String template, Object[] options);
}
