package nablarch.core.log;

public class MockLogger implements Logger {

	private String name;

	MockLogger(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void logDebug(String message, Object... options) {
	}

	public void logDebug(String message, Throwable error, Object... options) {

	}

	public void logError(String message, Object... options) {

	}

	public void logError(String message, Throwable error, Object... options) {

	}

	public void logFatal(String message, Object... options) {

	}

	public void logFatal(String message, Throwable error, Object... options) {

	}

	public void logInfo(String message, Object... options) {

	}

	public void logInfo(String message, Throwable error, Object... options) {

	}

	public boolean isDebugEnabled() {
		return false;
	}

	public boolean isErrorEnabled() {
		return false;
	}

	public boolean isFatalEnabled() {
		return false;
	}

	public boolean isInfoEnabled() {
		return false;
	}

	public boolean isTraceEnabled() {
		return false;
	}

	public boolean isWarnEnabled() {
		return false;
	}

	public void logTrace(String message, Object... options) {

	}

	public void logTrace(String message, Throwable error, Object... options) {

	}

	public void logWarn(String message, Object... options) {

	}

	public void logWarn(String message, Throwable error, Object... options) {

	}

}
