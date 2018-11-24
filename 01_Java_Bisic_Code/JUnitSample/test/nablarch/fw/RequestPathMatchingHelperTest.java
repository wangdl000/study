package nablarch.fw;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;

/**
 * {@link RequestPathMatchingHelper}のテスト。
 * @author Kiyohito Itoh
 */
public class RequestPathMatchingHelperTest {

	@Test
	public void testURISyntaxException() {
		RequestPathMatchingHelper helper = new RequestPathMatchingHelper(true);
		try {
			helper.setRequestPattern("hoge hoge");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("invalid requestPath: hoge hoge"));
			assertThat(e.getCause().getClass().getSimpleName(), is(URISyntaxException.class.getSimpleName()));
		}
	}

	@Test
	public void testInvalidInvoking() {
		try {
			new RequestPathMatchingHelper(true).isAppliedTo(null, null);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), is("requestPattern must be set."));
		}
	}
}
