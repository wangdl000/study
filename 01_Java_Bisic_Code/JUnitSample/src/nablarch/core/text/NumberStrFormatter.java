package nablarch.core.text;

import nablarch.core.util.StringUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * 数値文字列をフォーマットするクラス
 *
 * @author Ryota Yoshinouchi
 */
public class NumberStrFormatter implements Formatter<String> {

	/**
	 * フォーマッタの名前
	 */
	private String formatterName = "number";

	/**
	 * デフォルトのフォーマットパターン
	 */
	private String defaultPattern = "#,###.###";

	@Override
	public Class<String> getFormatClass() {
		return String.class;
	}

	@Override
	public String getFormatterName() {
		return formatterName;
	}

	/**
	 * デフォルトの書式で数値文字列をフォーマットする。
	 * フォーマット対象がnullの場合はnullを返却する。
	 *
	 * @param input フォーマット対象
	 * @return フォーマットされた文字列　
	 */
	@Override
	public String format(String input) {
		return format(input, defaultPattern);
	}

	/**
	 * 指定された書式で数値をフォーマットする。
	 * 指定するフォーマットは{@link DecimalFormat}の仕様に準拠すること。
	 * フォーマット対象がnullの場合はnullを返却する。
	 *
	 * @param input   フォーマット対象
	 * @param pattern フォーマットの書式
	 * @return フォーマットされた文字列
	 */
	@Override
	public String format(String input, String pattern) {
		if (StringUtil.isNullOrEmpty(pattern)) {
			throw new IllegalArgumentException("pattern must not be null.");
		}
		if (StringUtil.isNullOrEmpty(input)) {
			return input;
		}

		// 指数表現を含む場合はそのまま返す。
		if (input.toUpperCase().contains("E")) {
			return input;
		}

		Locale locale = Locale.getDefault();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
		// ロケールに応じた区切り文字を取り除く
		input = input.replace(String.valueOf(symbols.getGroupingSeparator()), "");
		char point = symbols.getDecimalSeparator();
		if (point != '.') {
			// 小数点が '.' でない場合は'.'で置き換える
			input = input.replace(point, '.');
		}
		Number number = new BigDecimal(input);

		DecimalFormat decimalFormat;
		//Javadocにある以下の記載をもとにDecimalFormatのインスタンスを取得している。
		//https://docs.oracle.com/javase/jp/9/docs/api/java/text/NumberFormat.html より
		//> フォーマットや解析をさらに制御したい場合、あるいはこのような制御をユーザーが使えるようにしたい場合は、
		//> ファクトリ・メソッドから得られるNumberFormatをDecimalFormatにキャストすることもできます。
		//> これはほとんどのロケールで有効ですが、有効にならないロケールの場合に備えて、これはtryブロックに指定してください。
		try {
			decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
		} catch (RuntimeException e) {
			//NumberFormat.getInstanceにthrowsの宣言がないためRuntimeExceptionをcatchしている
			throw new IllegalArgumentException("invalid locale for DecimalFormat, locale = " + locale, e);
		}

		try {
			decimalFormat.applyPattern(pattern);
			return decimalFormat.format(number);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					String.format("format failed. input = [%s] pattern = [%s] locale = [%s]",
							input, pattern, locale),
					e);
		}
	}

	/**
	 * フォーマッタの名前を設定する。
	 *
	 * @param formatterName フォーマッタの名前
	 */
	public void setFormatterName(String formatterName) {
		this.formatterName = formatterName;
	}

	/**
	 * フォーマットのデフォルトの書式を設定する。
	 *
	 * @param defaultPattern デフォルトの書式
	 */
	public void setDefaultPattern(String defaultPattern) {
		this.defaultPattern = defaultPattern;
	}
}
