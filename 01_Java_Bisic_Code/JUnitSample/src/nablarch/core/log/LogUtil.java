package nablarch.core.log;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nablarch.core.util.StringUtil;
import nablarch.core.util.annotation.Published;

/**
 * ログ出力の実装を助けるユーティリティ。
 * @author Kiyohito Itoh
 */
public final class LogUtil {

	/** 隠蔽コンストラクタ */
	private LogUtil() {
	}

	/** システムプロパティから起動プロセスを識別する文字列を取得する際に使用するキー */
	private static final String SYSTEM_PROP_BOOT_PROCESS = "nablarch.bootProcess";

	/** 実行時IDの日時(ミリ秒)をフォーマットする際に使用するフォーマッタ */
	private static final DateFormat EXECUTION_ID_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	/** 実行時IDの連番(4桁)に使用する値 */
	private static int executionIdSequence = 1;

	/**
	 * 実行時IDを生成する。
	 * <pre>
	 * 実行時IDは下記のフォーマットで生成する。
	 * 
	 * 起動プロセス＋日時("yyyyMMddHHmmssSSS")＋連番(4桁)
	 * 
	 * 起動プロセスは{@link #getBootProcess()}から取得する。
	 * </pre>
	 * @return 実行時ID
	 */
	public static synchronized String generateExecutionId() {
		String bootProcess = getBootProcess();
		String date = EXECUTION_ID_DATE_FORMAT.format(new Date());
		String sequence = StringUtil.lpad(String.valueOf(executionIdSequence++), 4, '0');
		if (executionIdSequence == 10000) {
			executionIdSequence = 1;
		}
		return bootProcess + date + sequence;
	}

	/**
	 * システムプロパティ("nablarch.bootProcess")から起動プロセスを識別する文字列を取得する。
	 * @return 起動プロセスを識別する文字列。指定がない場合はブランク
	 */
	public static String getBootProcess() {
		return System.getProperty(SYSTEM_PROP_BOOT_PROCESS, "");
	}

	/**
	 * プレースホルダ($名前$形式)検索用のパターンを作成する。
	 * @param replacements 置き換え文字($名前$形式)
	 * @return プレースホルダ($名前$形式)検索用のパターン
	 */
	public static Pattern createReplacementsPattern(Set<String> replacements) {
		StringBuilder pattern = new StringBuilder();
		for (String replacement : replacements) {
			if (pattern.length() != 0) {
				pattern.append("|");
			}
			pattern.append(replacement.replace("$", "\\$"));
		}
		return Pattern.compile("(" + pattern.toString() + ")");
	}

	/**
	 * フォーマット文字列からフォーマット済みのログ出力項目を生成する。<br>
	 * 指定されたログ出力項目のキーをプレースホルダ($名前$形式)検索用のパターンに使用する。
	 * @param <T> ログ出力項目の取得に使用するコンテキストの型
	 * @param logItems ログ出力項目
	 * @param format フォーマット文字列
	 * @return フォーマット済みのログ出力項目
	 */
	public static <T> LogItem<T>[] createFormattedLogItems(Map<String, LogItem<T>> logItems, String format) {
		Pattern pattern = createReplacementsPattern(logItems.keySet());
		return createFormattedLogItems(logItems, format, pattern);
	}

	/**
	 * フォーマット文字列からフォーマット済みのログ出力項目を生成する。<br>
	 * プレースホルダでない固定文字列には、{@link FixedStringItem}を使用する。
	 * @param <T> ログ出力項目の取得に使用するコンテキストの型
	 * @param logItems ログ出力項目
	 * @param format フォーマット文字列
	 * @param pattern プレースホルダのパターン
	 * @return フォーマット済みのログ出力項目
	 */
	@SuppressWarnings("unchecked")
	public static <T> LogItem<T>[] createFormattedLogItems(Map<String, LogItem<T>> logItems, String format,
			Pattern pattern) {

		List<LogItem<T>> logItemList = new ArrayList<LogItem<T>>();

		int beginIndex = 0;
		int endIndex = -1;
		Matcher matcher = pattern.matcher(format);
		while (matcher.find()) {
			endIndex = matcher.start(1);
			if (beginIndex < endIndex) {
				logItemList.add((LogItem<T>) new FixedStringItem(format.substring(beginIndex, endIndex)));
			}
			String subSequence = matcher.group(1);
			LogItem<T> logItem = logItems.get(subSequence);
			logItemList.add(logItem != null ? logItem : (LogItem<T>) new FixedStringItem(subSequence));
			beginIndex = matcher.end(1);
		}
		endIndex = format.length();
		if (beginIndex < endIndex) {
			logItemList.add((LogItem<T>) new FixedStringItem(format.substring(beginIndex, endIndex)));
		}

		LogItem<T>[] logItemArray = new LogItem[logItemList.size()];
		logItemList.toArray(logItemArray);
		return logItemArray;
	}

