package nablarch.core.log;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.core.IsSame.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nablarch.core.log.LogUtil.ObjectCreator;

/**
 * {@link LoggerManager}のテスト。
 * @author Kiyohito Itoh
 */
public class LoggerManagerTest extends LogTestSupport {

	@Before
	public void clear() throws Exception {
		System.getProperties().remove("nablarch.log.filePath");
		System.getProperties()
				.remove("loggerFactory.className");
	}

	@After
	public void clearSystemProperty() throws Exception {
		System.getProperties().remove("nablarch.log.filePath");
	}

	/**
	 * 設定不備に対応できること。
	 */
	@Test
	public void testInvalidSettings() {

		System.setProperty("nablarch.log.filePath", "classpath:nablarch/core/log/log-invalid.properties");

		ClassLoader defaultCL = Thread.currentThread().getContextClassLoader();
		ClassLoader customCL1 = new CustomClassLoader(defaultCL);

		Thread.currentThread().setContextClassLoader(customCL1);

		try {
			LoggerManager.get("test");
			fail("must be thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
			e.printStackTrace();
		}

		Thread.currentThread().setContextClassLoader(defaultCL);
	}

	private static final ObjectCreator<String> TEST_CREATOR = new TestCreator();

	private static final class TestCreator implements ObjectCreator<String> {
		private static int count = 0;

		public String create() {
			count++;
			return "test_test";
		}

		public static int getCount() {
			return count;
		}
	};

	/**
	 * いろいろな呼び出しをテストする。
	 */
	@Test
	public void testVarietyUses() {

		MockLoggerFactory.resetCount();

		System.setProperty("nablarch.log.filePath", "classpath:nablarch/core/log/log-mock.properties");

		ClassLoader defaultCL = Thread.currentThread().getContextClassLoader();
		ClassLoader customCL1 = new CustomClassLoader(defaultCL);

		Thread.currentThread().setContextClassLoader(customCL1);

		// 未初期化状態で終了処理が呼ばれてもエラーにならないこと。
		LoggerManager.terminate();

		assertThat(MockLoggerFactory.getCount(), is(0));

		// クラス指定でFQCN名のロガーが取得できること。
		MockLogger mockLogger = (MockLogger) LoggerManager.get(LoggerManagerTest.class);
		assertThat(mockLogger.getName(), is(LoggerManagerTest.class.getName()));

		assertThat(MockLoggerFactory.getCount(), is(1));

		// キャッシュしているロガーファクトリが利用されること。
		MockLogger mockLogger2 = (MockLogger) LoggerManager.get(LoggerManagerTest.class);
		assertThat(MockLoggerFactory.getCount(), is(1));

		// 同じロガー名でも新しいロガーが生成されること。
		assertThat(mockLogger, not(sameInstance(mockLogger2)));

		// 同じクラスローダに別のオブジェクトを作成する。
		LogUtil.getObjectBoundToClassLoader(TEST_CREATOR);
		// 1回だけ生成されたのでcountは1。
		assertThat(TestCreator.getCount(), is(1));

		// クラスローダに紐付く全てのオブジェクトを解放する。
		LoggerManager.terminate();

		// 同じクラスローダに別のオブジェクトを作成する。
		LogUtil.getObjectBoundToClassLoader(TEST_CREATOR);
		// 2回目の生成なのでcountは2。
		assertThat(TestCreator.getCount(), is(2));

		// 2回終了処理が呼ばれてもエラーにならないこと。
		LoggerManager.terminate();

		Thread.currentThread().setContextClassLoader(defaultCL);
	}
}
