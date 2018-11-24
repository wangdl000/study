package nablarch.fw;

import java.util.List;

/**
 * トランザクション(コミット or ロールバック)毎に
 * 呼び出されるコールバックメソッドを定義するインタフェース。
 * <p/>
 *
 * @param <TData>ハンドラへの入力データ
 * @author hisaaki sioiri
 */
public interface TransactionEventCallback<TData> {

	/** リクエストデータを示すキー */
	String REQUEST_DATA_REQUEST_SCOPE_KEY = ExecutionContext.FW_PREFIX
			+ "request-data";

	/**
	 * 入力データに対する処理が正常に処理された場合に呼ばれる。
	 *
	 * @param data 入力データ
	 * @param ctx 実行コンテキスト
	 */
	void transactionNormalEnd(TData data, ExecutionContext ctx);

	/**
	 * 入力データに対する処理で異常が発生した場合に呼ばれる。
	 *
	 * @param e    発生したエラー
	 * @param data 入力データ
	 * @param ctx 実行コンテキスト
	 */
	void transactionAbnormalEnd(Throwable e, TData data, ExecutionContext ctx);

	/**
	 * トランザクションイベントの発行を行うハンドラが継承するサポートクラス。
	 * 
	 * @param <TData> ハンドラの入力データの型
	 */
	public abstract static class Provider<TData> {
		/**
		 * ハンドラキューの内容を走査し、
		 * {@link TransactionEventCallback}を実装した後続ハンドラを返す。
		 * 
		 * @param data 本ハンドラに対する入力オブジェクト
		 * @param ctx  実行コンテキスト
		 * @return     {@link TransactionEventCallback}を実装した後続ハンドラ
		 */
		@SuppressWarnings("rawtypes")
		protected List<TransactionEventCallback> prepareListeners(TData data, ExecutionContext ctx) {
			return ctx.selectHandlers(
					data,
					TransactionEventCallback.class,
					TransactionEventCallback.Provider.class);
		}

		/**
		 * 各リスナに対してトランザクション正常コミット時のコールバックメソッドを
		 * 呼び出す。
		 * 
		 * @param listeners {@link TransactionEventCallback}を実装した後続ハンドラ
		 * @param data      本ハンドラに対する入力オブジェクト
		 * @param ctx       実行コンテキスト
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		protected void callNormalEndHandlers(List<TransactionEventCallback> listeners,
				TData data,
				ExecutionContext ctx) {
			for (TransactionEventCallback listener : listeners) {
				listener.transactionNormalEnd(data, ctx);
			}
		}

		/**
		 * 各リスナに対してトランザクションロールバック時のコールバックメソッドを
		 * 呼び出す。
		 * 
		 * @param listeners {@link TransactionEventCallback}を実装した後続ハンドラ
		 * @param e         後続ハンドラから送出され、ロールバックの直接起因となった例外オブジェクト
		 * @param data      本ハンドラに対する入力オブジェクト
		 * @param ctx       実行コンテキスト
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		protected void callAbnormalEndHandlers(List<TransactionEventCallback> listeners,
				Throwable e,
				TData data,
				ExecutionContext ctx) {
			for (TransactionEventCallback listener : listeners) {
				listener.transactionAbnormalEnd(e, data, ctx);
			}
		}
	}
}
