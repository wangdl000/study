package nablarch.core.cache;

import nablarch.core.repository.initialization.Initializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * StaticDataCacheインタフェースの基本実装クラス。<br/>
 * 静的データをHashMapに保持する。
 * 
 * @author Koichi Asano
 *
 * @param <T> 静的データの型
 */
public class BasicStaticDataCache<T> implements StaticDataCache<T>, Initializable {
	/**
	 * 初期化時ロード要否。
	 */
	private boolean loadOnStartup;

	/**
	 * 静的データのローダ。
	 */
	private StaticDataLoader<T> loader;

	/**
	 * 静的データのキャッシュ。
	 */
	private Map<Object, T> cache;

	/**
	 * 静的データのインデックス。
	 */
	private Map<String, Map<Object, List<T>>> indexes;

	/**
	 * 静的データのローダを設定する。
	 * @param loader 静的データのローダ
	 */
	public void setLoader(StaticDataLoader<T> loader) {
		this.loader = loader;
	}

	/**
	 * 初期化時ロード要否を設定する。
	 * @param loadOnStartup 初期化時ロード要否
	 */
	public void setLoadOnStartup(boolean loadOnStartup) {
		this.loadOnStartup = loadOnStartup;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void initialize() {
		refresh();
	}

	/**
	 * {@inheritDoc}<br/>
	 * 
	 * 一括ロードを実行する際は、データを全てロードしてからキャッシュデータの上書きを
	 * 行うことで、切り替えによるデータ取得をブロッキングする時間を最小化している。
	 */
	public void refresh() {

		if (!loadOnStartup) {
			synchronized (this) {
				cache = new ConcurrentHashMap<Object, T>();
				indexes = new ConcurrentHashMap<String, Map<Object, List<T>>>();
			}
		} else {
			Map<Object, T> tmpCache = new HashMap<Object, T>();
			Map<String, Map<Object, List<T>>> tmpIndexes = new HashMap<String, Map<Object, List<T>>>();
			List<String> indexNames = loader.getIndexNames();

			// インデックスのいれものを作成
			if (indexNames != null) {
				for (String name : indexNames) {
					tmpIndexes.put(name, new HashMap<Object, List<T>>());
				}
			}

			// データをロード
			List<T> loadedValues = loader.loadAll();
			if (loadedValues != null) {
				for (T value : loadedValues) {

					Object id = loader.getId(value);
					tmpCache.put(id, value);

					if (indexNames != null) {
						for (String indexName : indexNames) {
							Object key = loader.generateIndexKey(indexName, value);
							Map<Object, List<T>> index = tmpIndexes.get(indexName);
							List<T> results = index.get(key);
							if (results == null) {
								results = new ArrayList<T>();
								index.put(key, results);
							}
							results.add(value);
						}
					}
				}
			}

			// 全てロードしてから最小時間で切り替え
			synchronized (this) {
				cache = new ConcurrentHashMap<Object, T>(tmpCache);
				indexes = new ConcurrentHashMap<String, Map<Object, List<T>>>(tmpIndexes);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public T getValue(Object id) {
		T value = cache.get(id);
		if (value != null) {
			// ロードされているデータは同期せずに返却
			return value;
		}

		// ロードされていないデータのみ同期してロード
		value = loadValue(id);
		return value;
	}

	/**
	 * 静的データのローダからIDに紐付くデータをロードする。
	 * @param id ロードするデータのID
	 * @return ロードしたデータ
	 */
	private synchronized T loadValue(Object id) {
		T value;
		value = cache.get(id);
		if (value != null) {
			return value;
		}
		value = loader.getValue(id);
		if (value != null) {
			cache.put(id, value);
		}
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getValues(String indexName, Object key) {
		Map<Object, List<T>> index = indexes.get(indexName);

		if (index == null) {
			index = addIndex(indexName);
		}

		List<T> result = index.get(key);
		if (result != null) {
			// ロードされているインデックスは同期せずに返却
			return result;
		}

		// まだロードされていない場合のみ同期してロード
		result = loadIndexValues(indexName, key, index);

		if (result != null) {
			return Collections.unmodifiableList(result);
		} else {
			return null;
		}
	}

	/**
	 * インデックスに紐付くデータのリストをロードする。
	 * 
	 * @param indexName インデックス名
	 * @param key キー
	 * @param index インデックス
	 * @return ロードしたデータのリスト
	 */
	private synchronized List<T> loadIndexValues(String indexName, Object key,
			Map<Object, List<T>> index) {

		if (index.containsKey(key)) {
			// 究極的なタイミングでこの処理に同時に入った場合、ロード処理を行わない
			return index.get(key);
		}

		List<T> loaded = loader.getValues(indexName, key);

		if (loaded == null) {
			return null;
		}
		// 同一オブジェクトをロードする無駄を排除するために、既存データに同一のものがないか検索
		List<T> result = new ArrayList<T>();
		for (T newValue : loaded) {
			Object id = loader.getId(newValue);

			T oldValue = cache.get(id);
			if (oldValue != null) {
				// 既にキャッシュされているオブジェクトがあれば、そちらを使用
				result.add(oldValue);
			} else {
				// キャッシュされているオブジェクトがなければ、新しいデータを使用
				result.add(newValue);
				cache.put(id, newValue);
			}
		}

		index.put(key, result);
		return result;
	}

	/**
	 * インデックスを追加する。
	 * 
	 * @param indexName インデックス名
	 * @return 追加したインデックスのMap
	 */
	private Map<Object, List<T>> addIndex(String indexName) {
		Map<Object, List<T>> index;
		synchronized (this) {
			index = indexes.get(indexName);
			if (index == null) {
				index = new HashMap<Object, List<T>>();
				indexes.put(indexName, index);
			}
		}
		return index;
	}

}
