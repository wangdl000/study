package nablarch.core.message;

import java.text.MessageFormat;

/**
 * {@link MessageFormat}を使用してメッセージのフォーマットを行うクラス。
 *
 * @author Hisaaki Shioiri
 * @see MessageFormat
 */
public class JavaMessageFormatBaseMessageFormatter implements MessageFormatter {

	@Override
	public String format(final String template, final Object[] options) {
		return new MessageFormat(template).format(options);
	}
}
