package nablarch.fw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nablarch.core.util.Builder;

/**
 * 各リクエストのリクエストパスの内容に応じ、内部に保持するハンドラに
 * 処理を委譲するかどうかを判断するハンドラ。
 * <p/>
 * このハンドラでは、その内部にあるハンドラに対する参照を保持し、
 * 各リクエストに対し、そのハンドラを実行する条件をリクエストパスのパターンで指定する。
 * <p/>
 * URIとリクエストパスのパターンの照合処理はRequestPathMappingHelperに委譲する。
 * 
 * @param <TRequest> リクエストデータの型
 * @param <TResult>処理結果のデータ型
 * 
 * @see Request#getRequestPath()
 * @see RequestPathMatchingHelper
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
public class RequestHandlerEntry<TRequest extends Request<?>, TResult>
		implements HandlerWrapper<TRequest, TResult> {

	/**{@inheritDoc}
	 * この実装では、まずリクエストに対してこのエントリが保持する
	 * ハンドラを実行する必要があるかどうかを{@link #isAppliedTo(Request, ExecutionContext)}
	 * により決定する。
	 * 必要があればこのエントリ内のハンドラを実行しその結果を返す。
	 * 必要がなければこのエントリ内のハンドラは実行せずに、
	 * ハンドラキュー上の後続ハンドラに処理を委譲し、その結果を返す。
	 */
	@SuppressWarnings("unchecked")
	public TResult handle(TRequest request, ExecutionContext context) {
		return isAppliedTo(request, context)
				? handler.handle(request, context)
				: (TResult) context.handleNext(request);
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public List<Object> getDelegates(TRequest request, ExecutionContext context) {
		return isAppliedTo(request, context) ? Arrays.asList(handler)
				: Collections.EMPTY_LIST;
	}

	/**
	 * 処理移譲対象となるハンドラを返す。
	 * @return 処理移譲対象のハンドラ
	 */
	protected Handler<TRequest, TResult> getDelegate() {
		return handler;
	}

	/**
	 * このハンドラエントリ内にハンドラを設定する。
	 * @param handler リクエストハンドラ
	 * @return このオブジェクト自体
	 */
	public RequestHandlerEntry<TRequest, TResult> setHandler(Handler<TRequest, TResult> handler) {
		this.handler = Interceptor.Factory.wrap(handler);
		return this;
	}

	/** このハンドラエントリが保持しているハンドラ。 */
	private Handler<TRequest, TResult> handler = null;

	/** URIとリクエストパターンのマッピングを行うクラス */
	private RequestPathMatchingHelper helper;

	/**
	 * このエントリ内のハンドラを実行するリクエストパスの
	 * パターン文字列を設定する。
	 * @param requestPattern リクエストパターン文字列
	 * @return このインスタンス自体
	 */
	public RequestHandlerEntry<TRequest, TResult> setRequestPattern(String requestPattern) {
		helper = new RequestPathMatchingHelper(false).setRequestPattern(requestPattern);
		return this;
	}

	/**
	 * 渡されたリクエストに対して、ハンドラを実行する必要があるかどうかを判断する。
	 * このエントリに設定されたリクエストパターンがリクエストパスにマッチする場合はtrueを返す。
	 * @param request リクエストデータ
	 * @param context 実行コンテキスト
	 * @return ハンドラを実行する必要がある場合はtrue
	 */
	public boolean isAppliedTo(TRequest request,
			ExecutionContext context) {
		if (helper == null) {
			throw new IllegalStateException("requestPattern must be set.");
		}
		return helper.isAppliedTo(request, context);
	}

	/** {@inheritDoc} */
	public String toString() {
		String handlerToString = "handler               : " + handler.toString();
		if (helper != null) {
			return Builder.lines(helper.toString(), handlerToString);
		} else {
			return handlerToString;
		}
	}
}
