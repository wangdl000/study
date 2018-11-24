package nablarch.core.message;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**
 * {@link BasicMessageFormatter}のテスト。
 */
public class BasicMessageFormatterTest {

	/** テスト対象 */
	private final BasicMessageFormatter sut = new BasicMessageFormatter();

	/**
	 * オプションに単一の値を指定したい場合。
	 * 
	 * その値の要素番号を元にメッセージがフォーマットされること。
	 */
	@Test
	public void optionsOfSingle() throws Exception {
		final String template = "{0}以下で入力してください。";
		final String actual = sut.format(template, array(100));

		assertThat(actual, is("100以下で入力してください。"));
	}

	/**
	 * オプションに配列を指定した場合。
	 * <p>
	 * {@link java.text.MessageFormat}を使ったフォーマット処理が行われること。
	 */
	@Test
	public void optionOfArray() throws Exception {
		final String template = "{0}を入力してください。オプション1:{1}";
		final String actual = sut.format(template, array("名前", 100));

		assertThat(actual, is("名前を入力してください。オプション1:100"));
	}

	/**
	 * オプションにMapを指定した場合。
	 * <p>
	 * テンプレートに記述された「{キー名}」の部分が置き換えられること。
	 */
	@Test
	public void optionOfMap() throws Exception {

		final HashMap<String, String> options = new HashMap<String, String>();
		options.put("name", "名前");

		final String template = "{name}を入力してください。";
		final String actual = sut.format(template, array(options));

		assertThat(actual, is("名前を入力してください。"));
	}

	/**
	 * オプションに複数のキーを持つMapを指定した場合。
	 * <p>
	 * テンプレート中の「{キー名}」の部分が置き換えられること。
	 */
	@Test
	public void optionOfMultiKeyMap() throws Exception {

		final HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("opt1", "なまえ");
		options.put("opt2", 999L);

		final String template = "{opt1}-{opt2}-{opt1}";
		final String actual = sut.format(template, array(options));
		assertThat(actual, is("なまえ-999-なまえ"));
	}

	/**
	 * 値にnullを持つMapを指定した場合。
	 * 
	 * nullが格納されているキーの部分は空文字列に置き換えられること。
	 */
	@Test
	public void optionOfMapContainsNullValue() throws Exception {
		final HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("opt1", "");
		options.put("opt2", null);

		final String template = "{opt1}-{opt2}-{opt1}";
		final String actual = sut.format(template, array(options));
		assertThat(actual, is("--"));
	}

	/**
	 * オプションにnullを指定した場合。
	 * <p>
	 * テンプレート文字列がそのまま返却されること。
	 */
	@Test
	public void optionOfNull() throws Exception {
		final String template = "{0}を入力してください。";

		final String actual = sut.format(template, null);
		assertThat(actual, is(template));
	}

	private Object[] array(Object... options) {
		return options;
	}
}