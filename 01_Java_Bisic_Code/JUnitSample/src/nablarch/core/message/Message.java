package nablarch.core.message;

import java.util.Arrays;
import java.util.Locale;

import nablarch.core.ThreadContext;
import nablarch.core.repository.SystemRepository;
import nablarch.core.util.annotation.Published;

/**
 * メッセージに必要な情報を保持し、メッセージのフォーマットを行うクラス。<br/>
 *
 * @author Koichi Asano
 *
 */
@Published
public class Message {

	/** デフォルトのメッセージフォーマッタ */
	private static final MessageFormatter DEFAULT_MESSAGE_FORMATTER = new BasicMessageFormatter();

	/**
	 * メッセージの通知レベル。
	 */
	private final MessageLevel level;

	/**
	 * メッセージの文字列リソース。
	 */
	private final StringResource stringResource;

	/**
	 * メッセージのパラメータ。
	 */
	private final Object[] option;

	/** デフォルトの言語 */
	private static final Locale DEFAULT_LOCALE = new Locale(Locale.getDefault().getLanguage());

	/**
	 * メッセージの通知レベル、文字列リソースを指定して、インスタンスを生成する。
	 *
	 * @param level メッセージの通知レベル
	 * @param stringResource メッセージの文字列リソース
	 */
	public Message(MessageLevel level, StringResource stringResource) {
		super();
		this.level = level;
		this.stringResource = stringResource;
		this.option = null;
	}

	/**
	 * メッセージの通知レベル、文字列リソース、オプションパラメータを指定して、インスタンスを生成する。
	 *
	 * @param level メッセージの通知レベル
	 * @param stringResource メッセージの文字列リソース
	 * @param option メッセージのオプションパラメータ
	 */
	public Message(MessageLevel level, StringResource stringResource, Object[] option) {
		super();
		this.level = level;
		this.stringResource = stringResource;
		this.option = option;
	}

	/**
	 * メッセージの通知レベルを取得する。
	 *
	 * @return メッセージの通知レベル
	 */
	public MessageLevel getLevel() {
		return level;
	}

	/**
	 * 文字列リソースのメッセージIDを取得する。
	 *
	 * @return 文字列リソースのメッセージID
	 */
	public String getMessageId() {
		return stringResource.getId();
	}

	/**
	 * フォーマットしたメッセージを取得する。
	 * <p/>
	 * メッセージの言語には{@link ThreadContext#getLanguage()}に設定された言語を使用する。
	 * スレッドコンテキストに設定されていない場合は、{@link Locale#getDefault()}から取得した言語を返す。
	 *
	 * @return フォーマットしたメッセージ
	 */
	public String formatMessage() {
		return formatMessage(getLanguage());
	}

	/**
	 * スレッドコンテキストから言語を取得する。
	 *
	 * スレッドコンテキストに設定されていない場合は
	 * {@link Locale#getDefault()}から取得した言語を返す。
	 *
	 * @return 言語
	 */
	private static Locale getLanguage() {
		final Locale language = ThreadContext.getLanguage();
		return language != null ? language : DEFAULT_LOCALE;
	}

	/**
	 * 言語を指定してフォーマットしたメッセージを取得する。<br/>
	 * オプションパラメータにMessageが含まれていた場合、フォーマットして使用する。
	 * オプションパラメータにStringResourceが含まれていた場合、言語に対応する文字列を取得して使用する。
	 *
	 * @param locale メッセージの言語
	 *
	 * @return フォーマットしたメッセージ
	 */
	public String formatMessage(Locale locale) {
		final MessageFormatter formatter = getMessageFormatter();
		if (option != null) {
			Object[] convertedParams = new Object[option.length];
			for (int i = 0; i < option.length; i++) {
				if (option[i] instanceof Message) {
					Message msg = (Message) option[i];
					convertedParams[i] = msg.formatMessage(locale);
				} else if (option[i] instanceof StringResource) {
					StringResource msg = (StringResource) option[i];
					convertedParams[i] = msg.getValue(locale);
				} else {
					convertedParams[i] = option[i];
				}
			}
			return formatter.format(stringResource.getValue(locale), convertedParams);
		} else {
			return formatter.format(stringResource.getValue(locale), null);
		}
	}

	/** 文字列リソースが等価であるか判定する。 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true; // 同一インスタンス
		}
		if (o == null || getClass() != o.getClass()) {
			return false; // クラスが異なる。
		}

		Message another = (Message) o;
		if (this.level != another.level) {
			return false; // レベルが異なる
		}

		if (!equals(this.stringResource, another.stringResource)) {
			return false; // 文字列リソースが異なる
		}

		if (!Arrays.equals(this.option, another.option)) {
			return false; // オプションが異なる
		}
		return true;
	}

	/**
	 * 文字列リソースが等価であるか判定する。
	 * @param one 比較対象１
	 * @param another 比較対象２
	 * @return 比較対象オブジェクトが等価の場合{@code true}
	 */
	private boolean equals(StringResource one, StringResource another) {
		if (one == null) {
			return another == null;
		}
		return another != null && one.getId().equals(another.getId());
	}

	@Override
	public int hashCode() {
		int result = level != null ? level.hashCode() : 0;
		result = 31 * result + (stringResource != null ? stringResource.getId().hashCode() : 0);
		result = 31 * result + (option != null ? Arrays.hashCode(option) : 0);
		return result;
	}

	/**
	 * メッセージフォーマッタを取得する。
	 *
	 * @return メッセージフォーマッター
	 */
	private MessageFormatter getMessageFormatter() {
		final MessageFormatter formatter = SystemRepository.get("messageFormatter");
		return formatter == null ? DEFAULT_MESSAGE_FORMATTER : formatter;
	}
}
