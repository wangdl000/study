package nablarch.fw;

/**
 * 後処理実行可能なハンドラであるマーカインタフェース。
 *
 * @author Koichi Asano
 */
public interface OutboundHandleable {

	/**
	 * 後処理を実装する。
	 * @param context ExecutionContext
	 * @return 処理結果オブジェクト
	 */
	Result handleOutbound(ExecutionContext context);
}
