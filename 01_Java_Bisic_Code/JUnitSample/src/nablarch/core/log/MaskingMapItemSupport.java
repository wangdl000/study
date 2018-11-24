package nablarch.core.log;

import java.util.Map;
import java.util.regex.Pattern;

import nablarch.core.log.LogUtil.MapValueEditor;
import nablarch.core.log.LogUtil.MaskingMapValueEditor;

/**
 * マスキング済みのマップを取得する{@link LogItem}の実装をサポートするクラス。
 * @author Kiyohito Itoh
 * @param <T>
 */
public abstract class MaskingMapItemSupport<T> implements LogItem<T> {
	/** マップの値を編集する{@link MapValueEditor} */
	private MapValueEditor mapValueEditor;
	/** マップの値間の区切り文字 */
	private String separator;

	/**
	 * コンストラクタ。
	 * @param maskingChar マスク文字
	 * @param maskingPatterns マスク対象のパターン
	 * @param separator マップの値間の区切り文字
	 */
	public MaskingMapItemSupport(char maskingChar, Pattern[] maskingPatterns, String separator) {
		this.mapValueEditor = new MaskingMapValueEditor(maskingChar, maskingPatterns);
		this.separator = separator;
	}

	/**
	 * マスキング済みのマップを取得する。<br>
	 * マップのダンプは、{@link LogUtil#dumpMap(Map, String, MapValueEditor)}を使用する。
	 * @param context ログの出力項目の取得に使用するコンテキスト
	 * @return マスキング済みのマップのダンプ
	 */
	public String get(T context) {
		return LogUtil.dumpMap(getMap(context), separator, mapValueEditor);
	}

	/**
	 * コンテキストからマップを取得する。
	 * @param context ログの出力項目の取得に使用するコンテキスト
	 * @return マップ
	 */
	protected abstract Map<String, ?> getMap(T context);
}