	/**
	 * フォーマット済みのログ出力項目を使用してメッセージをフォーマットする。
	 * @param <T> ログ出力項目の取得に使用するコンテキストの型
	 * @param logItems フォーマット済みのログ出力項目
	 * @param context ログ出力項目の取得に使用するコンテキスト
	 * @return フォーマット済みのメッセージ
	 */
	public static <T> String formatMessage(LogItem<T>[] logItems, T context) {
		StringBuilder sb = new StringBuilder();
		for (LogItem<T> logItem : logItems) {
			sb.append(logItem.get(context));
		}
		return sb.toString();
	}

	/** デフォルトの{@link MapValueEditor} */
	private static final BasicMapValueEditor DEFAULT_MAP_VALUE_EDITOR = new BasicMapValueEditor();

	/**
	 * マップをダンプした文字列を返す。
	 * @param <T> マップの値の型
	 * @param map マップ
	 * @param separator マップエントリのセパレータ
	 * @return マップをダンプした文字列
	 */
	public static <T> String dumpMap(Map<String, T> map, String separator) {
		return dumpMap(map, separator, DEFAULT_MAP_VALUE_EDITOR, null);
	}

	/**
	 * マップをダンプした文字列を返す。
	 * @param <T> マップの値の型
	 * @param map マップ
	 * @param separator マップエントリのセパレータ
	 * @param excludeKeyPattern ダンプから除外するキーのパターン。指定しない場合はnull
	 * @return マップをダンプした文字列
	 */
	public static <T> String dumpMap(Map<String, T> map, String separator, Pattern excludeKeyPattern) {
		return dumpMap(map, separator, DEFAULT_MAP_VALUE_EDITOR, excludeKeyPattern);
	}

	/**
	 * マップをダンプした文字列を返す。
	 * @param <T> マップの値の型
	 * @param map マップ
	 * @param separator マップエントリのセパレータ
	 * @param valueEditor {@link MapValueEditor}
	 * @return マップをダンプした文字列
	 */
	public static <T> String dumpMap(Map<String, T> map, String separator, MapValueEditor valueEditor) {
		return dumpMap(map, separator, valueEditor, null);
	}

	/**
	 * マップをダンプした文字列を返す。
	 * @param <T> マップの値の型
	 * @param map マップ
	 * @param separator マップエントリのセパレータ
	 * @param valueEditor {@link MapValueEditor}
	 * @param excludeKeyPattern ダンプから除外するキーのパターン。指定しない場合はnull
	 * @return マップをダンプした文字列
	 */
	private static <T> String dumpMap(Map<String, T> map, String separator, MapValueEditor valueEditor,
			Pattern excludeKeyPattern) {
		if (map == null) {
			return "null";
		}
		if (map.isEmpty()) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		boolean appendSeparator = false;
		for (Map.Entry<String, T> param : map.entrySet()) {
			String key = param.getKey();
			if (key == null) {
				key = "null";
			}

			if (excludeKeyPattern != null && excludeKeyPattern.matcher(key).matches()) {
				continue;
			}

			if (appendSeparator) {
				sb.append(",").append(separator);
			} else {
				appendSeparator = true;
			}
			sb.append(key).append(" = [").append(valueEditor.edit(key, param.getValue())).append("]");
		}

		if (sb.length() == 0) {
			return "{}";
		}
		return "{" + (separator.contains(Logger.LS) ? separator : "") + sb.toString() + "}";
	}

	/**
	 * マップの値を編集するインタフェース。<br>
	 * マップをダンプする処理({@link LogUtil#dumpMap(Map, String, MapValueEditor)})で使用する。
	 * @author Kiyohito Itoh
	 */
	public static interface MapValueEditor {
		/**
		 * マップの値を編集する。
		 *
		 * @param key マップのキー
		 * @param value マップの値
		 * @return 編集後のマップの値
		 */
		String edit(String key, Object value);
	}

