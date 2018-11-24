package nablarch.core.message;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link JavaMessageFormatBaseMessageFormatter}のテストクラス。
 */
public class JavaMessageFormatBaseMessageFormatterTest {

	private final MessageFormatter sut = new JavaMessageFormatBaseMessageFormatter();

	@Test
	public void 埋め込み文字がない場合はそのままのメッセージが返されること() {
		assertThat(sut.format("テンプレートメッセージ", new Object[0]), is("テンプレートメッセージ"));
	}

	@Test
	public void 埋め込みオブジェクトにnullを指定した場合はメッセージがそのまま返されること() {
		assertThat(sut.format("これはそのまま→{0}", null), is("これはそのまま→{0}"));
	}

	@Test
	public void 埋め込みオブジェクトを指定した場合はJavaのMessageFormatの仕様に従い値が埋め込まれること() {
		assertThat(sut.format("埋め込み1: {0}、埋め込み2: {1}", new Object[] { "あいうえお", 12345 }),
				is("埋め込み1: あいうえお、埋め込み2: 12,345"));
	}

	@Test
	public void 埋め込みオブジェクトに任意のObjectを指定した場合toStringした結果が埋め込まれること() {
		assertThat(sut.format("toStringの結果→{0}", new Object[] { new Obj() }), is("toStringの結果→任意のオブジェクト"));
	}

	private static class Obj {
		@Override
		public String toString() {
			return "任意のオブジェクト";
		}
	}
}