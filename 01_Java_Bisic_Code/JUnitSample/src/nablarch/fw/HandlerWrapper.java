package nablarch.fw;

import java.util.List;

/**
 * {@link Handler}インターフェースを実装していない
 * 一般のオブジェクトに対するラッパー。
 * 
 * @param <TData>   ハンドラの入力データ型
 * @param <TResult> ハンドラの処理結果型
 * 
 * @author Iwauo Tajima
 */
public interface HandlerWrapper<TData, TResult> extends Handler<TData, TResult> {
	/**
	 * このラッパーが処理を移譲するオブジェクトのリストを返す。
	 * 対象となるオブジェクトが存在しない場合は空の配列を返す。
	 * @param  data    ハンドラに対する入力データ
	 * @param  context 実行コンテキスト
	 * @return 内包するオブジェクト。
	 */
	List<Object> getDelegates(TData data, ExecutionContext context);
}