	/**
	 * マップの値を編集するインタフェースの基本実装クラス。
	 * @author Kiyohito Itoh
	 */
	public static class BasicMapValueEditor implements MapValueEditor {
		/**
		 * マップの編集処理を行う。
		 * <pre>
		 * マップの値に応じて下記の通り処理する。
		 * null："null"
		 * 配列：["要素1","要素2"･･･,"要素n"](要素毎に{@link Object#toString()})
		 * Collection型：["要素1","要素2"･･･,"要素n"](要素毎に{@link Object#toString()})
		 * 上記以外：{@link Object#toString()}
		 * </pre>
		 *
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		public String edit(String key, Object value) {
			if (value == null) {
				return getNullValue();
			} else if (value.getClass().isArray()) {
				StringBuilder sb = new StringBuilder();
				if (value instanceof Object[]) {
					Object[] values = (Object[]) value;
					for (int i = 0; i < values.length; i++) {
						if (i != 0) {
							sb.append(", ");
						}
						sb.append(editValue(key, values[i]));
					}
				} else {
					final int length = Array.getLength(value);
					for (int i = 0; i < length; i++) {
						if (i != 0) {
							sb.append(", ");
						}
						sb.append(editValue(key, Array.get(value, i)));
					}
				}
				return sb.toString();
			} else if (value instanceof Collection) {
				StringBuilder sb = new StringBuilder();
				Iterator<Object> itr = ((Collection<Object>) value).iterator();
				while (itr.hasNext()) {
					if (sb.length() != 0) {
						sb.append(", ");
					}
					sb.append(editValue(key, itr.next()));
				}
				return sb.toString();
			} else {
				return editValue(key, value);
			}
		}

		/**
		 * 値を編集する。
		 * @param key マップのキー
		 * @param value マップの値が配列又はCollection型の場合は各要素。それ以外はマップの値
		 * @return 編集後の値
		 */
		protected String editValue(String key, Object value) {
			return value != null ? StringUtil.toString(value) : getNullValue();
		}

		/**
		 * 値がnullの場合に使用する値を取得する。
		 * @return 値がnullの場合に使用する値
		 */
		protected String getNullValue() {
			return "null";
		}
	}

	/**
	 * マップの値をマスキングするクラス。
	 * @author Kiyohito Itoh
	 */
	@Published(tag = "architect")
	public static class MaskingMapValueEditor extends BasicMapValueEditor {
		/** マスク文字 */
		private final String maskingString;
		/** マスク対象のパターン */
		private final Pattern[] maskingPatterns;

		/**
		 * コンストラクタ。
		 * @param maskingChar マスク文字
		 * @param maskingPatterns マスク対象のパターン
		 */
		public MaskingMapValueEditor(char maskingChar, Pattern[] maskingPatterns) {
			this.maskingString = StringUtil.lpad("", 5, maskingChar);
			this.maskingPatterns = maskingPatterns;
		}

		/**
		 * キーがマスク対象のパターンにマッチする値のみマスキングを行う。
		 * {@inheritDoc}
		 */
		protected String editValue(String key, Object value) {
			String editedValue = super.editValue(key, value);
			return isMasking(key) ? maskingString : editedValue;
		}

