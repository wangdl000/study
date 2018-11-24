package nablarch.core.util.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUアルゴリズムを持つ{@link Map}実装クラス。
 * 指定された最大容量を超過する場合、
 * 最も参照されない期間が長いエントリが削除される。
 *
 * @param <K> キーの型
 * @param <V> 値の型
 * @author T.Kawasaki
 * @see java.util.HashMap
 * @see LinkedHashMap
 */
public class LRUMap<K, V> extends LinkedHashMap<K, V> {

	/**
	 * 初期容量
	 *
	 * @see java.util.HashMap#HashMap()
	 * @see java.util.HashMap#DEFAULT_INITIAL_CAPACITY
	 */
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	/**
	 * @see java.util.HashMap#HashMap()
	 * @see java.util.HashMap#DEFAULT_LOAD_FACTOR
	 */
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/** このMapの最大容量 */
	private final int maxSize;

	/**
	 * 最も参照されていない要素が削除される場合に
	 * コールバックされるリスナー。
	 */
	private final RemoveListener<K, V> listener;

	/**
	 * コンストラクタ。
	 * 初期容量＜最大サイズの場合、最大サイズが初期容量となる。
	 *
	 * @param initialCapacity 初期容量
	 * @param loadFactor      負荷係数
	 * @param maxSize         最大サイズ
	 * @param listener        リスナー
	 */
	public LRUMap(int initialCapacity,
			float loadFactor,
			int maxSize,
			RemoveListener<K, V> listener) {
		// LRUを実現するため、accessOrderはtrueにする。
		super(Math.min(initialCapacity, maxSize), loadFactor, true);
		if (maxSize <= 0) {
			throw new IllegalArgumentException(
					"argument maxSize must not be less than zero."
							+ " but was [" + maxSize + "]");
		}
		this.maxSize = maxSize;
		this.listener = listener;
	}

	/**
	 * コンストラクタ。
	 *
	 * @param initialCapacity 初期容量
	 * @param loadFactor      負荷係数
	 * @param maxSize         最大サイズ
	 */
	public LRUMap(int initialCapacity,
			float loadFactor,
			int maxSize) {
		this(initialCapacity, loadFactor, maxSize, new RemoveListener.NopListener<K, V>());
	}

	/**
	 * コンストラクタ。
	 *
	 * @param initialCapacity 初期容量
	 * @param maxSize         最大サイズ
	 */
	public LRUMap(int initialCapacity, int maxSize) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR, maxSize);
	}

	/**
	 * コンストラクタ。
	 *
	 * @param maxSize  最大サイズ
	 * @param listener リスナー
	 */
	public LRUMap(int maxSize, RemoveListener<K, V> listener) {
		this(DEFAULT_INITIAL_CAPACITY,
				DEFAULT_LOAD_FACTOR,
				maxSize,
				listener);
	}

	/**
	 * コンストラクタ。
	 *
	 * @param maxSize 最大サイズ
	 */
	public LRUMap(int maxSize) {
		this(DEFAULT_INITIAL_CAPACITY, maxSize);
	}

	/**
	 * {@inheritDoc}
	 * 現在のサイズが最大サイズより大きい場合、真を返却する。
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		boolean removed = size() > maxSize;
		if (removed) {
			listener.onRemoveEldest(eldest.getKey(), eldest.getValue());
		}
		return removed;
	}

	/**
	 * LRUアルゴリズムにより、エントリが削除された場合に呼び出されるコールバックインタフェース。
	 *
	 * @param <K> キーの型
	 * @param <V> 値の型
	 */
	public interface RemoveListener<K, V> {

		/**
		 * LRUアルゴリズムにより、エントリが削除された場合に呼び出されるコールバックメソッド。
		 *
		 * @param key   削除されたエントリーのキー
		 * @param value 削除されたエントリーの値
		 */
		void onRemoveEldest(K key, V value);

		/**
		 * 何も実行しないリスナー実装クラス。
		 *
		 * @param <K> キーの型
		 * @param <V> 値の型
		 */
		static class NopListener<K, V> implements RemoveListener<K, V> {

			/** {@inheritDoc} */
			@Override
			public void onRemoveEldest(K key, V value) {
			}
		}
	}

}
