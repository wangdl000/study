package nablarch.core.exception;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *{@link IllegalOperationException}のテスト。
 */
public class IllegalOperationExceptionTest {

	@Test
	public void testMessage() throws Exception {
		IllegalOperationException sut = new IllegalOperationException("testMessage");
		assertThat("メッセージが取得できる", sut.getMessage(), is("testMessage"));
	}
}
