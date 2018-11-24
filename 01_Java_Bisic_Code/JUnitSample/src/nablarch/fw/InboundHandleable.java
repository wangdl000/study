package nablarch.fw;

/**
 * 前処理実行可能なハンドラであるマーカインタフェース。
 *
 * @author Koichi Asano
 */
public interface InboundHandleable {

	/**
	 * 前処理を実装する。
	 * @param context ExecutionContext
	 * @return 処理結果オブジェクト
	 */
	Result handleInbound(ExecutionContext context);

}