		/**
		 * パラメータ名がマスキング対象かを判定する。
		 * @param name パラメータ名
		 * @return マスキング対象の場合はtrue
		 */
		protected boolean isMasking(String name) {
			for (Pattern p : maskingPatterns) {
				if (p.matcher(name).find()) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * フォーマット済みのログ出力項目に指定された出力項目が含まれているかを判定する。
	 * @param logItems フォーマット済みのログ出力項目
	 * @param classes 出力項目クラス
	 * @return 指定された出力項目が1つでも含まれている場合はtrue
	 */
	@SuppressWarnings("rawtypes")
	public static boolean contains(LogItem[] logItems, Class... classes) {
		for (LogItem logItem : logItems) {
			Class logItemClass = logItem.getClass();
			for (Class c : classes) {
				if (logItemClass == c) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * フォーマット済みのログ出力項目から指定された出力項目を検索する。
	 * @param logItems フォーマット済みのログ出力項目
	 * @param c 出力項目クラス
	 * @return 最初に見つかったログ出力項目。見つからない場合はnull
	 */
	@SuppressWarnings("rawtypes")
	public static LogItem findLogItem(LogItem[] logItems, Class c) {
		for (LogItem logItem : logItems) {
			if (logItem.getClass() == c) {
				return logItem;
			}
		}
		return null;
	}

	/**
	 * クラスローダに紐付くオブジェクトを生成するインタフェース。
	 * @author Kiyohito Itoh
	 * @param <T> クラスローダに紐付くオブジェクトの型
	 */
	public static interface ObjectCreator<T> {
		/**
		 * クラスローダに紐付くオブジェクトを生成する。
		 * @return クラスローダに紐付くオブジェクト
		 */
		T create();
	}

	/** クラスローダに紐付くマップ */
	private static Map<ClassLoader, Map<ObjectCreator<Object>, Object>> mapBoundToClassLoader = new ConcurrentHashMap<ClassLoader, Map<ObjectCreator<Object>, Object>>();

	/**
	 * クラスローダに紐付くオブジェクトを取得する。
	 * <pre>
	 * カレントスレッドから取得したコンテキストクラスローダまたはその祖先のクラスローダに紐づくオブジェクトを取得する。
	 * クラスローダに紐付くオブジェクトが存在しない場合は、{@link ObjectCreator}を使用してオブジェクトを生成し、
	 * カレントスレッドから取得したコンテキストクラスローダに紐付けて保持する。
	 * </pre>
	 * @param <T> クラスローダに紐付くオブジェクトの型
	 * @param creator クラスローダに紐付くオブジェクトを生成する{@link ObjectCreator}
	 * @return クラスローダに紐付くオブジェクト
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObjectBoundToClassLoader(ObjectCreator<T> creator) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Map<ObjectCreator<Object>, Object> map = getMapBoundToClassLoader(classLoader);
		if (map != null && map.containsKey(creator)) {
			return (T) map.get(creator);
		}
		synchronized (mapBoundToClassLoader) {
			map = getMapBoundToClassLoader(classLoader);
			if (map != null && map.containsKey(creator)) {
				return (T) map.get(creator);
			}
			if (map == null) {
				map = new HashMap<LogUtil.ObjectCreator<Object>, Object>();
				mapBoundToClassLoader.put(classLoader, map);
			}
			T object = creator.create();
			map.put((ObjectCreator<Object>) creator, object);
			return object;
		}
	}

	/**
	 * コンテキストクラスローダに紐付くオブジェクトを削除する。
	 * @param <T> クラスローダに紐付くオブジェクトの型
	 * @param creator クラスローダに紐付くオブジェクトを生成した{@link ObjectCreator}
	 * @return 削除したオブジェクト。コンテキストクラスローダに紐付くオブジェクトが存在しない場合はnull
	 */
	@SuppressWarnings("unchecked")
	public static <T> T removeObjectBoundToContextClassLoader(ObjectCreator<T> creator) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		synchronized (mapBoundToClassLoader) {
			Map<ObjectCreator<Object>, Object> map = mapBoundToClassLoader.get(classLoader);
			Object object = map != null ? map.get((ObjectCreator<Object>) creator) : null;
			return object != null ? (T) object : null;
		}
	}

	/**
	 * コンテキストクラスローダに紐付く全てのオブジェクトを削除する。
	 */
	public static void removeAllObjectsBoundToContextClassLoader() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		synchronized (mapBoundToClassLoader) {
			mapBoundToClassLoader.remove(classLoader);
		}
	}

	/**
	 * 引数で渡されたクラスローダまたはその祖先のクラスローダに紐づくマップを取得する。
	 * @param classLoader クラスローダ
	 * @return クラスローダに紐付くマップ
	 */
	private static Map<ObjectCreator<Object>, Object> getMapBoundToClassLoader(ClassLoader classLoader) {
		Map<ObjectCreator<Object>, Object> map = mapBoundToClassLoader.get(classLoader);
		if (map != null) {
			return map;
		}
		ClassLoader parent = classLoader.getParent();
		return (parent == null)
				? null // has no parent.
				: getMapBoundToClassLoader(parent);
	}
}
