package com.commodity.gift_order.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract public class BaseException extends Exception {

	/**
	 * シリアルバージョンUID
	 */
	private static final long serialVersionUID = -1633391377983662177L;

	/**
	 * メッセージ
	 */
	private List<ExceptionMessage> messages = new ArrayList<ExceptionMessage>();

	/**
	 * エラー
	 */
	private List<ExceptionMessage> errors = new ArrayList<ExceptionMessage>();

	/**
	 * フィールドエラー
	 */
	private List<ExceptionFieldMessage> fieldErrors = new ArrayList<ExceptionFieldMessage>();

	/**
	 * デフォルトコンストラクタ
	 */
	public BaseException() {
	}

	/**
	 * エラーのメッセージIDを取るコンストラクタ。
	 *
	 * @param msgId
	 */
	public BaseException(String msgId) {

		this.addExceptionError(msgId, null);

	}

	/**
	 * エラーのメッセージIDとメッセージ引数を取るコンストラクタ。
	 *
	 * @param msgId
	 * @param msgArgs
	 */
	public BaseException(String msgId, String msgArg) {

		this.addExceptionError(msgId, new String[] { msgArg });

	}

	/**
	 * エラーのメッセージIDとメッセージ引数を取るコンストラクタ。
	 *
	 * @param msgId
	 * @param msgArgs
	 */
	public BaseException(String msgId, String[] msgArgs) {

		this.addExceptionError(msgId, msgArgs);

	}

	/**
	 * メッセージに要素があるか？
	 *
	 * @param col
	 * @return
	 */
	private boolean hasMessage(Collection<?> col) {
		if (col == null || col.size() <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * メッセージがあるか？
	 *
	 * @return
	 */
	public boolean hasExceptionMessages() {
		return this.hasMessage(this.messages);
	}

	/**
	 * エラーがあるか？
	 *
	 * @return
	 */
	public boolean hasExceptionErrors() {
		return this.hasMessage(this.errors);
	}

	/**
	 * フィールドエラーがあるか？
	 *
	 * @return
	 */
	public boolean hasExceptionFieldErrors() {
		return this.hasMessage(this.fieldErrors);
	}

	/**
	 *
	 * @param anErrorMessage
	 */
	public void addExceptionError(String msgId, String[] msgArgs) {

		this.errors.add(new ExceptionMessage(msgId, msgArgs));

	}

	/**
	 *
	 * @param aMessage
	 */
	public void addActionMessage(String msgId, String[] msgArgs) {
		this.messages.add(new ExceptionMessage(msgId, msgArgs));
	}

	/**
	 *
	 * @param fieldName
	 * @param errorMessage
	 */
	public void addFieldError(String fieldName, String msgId, String[] msgArgs) {
		this.fieldErrors.add(new ExceptionFieldMessage(fieldName, msgId, msgArgs));
	}

	/**
	 * @return messages
	 */
	public List<ExceptionMessage> getMessages() {
		return messages;
	}

	/**
	 * @return errors
	 */
	public List<ExceptionMessage> getErrors() {
		return errors;
	}

	/**
	 * @return fieldErrors
	 */
	public List<ExceptionFieldMessage> getFieldErrors() {
		return fieldErrors;
	}

	/**
	 * 内部保持用メッセージクラス
	 *
	 * @author 22899367
	 *
	 */
	public class ExceptionMessage {

		public ExceptionMessage(String msgId, String[] msgArgs) {
			this.msgId = msgId;
			this.msgArgs = msgArgs;
		}

		private String msgId;
		private String[] msgArgs;

		/**
		 * @return msgId
		 */
		public String getMsgId() {
			return msgId;
		}

		/**
		 * @param msgId セットする msgId
		 */
		public void setMsgId(String msgId) {
			this.msgId = msgId;
		}

		/**
		 * @return msgArgs
		 */
		public String[] getMsgArgs() {
			return msgArgs;
		}

		/**
		 * @param msgArgs セットする msgArgs
		 */
		public void setMsgArgs(String[] msgArgs) {
			this.msgArgs = msgArgs;
		}

	}

	/**
	 * 内部保持用フィールドメッセージ
	 *
	 * @author 22899367
	 *
	 */
	public class ExceptionFieldMessage extends ExceptionMessage {

		public ExceptionFieldMessage(String fieldName, String msgId, String[] msgArgs) {

			super(msgId, msgArgs);
			this.fieldName = fieldName;

		}

		private String fieldName;

		/**
		 * @return fieldName
		 */
		public String getFieldName() {
			return fieldName;
		}

		/**
		 * @param fieldName セットする fieldName
		 */
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

	}

}
