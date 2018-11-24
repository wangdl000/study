package nablarch.core.message;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationExceptionTest {

	@Test
	public void testConstructor() {

		Message msg1 = new Message(MessageLevel.ERROR, new MockMessage("MSG00001", "message1"));
		Message msg2 = new Message(MessageLevel.ERROR, new MockMessage("MSG00002", "message2"));
		Message msg3 = new Message(MessageLevel.ERROR, new MockMessage("MSG00003", "message3"));
		Message msg4 = new Message(MessageLevel.ERROR, new MockMessage("MSG00004", "message4"));
		Message msg5 = new Message(MessageLevel.ERROR, new MockMessage("MSG00005", "message5"));

		ApplicationException ae1 = new ApplicationException(msg1);

		Assert.assertThat(ae1.getMessages()
				.get(0)
				.getMessageId(), is("MSG00001"));

		List<Message> messages1 = new ArrayList<Message>();
		messages1.add(msg1);
		messages1.add(msg2);
		messages1.add(msg3);

		List<Message> messages2 = new ArrayList<Message>();
		messages2.add(msg4);
		messages2.add(msg5);

		ApplicationException ae2 = new ApplicationException(messages1);

		Assert.assertThat(ae2.getMessages()
				.get(0)
				.getMessageId(), is("MSG00001"));
		Assert.assertThat(ae2.getMessages()
				.get(1)
				.getMessageId(), is("MSG00002"));
		Assert.assertThat(ae2.getMessages()
				.get(2)
				.getMessageId(), is("MSG00003"));

		Assert.assertThat(ae2.getMessage(), is("message1\nmessage2\nmessage3\n"));

		ApplicationException ae3 = new ApplicationException(messages1);
		ae3.addMessages(messages2);

		Assert.assertThat(ae3.getMessages()
				.get(0)
				.getMessageId(), is("MSG00001"));
		Assert.assertThat(ae3.getMessages()
				.get(1)
				.getMessageId(), is("MSG00002"));
		Assert.assertThat(ae3.getMessages()
				.get(2)
				.getMessageId(), is("MSG00003"));
		Assert.assertThat(ae3.getMessages()
				.get(3)
				.getMessageId(), is("MSG00004"));
		Assert.assertThat(ae3.getMessages()
				.get(4)
				.getMessageId(), is("MSG00005"));

		Assert.assertThat(ae3.getMessage(), is("message1\nmessage2\nmessage3\nmessage4\nmessage5\n"));
	}

	private static class MockMessage implements StringResource {

		public MockMessage(String id, String format) {
			super();
			this.id = id;
			this.format = format;
		}

		private String id;

		private String format;

		public String getId() {
			return id;
		}

		public String getValue(Locale lang) {
			return format;
		}

	}
}
