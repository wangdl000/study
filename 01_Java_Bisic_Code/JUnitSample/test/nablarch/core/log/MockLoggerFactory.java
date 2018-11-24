package nablarch.core.log;

public class MockLoggerFactory implements LoggerFactory {

	private static int count = 0;

	public static void resetCount() {
		count = 0;
	}

	public static int getCount() {
		return count;
	}

	public MockLoggerFactory() {
		count++;
	}

	public Logger get(String name) {
		return new MockLogger(name);
	}

	public void initialize(LogSettings settings) {

	}

	public void terminate() {

	}

}
