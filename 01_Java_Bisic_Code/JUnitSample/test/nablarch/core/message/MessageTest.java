package nablarch.core.message;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nablarch.core.ThreadContext;
import nablarch.core.repository.ObjectLoader;
import nablarch.core.repository.SystemRepository;

public class MessageTest {

	@Before
	public void setUp() {
		ThreadContext.clear();
		SystemRepository.clear();
	}

	@After
	public void tearDown() {
		ThreadContext.clear();
	}

	@Test
	public void testConstructor() {
		final StringResource innerMessage = new RightMessage("0001", "testInner");
		final StringResource message = new RightMessage("1001", "{0},{1}");
		final Message resultMessage = new Message(MessageLevel.INFO, message, new Object[] { "test", innerMessage });

		assertThat(resultMessage.getMessageId(), is("1001"));
		assertThat(resultMessage.formatMessage(), is("test,testInner"));
		assertThat(resultMessage.getLevel(), is(MessageLevel.INFO));
	}

	@Test
	public void testConstructor2() {
		final StringResource message = new RightMessage("1001", "test message");
		final Message resultMessage = new Message(MessageLevel.WARN, message);

		assertThat(resultMessage.getMessageId(), is("1001"));
		assertThat(resultMessage.formatMessage(), is("test message"));
		assertThat(resultMessage.getLevel(), is(MessageLevel.WARN));
	}

	@Test
	public void testConstructor3() {
		final StringResource message = new RightMessage("1001", "test message");
		final Message resultMessage = new Message(MessageLevel.ERROR, message);

		assertThat(resultMessage.getMessageId(), is("1001"));
		assertThat(resultMessage.formatMessage(), is("test message"));
		assertThat(resultMessage.getLevel(), is(MessageLevel.ERROR));
	}

	@Test
	public void testFormatMessage() {
		final StringResource rightMessage = new RightMessage("1001", new HashMap<String, String>() {
			{
				put("ja", "テスト {0}");
				put("en", "test {0}");
			}
		});
		final StringResource innerRightMessage = new RightMessage("0001", new HashMap<String, String>() {
			{
				put("ja", "テストインナー");
				put("en", "testInner");
			}
		});

		final Message innerMessage = new Message(MessageLevel.ERROR, innerRightMessage);
		final Message resultMessage = new Message(MessageLevel.ERROR, rightMessage, new Object[] { innerMessage });

		// ja (default locale)
		assertThat(resultMessage.getMessageId(), is("1001"));
		assertThat(resultMessage.formatMessage(), is("テスト テストインナー"));
		assertThat(resultMessage.getLevel(), is(MessageLevel.ERROR));

		// en
		ThreadContext.setLanguage(Locale.ENGLISH);

		assertThat(resultMessage.getMessageId(), is("1001"));
		assertThat(resultMessage.formatMessage(), is("test testInner"));
		assertThat(resultMessage.getLevel(), is(MessageLevel.ERROR));
	}

	@Test
	public void testEqualsAndHashCode() {
		Message one;
		Message another;

		one = new Message(MessageLevel.ERROR, new RightMessage("0001", ""));
		another = one;
		assertThat("same object.", another, is(one));

		one = new Message(MessageLevel.ERROR, new RightMessage("0001", ""));
		another = new Message(MessageLevel.ERROR, new RightMessage("0001", ""));
		assertThat("equal object.", another, is(one));

		one = new Message(MessageLevel.ERROR, null);
		another = new Message(MessageLevel.ERROR, null);
		assertThat("equal object. (without StringResource)", another, is(one));

		one = new Message(null, new RightMessage("0001", ""));
		another = new Message(null, new RightMessage("0001", ""));
		assertThat("equal object. (without level)", another, is(one));

	}

	@Test
	public void testNotEqualsAndHashCode() {
		Message one, another;

		assertThat("compare to null", new Message(null, null), notNullValue());

		one = new Message(MessageLevel.ERROR, null);
		another = new Message(MessageLevel.ERROR, null) {
		}; // anonymous subclass
		assertThat("Class differs", one, not(is(another)));

		one = new Message(MessageLevel.ERROR, null);
		another = new Message(MessageLevel.WARN, null);
		assertNotEquals("MessageLevel differs", one, another);

		one = new Message(MessageLevel.ERROR, new RightMessage("0001", ""));
		another = new Message(MessageLevel.ERROR, new RightMessage("9999", ""));
		assertNotEquals("StringResource differs", one, another);

		one = new Message(MessageLevel.ERROR, new RightMessage("0001", ""));
		another = new Message(null, new RightMessage("0001", ""));
		assertNotEquals("StringResource differs", one, another);

		one = new Message(MessageLevel.ERROR, null);
		another = new Message(MessageLevel.ERROR, new RightMessage("9999", ""));
		assertNotEquals("StringResource differs (one has null)", one, another);

		one = new Message(MessageLevel.ERROR, new RightMessage("0001", ""));
		another = new Message(MessageLevel.ERROR, null);
		assertNotEquals("StringResource differs (another has null)", one, another);

		one = new Message(MessageLevel.ERROR, new RightMessage("0001", ""), new String[] { "foo", "bar" });
		another = new Message(MessageLevel.ERROR, new RightMessage("0001", ""), new String[] { "foo", "baz" });
		assertNotEquals("option differs.", one, another);
	}

	/**
	 * MessageFormatterを差し替えて利用できること。
	 */
	@Test
	public void customMessageFormatter() throws Exception {
		SystemRepository.load(new ObjectLoader() {
			@Override
			public Map<String, Object> load() {
				return Collections.<String, Object> singletonMap(
						"messageFormatter", new JavaMessageFormatBaseMessageFormatter());
			}
		});

		final Message message = new Message(MessageLevel.ERROR, new RightMessage(
				"id", "{0}-{0}-{1}"), new Object[] { "1", "2" });

		assertThat(message.formatMessage(), is("1-1-2"));
	}

	private void assertNotEquals(final String msg, final Message one, final Message another) {
		assertThat(msg, one, not(is(another)));
		assertThat(msg + "(hashCode)", one.hashCode() == another.hashCode(), is(false)); // optional when not equal
	}

	private static class RightMessage implements StringResource {

		private static final Locale DEFAULT_LOCALE = new Locale(Locale.getDefault().getLanguage());

		private final String id;
		private final Map<Locale, String> formats;

		public RightMessage(final String id, final String format) {
			super();
			this.id = id;
			formats = new HashMap<Locale, String>() {
				{
					put(DEFAULT_LOCALE, format);
				}
			};
		}

		public RightMessage(final String id, final Map<String, String> formats) {
			super();
			this.id = id;
			this.formats = new HashMap<Locale, String>();
			for (final Map.Entry<String, String> entry : formats.entrySet()) {
				this.formats.put(new Locale(entry.getKey()), entry.getValue());
			}
		}

		@Override
		public String getId() {
			return id;
		}

		@Override
		public String getValue(final Locale lang) {
			return formats.get(lang);
		}
	}
}
