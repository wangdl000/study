package nablarch.fw;

/**
 * 任意のオブジェクトに対して、メソッドレベルのディスパッチを行う
 * ハンドラを作成するインターフェース。
 *
 * @param <TData>   ハンドラの入力データの型
 * @param <TResult>
 * 
 * @author Iwauo Tajima
 */
public interface MethodBinder<TData, TResult> {
	/**
	 * 指定したオブジェクトに対してメソッドレベルのディスパッチを行う
	 * ハンドラを作成して返す。
	 * @param delegate ディスパッチ対象のオブジェクト
	 * @return ハンドラ
	 */
	HandlerWrapper<TData, TResult> bind(Object delegate);
}
