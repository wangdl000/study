package nablarch.fw;

import nablarch.core.util.annotation.Published;

/**
 * データリーダのファクトリクラスが実装するインスタンス。
 *
 * @param <TData> データリーダが読み込むデータの型
 *
 * @author Iwauo Tajima
 */
@Published(tag = "architect")
public interface DataReaderFactory<TData> {
	/**
	 * 新たなデータリーダを作成する。
	 * 
	 * @param context 実行コンテキスト
	 * @return データリーダ
	 */
	DataReader<TData> createReader(ExecutionContext context);
}
