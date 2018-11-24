package nablarch.core.message;

import java.text.MessageFormat;
import java.util.Map;

/**
 * オプション情報によりメッセージのフォーマット方法を切り替えフォーマットを行うクラス。
 *
 * オプション情報が1つで{@link Map}のサブタイプの場合は、{@link NamedMessageFormat}を使用してメッセージをフォーマットする。
 * それ以外の場合は、{@link MessageFormat}を使用してメッセージをフォーマットする。
 * 
 * @author Hisaaki Shioiri
 * @see MessageFormat
 * @see NamedMessageFormat
 */
public class BasicMessageFormatter implements MessageFormatter {

	@Override
	public String format(final String template, final Object[] options) {
		final String result;
		if (options == null) {
			result = template;
		} else if (isMap(options)) {
			result = new NamedMessageFormat(template).format(toMap(options[0]));
		} else {
			result = new MessageFormat(template).format(options);
		}
		return result;
	}

	/**
	 * オプション情報がMapかどうか判定する。
	 * <p>
	 * 以下の条件をみたす場合Mapと判断する。
	 * <ul>
	 * <li>オプションの要素数が1つの場合</li>
	 * <li>オプションの唯一の要素が{@link Map}の実装クラスの場合</li>
	 * </ul>
	 *
	 * @param options オプション情報
	 * @return {@code Map}の場合{@code true}
	 */
	private static boolean isMap(final Object[] options) {
		return options.length == 1 && options[0] instanceof Map;
	}

	/**
	 * オプション情報をMapに変換する。
	 *
	 * @param option オプション
	 * @return Mapに変換した値
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, Object> toMap(final Object option) {
		return (Map<String, Object>) option;
	}

	/**
	 * 名前付きのオプション情報({@link Map})を使ってテンプレート文字列をフォーマットするクラス。
	 * <p>
	 * 以下のように、{@link Map}のキー名を使ってテンプレート文字列に値を埋め込むことが出来る。
	 * <pre>
	 * {@code
	 * 
	 * Map<String, Object> options = new HashMap<String, Object>()
	 * options.put("name", "なまえ");
	 * String message = new NamedMessageFormat("{name}を入力してください").format(options);
	 *
	 * message -> なまえを入力してください。
	 * }
	 * </pre>
	 */
	private static final class NamedMessageFormat {

		/** テンプレート文字列 */
		private final String template;

		/**
		 * 指定のテンプレート文字列を持つフォーマッタを構築する。
		 *
		 * @param template テンプレート文字列
		 */
		private NamedMessageFormat(final String template) {
			this.template = template;
		}

		/**
		 * フォーマット処理を行う。
		 *
		 * @param options オプション情報
		 * @return フォーマット後の文字列
		 */
		private String format(final Map<String, ?> options) {
			String result = template;
			for (final Map.Entry<String, ?> entry : options.entrySet()) {
				result = result.replace('{' + entry.getKey() + '}', convert(entry.getValue()));
			}
			return result;
		}

		/**
		 * 文字列に変換する。
		 * <p>
		 * オブジェクトがnullの場合は空文字列を返す。
		 * null以外の場合は、{@link String#valueOf(Object)}で文字列に変換する。
		 *
		 * @param value 変換対象の値
		 * @return 文字列に変換した値
		 */
		private static String convert(final Object value) {
			return value == null ? "" : String.valueOf(value);
		}
	}
}
