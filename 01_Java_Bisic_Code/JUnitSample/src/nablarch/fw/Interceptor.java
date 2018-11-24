package nablarch.fw;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nablarch.core.repository.SystemRepository;
import nablarch.core.util.annotation.Published;

/**
 * {@link Handler#handle(Object, ExecutionContext)}メソッドに対するインターセプタに付与する
 * メタアノテーション。
 * <p/>
 * インターセプタを作成するには、このメタアノテーションを付与したアノテーションを作成し、
 * {@link Interceptor}の属性には、インターセプト処理を実装するクラスを指定する。
 * この実装クラスは、{@link Interceptor.Impl} を継承して作成する。
 * <p/>
 * 以下は、インターセプタ"@AroundAdvice"の実装例である。
 *
 * <pre>
 * {@code @Target}(ElementType.METHOD)
 * {@code @Retention}(RetentionPolicy.RUNTIME)
 * {@code @Interceptor}(AroundAdvice.Impl.class)
 * public {@code @interface} AroundAdvice {
 *     public static class Impl extends Interceptor.Impl<HttpRequest, HttpResponse, AroundAdvice> {
 *         public HttpResponse handle(HttpRequest req, ExecutionContext ctx) {
 *             doBeforeAdvice(req, ctx);
 *             HttpResponse res =  getOriginalHandler().handle(req, ctx);
 *             doAfterAdvice(req, ctx);
 *             return res;
 *         }
 *         void doBeforeAdvice(HttpRequest req, ExecutionContext ctx) {
 *             //......
 *         }
 *         void doAfterAdvice(HttpRequest req, ExecutionContext ctx) {
 *             //......
 *        }
 *     }
 * }
 * </pre>
 *
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Published(tag = "architect")
public @interface Interceptor {

	/**
	 * このインターセプタが付与されたメソッドに対して実行される
	 * インターセプト処理を実装するクラス。
	 *
	 * @see Interceptor.Impl
	 */
	@SuppressWarnings("rawtypes")
	Class<? extends Interceptor.Impl> value();

	/**
	 * {@link Interceptor}の処理内容を実装するクラスの抽象基底クラスとなるリクエストハンドラ。
	 * <p/>
	 * 各インターセプションが付与されたときに行われるインターセプト処理の内容は、
	 * このクラスを継承して作成する。
	 * <p/>
	 * 各{@link Interceptor}の値に指定されるクラスは、このクラスのサブクラスであり、
	 * インターセプトが行われると、そのサブクラスが実装する{@link Handler#handle(Object, ExecutionContext)}に処理が委譲される。
	 * この際、ラップされる前のリクエストハンドラを{@link #getOriginalHandler()}で取得できるので、
	 * 各インターセプタ固有の処理を以下の例のように実装することができる。
	 * <pre>
	 * public HttpResponse handle(HttpRequest req, ExecutionContext ctx) {
	 *     try {
	 *         doBeforeAdvice(); // インターセプタによる前処理
	 *         return getOriginalHandler().handle(req, ctx); // 本処理
	 *
	 *     } catch(RuntimeException e) {
	 *         doErrorHandling();  // インターセプタによる例外ハンドリング
	 *         throw e;
	 *
	 *     } finally {
	 *         doAfterAdvice();  // インターセプタによる終端処理
	 *     }
	 * }
	 * </pre>
	 *
	 * @author Iwauo Tajima <iwauo@tis.co.jp>
	 */
	public abstract static class Impl<TData, TResult, T extends Annotation>
			implements HandlerWrapper<TData, TResult> {

		@Published(tag = "architect")
		public Impl() {
		}

		/**
		 * 処理対象の{@link Interceptor}を設定する。
		 *
		 * @param annotation このクラスが実装する{@link Interceptor}
		 */
		@SuppressWarnings("unchecked")
		public void setInterceptor(Annotation annotation) {
			this.interceptor = (T) annotation;
		}

		/**
		 * 処理対象の{@link Interceptor}を取得する。
		 *
		 * @return 処理対象の{@link Interceptor}を取得する。
		 */
		@Published(tag = "architect")
		public T getInterceptor() {
			return interceptor;
		}

		/** 処理対象の{@link Interceptor}アノテーション */
		private T interceptor;

		/**
		 * インターセプト対象のリクエストハンドラを取得する。
		 *
		 * @return インターセプト対象のリクエストハンドラ
		 */
		@Published(tag = "architect")
		public Handler<TData, TResult> getOriginalHandler() {
			return originalHandler;
		}

		/**
		 * インターセプト対象のリクエストハンドラを設定する。
		 *
		 * @param originalHandler インターセプト対象のリクエストハンドラ
		 */
		public void setOriginalHandler(
				Handler<TData, TResult> originalHandler) {
			this.originalHandler = originalHandler;
		}

		/** {@inheritDoc} */
		@SuppressWarnings("unchecked")
		public List<Object> getDelegates(TData data, ExecutionContext context) {
			return (originalHandler == null) ? Collections.EMPTY_LIST
					: Arrays.asList(originalHandler);
		}

		/** インターセプト対象のリクエストハンドラ */
		private Handler<TData, TResult> originalHandler;
	}

	/**
	 * {@link Interceptor}アノテーションによる{@link Handler#handle(Object, ExecutionContext)}
	 * へのインターセプトを実現するスタティックメソッドを保持するクラス。
	 * <p/>
	 * 次のコードにより、handler.handle() メソッド上に付与されている
	 * {@link Interceptor}アノテーションを収集し、各インターセプタに対応した
	 * リクエストハンドラでラップされたハンドラ(wrapped)が生成される。
	 * <pre>
	 *     Handler wrapped = Interceptor.Factory.wrap(handler);
	 * </pre>
	 * wrapped.handle() を実行すると、各インターセプタのhandle()メソッドが順次実行され、
	 * 最後に元のリクエストハンドラのhandle()メソッドが呼ばれる。
	 * <p/>
	 * インターセプタの実行順は、{@link SystemRepository}にキー値:interceptorsOrderで定義する。
	 * <p/>
	 * 以下のように定義した場合、インターセプタはInterceptor2、Interceptor1の順で実行される。
	 * <pre>
	 * {@code
	 * <list name="interceptorsOrder">
	 *   <value>test.Interceptor2</value>
	 *   <value>test.Interceptor1</value>
	 * </list>
	 * }</pre>
	 * {@link SystemRepository}に実行順が定義されている場合に、実行順に定義されていないインターセプタを
	 * 使用すると、実行時例外({@link IllegalArgumentException})を送出し処理を終了する。
	 *
	 * {@link SystemRepository}に実行順が定義されていない場合は、
	 * {@link Method#getDeclaredAnnotations()}で返されるリストの逆順で実行される。
	 *
	 * ※{@link Method#getDeclaredAnnotations()}で返される順序は、規定されていないため実行環境(jvmのバージョンなど)により結果が変わる可能性がある。
	 * このため、実行順を保証する必要がある場合は、必ず{@link SystemRepository}に実行順の定義を行うこと。
	 *
	 * @author Iwauo Tajima <iwauo@tis.co.jp>
	 */
	public static final class Factory {

		/** インターセプタの実行順定義のリポジトリ上のキー値 */
		private static final String INTERCEPTOR_ORDER_KEY = "interceptorsOrder";

		/** デフォルトコンストラクタ */
		private Factory() {
			/* doesn't need any instances. */
		}

		/**
		 * {@link Interceptor}アノテーションによるリクエストハンドラの
		 * ラッパーを作成する。
		 * <p/>
		 * 与えられたリクエストハンドラの{@link Handler#handle(Object, ExecutionContext)} メソッド上に付与された
		 * {@link Interceptor}アノテーションを取得し、
		 * その内容に準じた処理をリクエストハンドラに追加したラッパーで作成する。
		 *
		 * @param <D> ハンドラの入力データ型
		 * @param <R> ハンドラの処理結果データ型
		 * @param handler ラップされるハンドラ
		 * @return {@link Interceptor}の処理を追加したリクエストハンドラ
		 */
		public static <D, R> Handler<D, R> wrap(Handler<D, R> handler) {
			Method handleMethod = null;
			for (Method method : handler.getClass().getMethods()) {
				if (method.getName().equals("handle")
						&& method.getParameterTypes().length == 2) {
					handleMethod = method;
					// 型変数がI/Fの引数に使用されているため、オーバーロード扱いになっており、
					// handleメソッドは2回出現する。
					// (I/F側はeraser動作後、handle(Object, ExecutionContext)になる。)
					if (!method.getParameterTypes()[0].equals(Object.class)) {
						break;
					}
				}
			}
			// インターフェースで定義されているので必ず存在する。
			assert (handleMethod != null);
			return wrap(handler, handleMethod.getDeclaredAnnotations());
		}

		/**
		 * 与えられた{@link Interceptor}アノテーションによって
		 * リクエストハンドラをラップする。
		 * <p/>
		 * ただし、リクエストハンドラの{@link Handler#handle(Object, ExecutionContext)}
		 * メソッドに付与されたアノテーションについては評価しない。
		 *
		 * @param <D> ハンドラの入力データ型
		 * @param <R> ハンドラの処理結果データ型
		 * @param handler ハンドラ
		 * @param annotations {@link Interceptor}アノテーション
		 * @return {@link Interceptor}でラップされたリクエストハンドラ
		 */
		public static <D, R> Handler<D, R> wrap(Handler<D, R> handler,
				Annotation[] annotations) {

			final List<Annotation> interceptors = new ArrayList<Annotation>();

			for (Annotation annotation : annotations) {
				final Interceptor interceptor = getInterceptorOf(annotation);
				if (interceptor != null) {
					interceptors.add(annotation);
				}
			}

			final List<Annotation> sortedInterceptors = sortInterceptors(interceptors);

			for (Annotation annotation : sortedInterceptors) {
				handler = wrap(handler, getInterceptorOf(annotation), annotation);
			}

			return handler;
		}

		/**
		 * 与えられたアノテーションに付与されている
		 * {@link Interceptor}メタアノテーションを返す。
		 *
		 * @param annotation メタアノテーション
		 * @return 付与されている{@link Interceptor}アノテーション。
		 *         {@link Interceptor}が付与されていない場合はnull。
		 */
		public static Interceptor getInterceptorOf(final Annotation annotation) {
			return annotation.annotationType().getAnnotation(Interceptor.class);
		}

		/**
		 * インターセプタをソートする。
		 * <p/>
		 * インターセプタの実行順が{@link SystemRepository}に定義されている場合、
		 * その定義に従いインターセプタをソート(実行順とは逆順でソート)する。
		 * <p/>
		 * {@link SystemRepository}に実行順の定義がない場合は、ソートは行わない。
		 *
		 * @param interceptors ソート対象のインターセプタのリスト
		 * @return ソート後のインターセプタのリスト(実行順とは逆順)
		 */
		private static List<Annotation> sortInterceptors(final List<Annotation> interceptors) {
			final List<String> order = SystemRepository.get(INTERCEPTOR_ORDER_KEY);
			if (order == null) {
				// 実行順未定義の場合は、ソートを実施しない
				return interceptors;
			}

			final List<Annotation> result = new ArrayList<Annotation>();
			for (String interceptorName : order) {
				final Annotation interceptor = findInterceptor(interceptors, interceptorName);
				if (interceptor != null) {
					result.add(interceptor);
					interceptors.remove(interceptor);
				}
			}
			if (!interceptors.isEmpty()) {
				throw new IllegalArgumentException("interceptor is undefined in the interceptorsOrder."
						+ " undefined interceptors=" + interceptors);
			}
			Collections.reverse(result);
			return result;
		}

		/**
		 * {@code fqcn}に一致するアノテーションを取得する。
		 *
		 * @param interceptors インターセプタのリスト。
		 * @param fqcn 完全修飾名
		 * @return 完全修飾名と一致するインターセプタ
		 */
		private static Annotation findInterceptor(final List<Annotation> interceptors, final String fqcn) {
			Annotation result = null;
			for (Annotation interceptor : interceptors) {
				if (fqcn.equals(interceptor.annotationType().getName())) {
					result = interceptor;
					break;
				}
			}
			return result;
		}

		/**
		 * 与えられた{@link Interceptor}アノテーションでリクエストハンドラを
		 * ラップする。
		 *
		 * @param <TData> ハンドラの入力データ型
		 * @param <TResult> ハンドラの処理結果データ型
		 * @param handler ハンドラ
		 * @param interceptor {@link Interceptor}アノテーション
		 * @param annotation アノテーション
		 * @return ラップされたリクエストハンドラ
		 */
		@SuppressWarnings("unchecked")
		private static <TData, TResult> Handler<TData, TResult> wrap(Handler<TData, TResult> handler,
				Interceptor interceptor,
				Annotation annotation) {
			Interceptor.Impl<TData, TResult, ? extends Annotation> wrapper = null;
			try {
				wrapper = interceptor.value().getConstructor().newInstance();

			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				// 委譲先のメソッドで例外が送出された場合。
				Throwable cause = e.getCause();
				if (RuntimeException.class.isAssignableFrom(cause.getClass())) {
					throw (RuntimeException) cause;
				}
				if (Error.class.isAssignableFrom(cause.getClass())) {
					throw (Error) cause;
				}
				throw new RuntimeException(cause);
			} catch (NoSuchMethodException e) {
				// デフォルトコンストラクタが未定義。
				throw new RuntimeException(
						"Default constructor is needed to handle interception.: "
								+ interceptor.value().toString(),
						e);
			}
			wrapper.setOriginalHandler(handler);
			wrapper.setInterceptor(annotation);
			return wrapper;
		}
	}
}
