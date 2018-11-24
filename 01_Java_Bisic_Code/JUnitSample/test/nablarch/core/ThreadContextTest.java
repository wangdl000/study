package nablarch.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * {@link ThreadContext}のテストクラス。
 *
 * @author Kiyohito Itoh
 */
public class ThreadContextTest {

	/** アクセッサのテスト。 */
	@Test
	public void testAccessor() {

		Locale language = new Locale("ja");
		ThreadContext.setLanguage(language);
		assertThat(ThreadContext.getLanguage(), is(language));

		String userId = "userId";
		ThreadContext.setUserId(userId);
		assertThat(ThreadContext.getUserId(), is(userId));

		String requestId = "requestId";
		ThreadContext.setRequestId(requestId);
		assertThat(ThreadContext.getRequestId(), is(requestId));

		String objectKey = "object";
		Object object = new Object();
		ThreadContext.setObject(objectKey, object);
		assertThat(ThreadContext.getObject(objectKey), is(object));

		ThreadContext.clear();

		assertThat(ThreadContext.getLanguage(), nullValue());
		assertThat(ThreadContext.getUserId(), nullValue());
		assertThat(ThreadContext.getRequestId(), nullValue());
		assertThat(ThreadContext.getObject(objectKey), nullValue());
	}

	/** 子スレッドへの引き継ぎ確認のテスト。 */
	@Test
	@SuppressWarnings("unchecked")
	public void testSubThread() {

		// リクエストID
		final String requestId = "リクエストID";
		ThreadContext.setRequestId(requestId);

		// 任意のオブジェクト
		final Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		ThreadContext.setObject("object", map);

		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
			Future<Void> submit = service.submit(new Callable<Void>() {
				public Void call() throws Exception {
					// 子スレッドでアサートを実施する。
					// 親スレッドで設定されている値が引き継がれていることをチェック

					// リクエストID
					assertThat(ThreadContext.getRequestId(), is(
							requestId));

					// 任意のオブジェクト
					Map<String, String> object = (Map<String, String>) ThreadContext
							.getObject("object");
					assertThat(object.get("key"), is("value"));

					// 子スレッドでスレッドコンテキスト内のオブジェクトの状態を変更
					object.put("key", "value1");
					ThreadContext.setRequestId("hoge");
					return null;
				}
			});
			try {
				submit.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		} finally {
			// スレッド終了
			service.shutdownNow();
		}

		// リクエストIDでは、子スレッドの変更の影響は受けない
		assertThat(ThreadContext.getRequestId(), is(requestId));

		// スレッド内のオブジェクトの状態は、子スレッドの変更の影響を受ける。
		Map<String, String> object = (Map<String, String>) ThreadContext
				.getObject("object");
		assertThat(object.get("key"), is("value1"));

	}

	@Test
	public void testGetConcurrentNumber() {
		ThreadContext.clear();
		assertThat(ThreadContext.getConcurrentNumber(), is(1));

		ThreadContext.setConcurrentNumber(100);
		assertThat(ThreadContext.getConcurrentNumber(), is(100));
	}

	@Test
	public void clearAndSet() throws Exception {
		ThreadContext.setExecutionId("executionId");

		assertThat(ThreadContext.getExecutionId(), is("executionId"));
		ThreadContext.clear();

		assertThat(ThreadContext.getExecutionId(), is(nullValue()));

		ThreadContext.setUserId("userId");
		assertThat(ThreadContext.getUserId(), is("userId"));
	}
}
