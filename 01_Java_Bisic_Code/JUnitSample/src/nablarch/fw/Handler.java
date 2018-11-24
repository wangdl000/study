package nablarch.fw;

import nablarch.core.util.annotation.Published;

/**
 * データプロセッサが実装するパイプライン処理において、
 * 各ステージで行われる処理が実装するインターフェース。
 * 
 * @param <TData>    処理対象データ型
 * @param <TResult>  処理結果データ型
 * 
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
@Published(tag = "architect")
public interface Handler<TData, TResult> {
	/**
	 * 入力データに対する処理を実行する。
	 * 
	 * @param data    入力データ
	 * @param context 実行コンテキスト
	 * @return 処理結果データ
	 */
	TResult handle(TData data, ExecutionContext context);
}
