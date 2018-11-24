package nablarch.fw;

import java.util.ArrayList;
import java.util.List;

import nablarch.core.util.annotation.Published;

/**
 * ハンドラでの処理結果を表すインターフェース。
 *
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
@Published(tag = "architect")
public interface Result {
	//------------------------------------------------- interface definition
	/**
	 * ステータスコードを返す。
	 *
	 * @return ステータスコード
	 */
	int getStatusCode();

	/**
	 * 処理結果に関する詳細情報を返す。
	 *
	 * @return 詳細情報
	 */
	String getMessage();

	/**
	 * 処理が正常終了したかどうかを返す。
	 * @return 正常終了した場合は{@code true}
	 */
	@Published
	boolean isSuccess();

	// ------------------------------------------------ Success (2xx)
	/** ハンドラの処理が正常終了したことを表す。 */
	public static class Success implements Result {

		/** デフォルトコンストラクタ。 */
		@Published
		public Success() {
			this(DEFAULT_MESSAGE);
		}

		/**
		 * コンストラクタ。
		 *
		 * @param message メッセージ
		 */
		public Success(String message) {
			this.message = message;
		}

		/** メッセージ内容 */
		private final String message;

		/** デフォルトメッセージ */
		private static final String DEFAULT_MESSAGE = "The request has succeeded.";

		/** {@inheritDoc} */
		public int getStatusCode() {
			return 200;
		}

		/** {@inheritDoc} */
		public String getMessage() {
			return message;
		}

		/** {@inheritDoc} 
		 * この実装では、以下の文字列を返す。
		 * <pre>
		 *   "[" + (ステータスコード) + (結果クラス名) + "]" + (メッセージ内容)
		 * </pre>
		 */
		@Override
		public String toString() {
			return "[" + getStatusCode() + " "
					+ getClass().getSimpleName()
					+ "] " + getMessage();
		}

		/** {@inheritDoc}
		 * このクラスは正常終了を表すのでtrueを返す。
		 */
		public boolean isSuccess() {
			return true;
		}
	}

	/**
	 * 処理結果が複数のステータスを含んでいることを表す。
	 * <p/>
	 * これは、バッチ処理やアップロード処理のように、
	 * 1つのリクエストに対して複数の処理が実行される場合に返される。
	 * 個々の処理結果には、エラー結果(4xx/5xx)が含まれうる。
	 */
	@Published(tag = "architect")
	public static class MultiStatus extends Success {

		/** デフォルトコンストラクタ。 */
		public MultiStatus() {
			super(DEFAULT_MESSAGE);
		}

		/**
		 * コンストラクタ。
		 *
		 * @param message メッセージ
		 */
		public MultiStatus(String message) {
			super(message);
		}

		/** デフォルトメッセージ */
		private static final String DEFAULT_MESSAGE = "The result of your request has multiple status. "
				+ "Please consult following messages.";

		/** {@inheritDoc} */
		public int getStatusCode() {
			return 207;
		}

		/**
		 * 処理結果のリストを取得する。
		 *
		 * @return 処理結果のリスト
		 */
		public List<Result> getResults() {
			return this.results;
		}

		/**
		 * 処理結果を追加する。
		 *
		 * @param results 追加する処理結果。
		 * @return このオブジェクト自体。
		 */
		public MultiStatus addResults(Result... results) {
			for (Result result : results) {
				this.results.add(result);
			}
			return this;
		}

		/** 処理結果のリスト */
		private final List<Result> results = new ArrayList<Result>();

		/** {@inheritDoc}
		 * <p/>
		 * 本クラスの実装では、このオブジェクトが内包する全ての
		 * 処理結果オブジェクトが正常終了であった場合にtrueを返し、
		 * 1つでも異常終了しているものがあれば falseを返す。
		 */
		@Override
		public boolean isSuccess() {
			for (Result eachResult : results) {
				if (!eachResult.isSuccess()) {
					return false;
				}
			}
			return true;
		}
	}

	// ------------------------------------------------ Error status (4xx/5xx)
	/**
	 * ハンドラの処理が異常終了したことを示す実行時例外。
	 * <p/>
	 * 本クラスの具象クラスは以下の3つに類別することができる。
	 * <pre>
	 * 1. Result.ClientError (ステータスコード:4xx)
	 *   呼び出し側に起因する問題によりエラー終了したことを表す実行時例外。
	 *   入力値のバリデーションエラー、認証認可エラーなどがこれに属し、
	 *   ユーザ側の再試行により処理継続が見込める場合に使用する。
	 *   ハンドラ側から見れば正常系であるため、障害ログ出力を行う必要は無い。
	 * 
	 * 2. Result.InternalError (ステータスコード:500)
	 *   ハンドラ側の内部処理に起因する未知の問題(バグやインフラレベルの障害など)
	 *   によって異常終了したことを表す実行時例外。
	 *   NullPointerException等の一般実行時例外/Errorと同等の扱いとなり、
	 *   エラーハンドラにより障害ログの出力が行われる。
	 *   
	 * 3. Result.Unavailable (ステータスコード:503)
	 *   システム側の処理受付が一時的に停止した状態であることを示す実行時例外。
	 *   閉局エラーがこれに属する。システム閉局時の挙動は、各実行基盤ごとの
	 *   運用設計に依存するものなので、各実行基盤ごとのエラーハンドラで個別に制御される。
	 *   グローバルエラーハンドラまで到達した場合は、障害ログの出力が行われる。
	 * </pre>
	 */
	@Published(tag = "architect")
	public abstract static class Error extends RuntimeException
			implements Result {
		/**
		 * デフォルトコンストラクタ
		 */
		public Error() {
			super();
		}

		/**
		 * コンストラクタ
		 * @param message エラーメッセージ
		 */
		public Error(String message) {
			super(message);
		}

		/**
		 * コンストラクタ
		 * @param cause 起因となる例外
		 */
		public Error(Throwable cause) {
			super(cause);
		}

		/**
		 * コンストラクタ
		 * @param message エラーメッセージ
		 * @param cause   起因となる例外
		 */
		public Error(String message, Throwable cause) {
			super(message, cause);
		}

		/** {@inheritDoc} */
		public int getStatusCode() {
			return 500;
		}

		/** {@inheritDoc} 
		 * この実装では、以下の文字列を返す。
		 * <pre>
		 *   "[" + (ステータスコード) + (結果クラス名) + "]" + (メッセージ内容)
		 * </pre>
		 */
		@Override
		public String toString() {
			return "[" + getStatusCode() + " "
					+ getClass().getSimpleName()
					+ "] " + getMessage();
		}

		/** {@inheritDoc}
		 * このクラスは異常結果を表すので、falseを返す。
		 */
		public boolean isSuccess() {
			return false;
		}
	}

	// ------------------------------------------------ Client errors (4xx)
	/**
	 * サービス呼出側に起因すると思われる問題により、処理が継続できないことを示す例外。
	 * <p/>
	 * 問題解決には、呼び出し側による対処が必要となるので、エラーメッセージの
	 * 内容として、呼び出し側に要求する対処の内容を明記する必要がある。
	 */
	@Published(tag = "architect")
	public abstract static class ClientError extends Error {
		/**
		 * デフォルトコンストラクタ
		 */
		public ClientError() {
			super();
		}

		/**
		 * コンストラクタ
		 * @param message エラーメッセージ
		 */
		public ClientError(String message) {
			super(message);
		}

		/**
		 * コンストラクタ
		 * @param cause 起因となる例外
		 */
		public ClientError(Throwable cause) {
			super(cause);
		}

		/**
		 * コンストラクタ
		 * @param message エラーメッセージ
		 * @param cause   起因となる例外
		 */
		public ClientError(String message, Throwable cause) {
			super(message, cause);
		}

		/** {@inheritDoc} */
		public int getStatusCode() {
			return 400;
		}
	}

	/**
	 * 要求されたリソースが存在しないため、
	 * 処理を継続することができないことを示す例外。
	 */
	@Published(tag = "architect")
	public static class NotFound extends ClientError {
		/**
		 * デフォルトコンストラクタ
		 */
		public NotFound() {
			this(DEFAULT_MESSAGE);
		}

		/**
		 * コンストラクタ
		 * @param message エラーメッセージ
		 */
		public NotFound(String message) {
			super(message);
		}

		/**
		 * コンストラクタ
		 * @param cause 起因となる例外
		 */
		public NotFound(Throwable cause) {
			super(cause);
		}

		/**
		 * コンストラクタ
		 * @param message エラーメッセージ
		 * @param cause   起因となる例外
		 */
		public NotFound(String message, Throwable cause) {
			super(message, cause);
		}

		/** デフォルトメッセージ */
		private static final String DEFAULT_MESSAGE = "There was no resources matching your request.";

		/** {@inheritDoc} */
		public int getStatusCode() {
			return 404;
		}
	}

}
