package nablarch.core.cache;

import java.util.List;

import nablarch.core.util.annotation.Published;

/**
 * 静的データをロードするインタフェース。
 * <p/>
 * RDBMSやXMLファイル等の媒体から静的データをロードするクラスは、このインタフェースを実装する。
 * 
 * @author Koichi Asano
 *
 * @param <T> ロードするデータの型
 */
@Published(tag = "architect")
public interface StaticDataLoader<T> {

	/**
	 * IDに紐付くデータをロードする。
	 * 
	 * @param id データのID
	 * @return IDに紐付くデータ
	 */
	T getValue(Object id);

	/**
	 * インデックスに紐付くデータをロードする。
	
	 * @param indexName インデックス名
	 * @param key 静的データのキー
	 * @return インデックス名、キーに対応するデータのリスト
	 */
	List<T> getValues(String indexName, Object key);

	/**
	 * 全てのデータをロードする。
	 * 
	 * @return 全てのデータ
	 */
	List<T> loadAll();

	/**
	 * 全てのインデックス名を取得する。
	 * 
	 * @return 全てのインデックス名
	 */
	List<String> getIndexNames();

	/**
	 * 静的データからIDを取得する。
	 * 
	 * @param value 静的データ
	 * @return 生成したID
	 */
	Object getId(T value);

	/**
	 * 静的データからインデックスのキーを生成する。
	 * 
	 * @param indexName インデックス名
	 * @param value 静的データ
	 * @return 生成したインデックスのキー
	 */
	Object generateIndexKey(String indexName, T value);
}
