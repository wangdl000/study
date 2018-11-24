package nablarch.core.util.map;

import nablarch.core.util.StringUtil;
import nablarch.core.util.annotation.Published;

import java.util.HashMap;
import java.util.Map;

/**
 * キーの大文字と小文字、アンダースコア(_)の有無を区別しないマップの実装クラス。
 * <p/>
 * 以下のメソッドは、キーの大文字と小文字、アンダースコアの有無を区別しない。
 * <ul>
 * <li>{@link #get(Object)} </li>
 * <li>{@link #containsKey(Object)} </li>
 * <li>{@link #put(String, Object)} </li>
 * <li>{@link #putAll(java.util.Map)} </LI>
 * </ul>
 * 同一キーとみなす例
 * <ul>
 * <li>大文字小文字の区別はしない。(USER_NAMEとuser_nameは同一キーとみなす)</li>
 * <li>アンダースコアの有無は区別しない。(USER_NAMEとuserNameは同一キーとみなす)</li>
 * </ul>
 * @author Kiyohito Itoh
 * @param <V> 値の型
 */
public class MultipleKeyCaseMap<V> extends MapWrapper<String, V> {

	/** 実データマップ */
	private Map<String, V> actualDataMap;

	/**
	 * キー変換情報マップ。
	 * <p/>
	 * <pre>
	 * キー変換情報マップのkeyとvalueは下記のとおり。
	 * 
	 *     key: 実データマップキーの大文字を小文字にし、アンダースコアを削除した値
	 *     value: 実データマップキー
	 * </pre>
	 */
	private final Map<String, String> keyConversionMap;

	/**
	 * {@link MultipleKeyCaseMap}のインスタンスを生成する。
	 */
	@Published(tag = "architect")
	public MultipleKeyCaseMap() {
		this.actualDataMap = new HashMap<String, V>();
		this.keyConversionMap = new HashMap<String, String>();
	}

	/**
	 * {@code map}を元に、{@link MultipleKeyCaseMap}のインスタンスを生成する。
	 * <p/>
	 * 呼び出し側でキー変換情報をキャッシュ可能な場合は、
	 * 性能劣化を防ぐために{@link MultipleKeyCaseMap#MultipleKeyCaseMap(Map, Map)}を使用すること。
	 *
	 * @param map マップ
	 */
	@Published(tag = "architect")
	public MultipleKeyCaseMap(Map<String, V> map) {
		this.actualDataMap = map;
		this.keyConversionMap = new HashMap<String, String>();
		addKeyConversions(map); // 指定されたマップによりキー変換情報の初期化を行う。
	}

	/**
	 * {@code map}とキー変換情報を元に{@link MultipleKeyCaseMap}のインスタンスを生成する。
	 * <p/>
	 * <pre>
	 * 呼び出し側でキー変換情報をキャッシュしている場合にこのコンストラクタを使用する。
	 * キー変換情報マップのkeyとvalueは下記のとおり。
	 *
	 *     key: 実データマップキーの大文字を小文字にし、アンダースコアを削除した値
	 *     value: 実データマップキー
	 *
	 * キー変換情報マップを作成する際は、
	 * {@link StringUtil#lowerAndTrimUnderScore(String)}メソッドを使用してkeyの値を取得すること。
	 * 
	 * 本コンストラクタを呼び出す場合は、引数のマップとキー変換情報の整合性が取れている必要がある。
	 * </pre>
	 * @param map マップ
	 * @param keyNames キー変換情報
	 */
	public MultipleKeyCaseMap(Map<String, V> map, Map<String, String> keyNames) {
		this.actualDataMap = map;
		// 指定されたキー変換情報で本オブジェクト内のキー変換情報を初期化する。
		// 指定されたマップによるキー変換情報の初期化は行わない。
		this.keyConversionMap = keyNames;
	}

	/**
	 * コピーコンストラクタ。
	 * @param orig コピー元となるMap
	 */
	public MultipleKeyCaseMap(MultipleKeyCaseMap<V> orig) {
		this(copyValueOf(orig.actualDataMap),
				copyValueOf(orig.keyConversionMap));
	}

