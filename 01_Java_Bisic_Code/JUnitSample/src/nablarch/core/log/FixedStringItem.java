package nablarch.core.log;

/**
 * 固定文字列を取得するクラス。
 * @author Kiyohito Itoh
 */
public class FixedStringItem implements LogItem<Object> {

	/** 固定文字列 */
	private String fixedString;

	/**
	 * コンストラクタ。
	 * <pre>
	 * 固定文字列内の改行コードとタブ文字を表す文字を、物理的な改行及びタブに変換する。
	 * </pre>
	 * @param fixedString 固定文字列
	 */
	public FixedStringItem(String fixedString) {
		this.fixedString = fixedString.replace("\n", Logger.LS)
				.replace("\\n", Logger.LS)
				.replace("\\t", "\t");
	}

	/**
	 * 固定文字列を取得する。
	 * @param context ログコンテキスト
	 * @return 固定文字列
	 */
	public String get(Object context) {
		return fixedString;
	}
}
