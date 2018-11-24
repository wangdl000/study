package nablarch.core.util;

import static org.hamcrest.CoreMatchers.*;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class GlobTest {

	@Test
	public void testEmptyPattern() {
		Pattern empty = Glob.compile("");
		Assert.assertThat(empty.matcher("yth115yea;yu")
				.matches(), is(true));
		Assert.assertThat(empty.matcher("")
				.matches(), is(true));
		Assert.assertThat(empty.matcher("test.txt")
				.matches(), is(true));
		Assert.assertThat(empty.matcher("test/hoge")
				.matches(), is(false));

		empty = Glob.compile(null);
		Assert.assertThat(empty.matcher("yth115yea;yu")
				.matches(), is(true));
		Assert.assertThat(empty.matcher("")
				.matches(), is(true));
		Assert.assertThat(empty.matcher("test.txt")
				.matches(), is(true));
		Assert.assertThat(empty.matcher("test/hoge")
				.matches(), is(false));
	}

	@Test
	public void testPatternExpressionIncludingWildCardForString() {
		Pattern glob = Glob.compile("*.txt");
		Assert.assertThat(glob.matcher("hoge.txt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher(".txt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("hog ee.txt")
				.matches(), is(true));

		Assert.assertThat(glob.matcher("hoge.text")
				.matches(), is(false));
		Assert.assertThat(glob.matcher("hoge.bak.txt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("/fuga/hoge.txt")
				.matches(), is(false));
		Assert.assertThat(glob.matcher("")
				.matches(), is(false));

		glob = Glob.compile("/aba/G*");
		Assert.assertThat(glob.matcher("/aba/G7777")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("/aba/G7777.jsp")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("/aba/F7777")
				.matches(), is(false));
	}

	@Test
	public void testPatternExpressionIncludingWildCardForOneCharacter() {
		Pattern glob = Glob.compile("*.t?t");
		Assert.assertThat(glob.matcher("hoge.txt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("hoge.tyt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("hoge.t0t")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("hoge.tt")
				.matches(), is(false));

		glob = Glob.compile("/aba?/*/*");
		Assert.assertThat(glob.matcher("/aba1/hoge/test.txt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("/aba2/hoge/test.txt")
				.matches(), is(true));
		Assert.assertThat(glob.matcher("/aba/hoge/test.txt")
				.matches(), is(false));
		Assert.assertThat(glob.matcher("/aba3/test.txt")
				.matches(), is(false));
	}
}
