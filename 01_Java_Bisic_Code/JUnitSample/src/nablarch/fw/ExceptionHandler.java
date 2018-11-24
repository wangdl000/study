package nablarch.fw;

/**
 * エラー処理用のハンドラ。
 *
 * @author Koichi Asano
 */
public interface ExceptionHandler {

	/**
	 * Error の例外処理を行う。<br/>
	 * 例外をNablarchのハンドラでレスポンスとして処理する場合、
	 * このハンドラより外部のハンドラが処理できるレスポンスオブジェクトを返す。
	 * 
	 * @param e 処理するError
	 * @param context ExecutionContext
	 * @return 例外を表すレスポンスオブジェクト
	 * @throws Error 例外を処理できない場合
	 * @throws RuntimeException 例外を処理できない場合、または付け替えた例外
	 */
	Result handleError(Error e, ExecutionContext context) throws Error, RuntimeException;

	/**
	 * RuntimeExceptionの例外処理を行う。<br/>
	 * 例外をNablarchのハンドラでレスポンスとして処理する場合、
	 * このハンドラより外部のハンドラが処理できるレスポンスオブジェクトを返す。
	 * 
	 * @param e 処理する例外
	 * @param context ExecutionContext
	 * @return 例外を表すレスポンスオブジェクト
	 * @throws RuntimeException 例外を処理できない場合、または付け替えた例外
	 */
	Result handleRuntimeException(RuntimeException e, ExecutionContext context) throws RuntimeException;
}
