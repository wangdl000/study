package nablarch.core.text;

import java.util.ArrayList;
import java.util.List;

/**
 * フォーマッタを保持するクラス。
 *
 * @author Ryota Yoshinouchi
 */
public class FormatterConfig {

	/**
	 * フォーマッタのリスト
	 */
	private List<Formatter<?>> formatters;

	/**
	 * デフォルトコンストラクタ。
	 * <p/>
	 * デフォルトのフォーマッタを設定する。
	 */
	public FormatterConfig() {
		formatters = new ArrayList<Formatter<?>>();
		formatters.add(new DateTimeFormatter());
		formatters.add(new NumberFormatter());
		formatters.add(new DateTimeStrFormatter());
		formatters.add(new NumberStrFormatter());
	}

	/**
	 * フォーマッタのリストを取得する。
	 *
	 * @return フォーマッタのリスト
	 */
	public List<Formatter<?>> getFormatters() {
		return formatters;
	}

	/**
	 * フォーマッタのリストを設定する。
	 *
	 * @param formatters フォーマッタのリスト
	 */
	public void setFormatters(List<Formatter<?>> formatters) {
		this.formatters = formatters;
	}
}
