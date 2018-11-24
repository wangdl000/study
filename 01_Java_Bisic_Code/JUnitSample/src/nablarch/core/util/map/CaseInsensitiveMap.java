package nablarch.core.util.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import nablarch.core.util.annotation.Published;

/**
 * キー文字列の大文字・小文字を同一視する{@link Map}。
 * <p/>
 * 各APIのキーは{@link String#toLowerCase()}で暗黙的に変換される。
 *
 * @param <V> 値の型
 * @author Iwauo Tajima
 */
public class CaseInsensitiveMap<V> extends MapWrapper<String, V> {

	/**
	 * 本クラスのインスタンスを作成する。
	 * <p/>
	 * 作成するインスタンスは、{@link ConcurrentHashMap}のラップしているため、
	 * スレッドセーフであることが保証される反面、キーに{@code null}を設定できない点に注意すること。
	 */
	@Published
	public CaseInsensitiveMap() {
		this(new ConcurrentHashMap<String, V>());
	}

	/**
	 * 指定されたMapをラップした、本クラスのインスタンスを作成する。
	 *
	 * @param baseMap 元となるMap。キーは小文字でなければならない。
	 * @throws IllegalArgumentException 元となるMapが{@code null}の場合
	 */
	@Published
	public CaseInsensitiveMap(Map<String, V> baseMap) {
		if (baseMap == null) {
			throw new IllegalArgumentException("baseMap must not be null.");
		}
		this.baseMap = baseMap;
	}

	/** 元となるMap */
	private final Map<String, V> baseMap;

	/** {@inheritDoc} */
	public Map<String, V> getDelegateMap() {
		return baseMap;
	}

	/**
	 * 大文字・小文字の違いが正規化されたキー文字列を返す。
	 * @param key キー文字列
	 * @return 正規化されたキー名
	 */
	private String getNormalizedKey(Object key) {
		return (key == null) ? null
				: key.toString().toLowerCase();
	}

	/** {@inheritDoc} */
	@Published
	public boolean containsKey(Object key) {
		return getDelegateMap().containsKey(getNormalizedKey(key));
	}

	/** {@inheritDoc} */
	@Published
	public V get(Object key) {
		return getDelegateMap().get(getNormalizedKey(key));
	}

	/** {@inheritDoc} */
	@Published
	public V put(String key, V value) {
		return getDelegateMap().put(getNormalizedKey(key), value);
	}

	/** {@inheritDoc} */
	@Published
	public void putAll(Map<? extends String, ? extends V> m) {
		for (Map.Entry<? extends String, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	/** {@inheritDoc} */
	@Published
	public V remove(Object key) {
		return getDelegateMap().remove(getNormalizedKey(key));
	}
}