	/**
	 * 引数で与えられたMapをコピーする。
	 *
	 * @param original コピー元のMap
	 * @param <KEY> キーの型
	 * @param <VAL> 値の型
	 * @return コピーされたMap
	 */
	protected static <KEY, VAL> Map<KEY, VAL> copyValueOf(Map<KEY, VAL> original) {
		return new HashMap<KEY, VAL>(original);
	}

	/** {@inheritDoc} */
	@Override
	public Map<String, V> getDelegateMap() {
		return actualDataMap;
	}

	/** {@inheritDoc} */
	@Override
	@Published
	public V put(String key, V value) {
		addKeyConversion(key);
		return super.put(key, value);
	}

	/** {@inheritDoc} */
	@Override
	@Published
	public void putAll(Map<? extends String, ? extends V> m) {
		addKeyConversions(m);
		super.putAll(m);
	}

	/**
	 * キー名の存在チェック。
	 * <p/>
	 * 指定されるキー名は、大文字小文字は区別しない。
	 * また、アンダースコア(_)を含むキー名の場合には、アンダースコアを除去したキー名を指定してもよい。
	 *
	 * @param key キー名
	 * @return 存在している場合は、true
	 */
	@Override
	@Published
	public boolean containsKey(Object key) {
		return super.containsKey(getActualDataKey((String) key));
	}

	/**
	 * 指定されたキー名に対応する値を返却する。
	 * <p/>
	 * 指定されるキー名は、大文字小文字は区別しない。
	 * また、アンダースコア(_)を含むキー名の場合には、アンダースコアを除去したキー名を指定してもよい。
	 *
	 * @param key キー名
	 * @return 指定されたキー名に対応する値(キー名が存在しない場合は、{@code null}を返却する。)
	 */
	@Override
	@Published
	public V get(Object key) {
		return super.get(getActualDataKey((String) key));
	}

	/**
	 * 指定されたマップの全てのキー名に対するキー変換情報をキー変換情報マップに追加する。
	 * <p/>
	 * 指定されたマップのキー名を取り出し、{@link #addKeyConversion(String)}メソッドを呼び出す。
	 * @param map マップ
	 */
	private void addKeyConversions(Map<? extends String, ? extends V> map) {
		for (String key : map.keySet()) {
			addKeyConversion(key);
		}
	}

	/**
	 * 指定されたキー名に対するキー変換情報をキー変換情報マップに追加する。
	 * <pre>
	 * キー変換情報マップに追加される内容は下記のとおり。
	 * 
	 *     key: 指定されたキー名を指定して{@link StringUtil#lowerAndTrimUnderScore(String)}メソッドを呼び出した結果
	 *     value: 指定されたキー名
	 * 
	 * </pre>
	 * @param key キー名
	 */
	protected void addKeyConversion(String key) {
		keyConversionMap.put(StringUtil.lowerAndTrimUnderScore(key), key);
	}

	/**
	 * 指定されたキー名に対応する実データマップのキー名を取得する。
	 * <pre>
	 * 性能劣化を防止するために、一度指定されたキー名はキャッシュする(=キー変換情報マップに追加する)。
	 * これにより、次回同一キーが指定された場合にキャッシュから実データマップのキー名が取得できる。
	 * 
	 * このキャッシュにより、本オブジェクトが保持するキー変換情報マップは、
	 * {@link StringUtil#lowerAndTrimUnderScore(String)}が返す値だけでなく、
	 * このメソッドで指定されたキー名と実データマップのキー名のペアも含まれる。
	 * </pre>
	 * @param key キー名
	 * @return 実データマップのキー名。存在しない場合はnull
	 */
	protected String getActualDataKey(String key) {

		// キャッシュに対する取得を試みる。
		String actualDataKey = keyConversionMap.get(key);

		if (actualDataKey == null) { // キャッシュにヒットしなかった場合
			actualDataKey = keyConversionMap.get(StringUtil.lowerAndTrimUnderScore(key));
			if (actualDataKey == null) {
				// 本Mapに存在しない値の場合のみこのロジックに到達する。
				return key;
			}
			// 性能劣化を防止するために、一度指定されたキー名はキャッシュする。
			keyConversionMap.put(key, actualDataKey);
		}
		return actualDataKey;
	}

}
