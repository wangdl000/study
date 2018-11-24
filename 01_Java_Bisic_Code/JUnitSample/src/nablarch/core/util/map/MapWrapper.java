package nablarch.core.util.map;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import nablarch.core.util.annotation.Published;

/**
 * {@link Map}を実装するクラスの、ラッパークラスを作成するための抽象クラス。
 * <p/>
 * サブクラスで{@link #getDelegateMap()}を実装することで、任意のMapに処理を委譲できる。
 *
 * @param <K> キーの型
 * @param <V> 値の型
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
public abstract class MapWrapper<K, V> extends AbstractMap<K, V> {
	/**
	 * このラッパーが処理を委譲する{@link Map}オブジェクトを返す。
	 * @return 処理を委譲するMapオブジェクト
	 */
	public abstract Map<K, V> getDelegateMap();

	/**
	 * このインスタンスが処理を委譲しているMapのうち、
	 * 指定した型のものを返す。
	 * @param <T> 取得したいMapの型
	 * @param mapType 取得したいMapの型
	 * @return 指定した型に適合するMapインスタンス
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getDelegateMapOfType(Class<T> mapType) {
		if (mapType.isInstance(this)) {
			return (T) this;
		}
		Map<K, V> instance = this;
		while (instance instanceof MapWrapper<?, ?>) {
			instance = ((MapWrapper) instance).getDelegateMap();
			if (mapType.isInstance(instance)) {
				return (T) instance;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public void clear() {
		getDelegateMap().clear();
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public boolean containsKey(Object key) {
		return getDelegateMap().containsKey(key);
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public boolean containsValue(Object value) {
		return getDelegateMap().containsValue(value);
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return getDelegateMap().entrySet();
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public V get(Object key) {
		return getDelegateMap().get(key);
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public boolean isEmpty() {
		return getDelegateMap().isEmpty();
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public Set<K> keySet() {
		return getDelegateMap().keySet();
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public V put(K key, V value) {
		return getDelegateMap().put(key, value);
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public void putAll(Map<? extends K, ? extends V> m) {
		getDelegateMap().putAll(m);
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public V remove(Object key) {
		return getDelegateMap().remove(key);
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public int size() {
		return getDelegateMap().size();
	}

	/**
	 * {@inheritDoc}
	 * <p/>
	 * {@link #getDelegateMap()}が返す{@link Map}オブジェクトに処理を委譲する。
	 */
	@Published
	public Collection<V> values() {
		return getDelegateMap().values();
	}

	@Override
	public boolean equals(Object o) {
		return getDelegateMap().equals(o);
	}

	@Override
	public int hashCode() {
		return getDelegateMap().hashCode();
	}

	@Override
	public String toString() {
		return getDelegateMap().toString();
	}
}
