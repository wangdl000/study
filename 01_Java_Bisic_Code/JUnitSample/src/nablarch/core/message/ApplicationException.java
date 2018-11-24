package nablarch.core.message;

import java.util.ArrayList;
import java.util.List;

import nablarch.core.util.annotation.Published;

/**
 * 業務エラーが発生した際のメッセージ通知に使用する例外クラス。
 * <p/>
 * 本クラスは内部に処理結果メッセージ（{@link Message}）のリストを保持する。
 * 
 * @author Koichi Asano
 *
 */
@Published
public class ApplicationException extends RuntimeException {

	/**
	 * 処理結果メッセージのリスト。
	 */
	private List<Message> messages;

	/**
	 * ApplicationExceptionオブジェクトを生成する。
	 */
	public ApplicationException() {
		messages = new ArrayList<Message>();
	}

	/**
	 * 指定した処理結果メッセージを保持するApplicationExceptionオブジェクトを生成する。
	 * 
	 * @param message 処理結果メッセージ
	 */
	public ApplicationException(Message message) {

		this.messages = new ArrayList<Message>();
		this.messages.add(message);
	}

	/**
	 * 指定した処理結果メッセージのリストを保持するApplicationExceptionオブジェクトを生成する。
	 * 
	 * @param messages 処理結果メッセージのリスト
	 */
	public ApplicationException(List<Message> messages) {
		this.messages = new ArrayList<Message>();
		this.messages.addAll(messages);
	}

	/**
	 * 処理結果メッセージを追加する。
	 * 
	 * @param message 処理結果メッセージ
	 */
	public void addMessages(Message message) {
		this.messages.add(message);
	}

	/**
	 * 処理結果メッセージを追加する。
	 * 
	 * @param messages 処理結果メッセージのリスト
	 */
	public void addMessages(List<Message> messages) {
		this.messages.addAll(messages);
	}

	/**
	 * 処理結果メッセージのリストを取得する。
	 * 
	 * @return 処理結果メッセージのリスト
	 */
	public List<Message> getMessages() {
		return messages;
	}

	@Override
	public String getMessage() {
		StringBuilder builder = new StringBuilder();

		for (Message message : messages) {
			builder.append(message.formatMessage() + '\n');
		}
		return builder.toString();
	}
}
