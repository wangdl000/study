package nablarch.core.cache;

import java.util.List;

import nablarch.core.util.annotation.Published;

/**
 * 静的データキャッシュを保持するインタフェース。<br/>
 * 静的データはIDを使った取得と、インデックスを使った取得の2種類の方法で取得できる。<br/>
 * インデックスを使った取得方法とは、静的データを一定のルールでまとめた集合をまとめて
 * 取得する方法である。このまとまった集合にはそれぞれインデックスキーと呼ばれるキーが付け
 * られており、本インタフェースではこのインデックスキーを指定して静的データの集合が取得できる。
 * なお、静的データを集合にまとめるルールは複数指定することができ、このルールにはインデックス名
 * と呼ばれる名称が付けられる。
 * 
 * 
 * @author Koichi Asano
 *
 * @param <T> 静的データの型
 */
@Published(tag = "architect")
public interface StaticDataCache<T> {

	/**
	 * IDを指定して静的データを取得する。
	 * 
	 * @param id データのID
	 * @return IDに対応する静的データ
	 */
	T getValue(Object id);

	/**
	 * 条件に合致した静的データのリストを取得する。<br/>
	 * 条件は事前にインデックスとして辞書に登録する必要があり、
	 * このメソッドではそのインデックス名を指定して静的データを取得する。
	 * 
	 * @param indexName インデックス名
	 * @param key 静的データのインデックスキー
	 * @return インデックス名、インデックスキーに対応するデータのリスト
	 */
	List<T> getValues(String indexName, Object key);

	/**
	 * 静的データの再読み込みを行う。
	 */
	void refresh();
}
