package nablarch.core.text;

import nablarch.core.repository.SystemRepository;
import nablarch.core.util.annotation.Published;

import java.util.List;

/**
 * オブジェクトのフォーマットに使用するユーティリティクラス。
 *
 * @author Ryota Yoshinouchi
 */
@Published
public final class FormatterUtil {

	/**
	 * フォーマッタリストを保持するコンポーネント名。
	 */
	private static final String FORMATTER_CONFIG = "formatterConfig";

	/**
	 * フォーマッタのデフォルト値を設定していない場合に使用するデフォルト値
	 */
	private static final FormatterConfig DEFAULT_CONFIG = new FormatterConfig();

	/**
	 * 本クラスはインスタンスを生成しない。
	 */
	private FormatterUtil() {
	}

	/**
	 * デフォルトの書式でフォーマットを行う。
	 *
	 * @param formatterName 使用するフォーマッタの名前
	 * @param input         フォーマット対象
	 * @param <T>           フォーマット対象の型
	 * @return フォーマットされた文字列
	 */
	public static <T> String format(String formatterName, T input) {
		if (input == null) {
			return null;
		}
		Formatter<T> formatter = getFormatter(formatterName, input.getClass());
		return formatter.format(input);
	}

	/**
	 * 書式を指定してフォーマットを行う。
	 *
	 * @param formatterName 使用するフォーマッタの名前
	 * @param input         フォーマット対象
	 * @param pattern       フォーマットの書式
	 * @param <T>           フォーマット対象の型
	 * @return フォーマットされた文字列
	 */
	public static <T> String format(String formatterName, T input, String pattern) {
		if (input == null) {
			return null;
		}
		Formatter<Object> formatter = getFormatter(formatterName, input.getClass());
		return formatter.format(input, pattern);
	}

	/**
	 * システムリポジトリからフォーマッタを取得する。
	 * フォーマッタ名とフォーマット対象の型に対応するフォーマッタが
	 * システムリポジトリに登録されていない場合は例外を送出する。
	 *
	 * @param <T>           フォーマット対象の型
	 * @param formatterName 取得するフォーマッタの名前
	 * @param clazz フォーマット対象の型
	 * @return フォーマッタ
	 */
	@SuppressWarnings("unchecked")
	private static <T> Formatter<T> getFormatter(String formatterName, Class<?> clazz) {
		FormatterConfig formatterConfig = (FormatterConfig) SystemRepository.getObject(FORMATTER_CONFIG);
		if (formatterConfig == null) {
			formatterConfig = DEFAULT_CONFIG;
		}
		List<Formatter<?>> formatters = formatterConfig.getFormatters();
		for (Formatter<?> formatter : formatters) {
			if (formatter.getFormatterName().equals(formatterName)
					&& formatter.getFormatClass().isAssignableFrom(clazz)) {
				return (Formatter<T>) formatter;
			}
		}
		throw new IllegalArgumentException(
				"no such formatter registered in SystemRepository, formatterName = " + formatterName);
	}
}
