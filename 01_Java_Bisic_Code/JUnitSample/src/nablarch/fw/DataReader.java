package nablarch.fw;

import nablarch.core.util.annotation.Published;
import nablarch.fw.Result.NotFound;

/**
 * {@link Handler}が処理する入力データを外部から読み込むインタフェース。
 * <p/>
 * データリーダは複数のリクエストスレッドから並行アクセスされ得るので、
 * 各メソッドはスレッドセーフに実装されなければならない。
 *
 * @param <TData> このクラスが読み込んだデータの型
 *
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
@Published(tag = "architect")
public interface DataReader<TData> {
	/**
	 * {@link Handler}が処理する入力データを読み込んで返却する。
	 * <p/>
	 * 入力データがこれ以上存在しない状態、すなわち、hasNext()の結果が{@code false}となる
	 * 状態でこのメソッドを呼んだ場合の結果は不定である。
	 *
	 * @param ctx 実行コンテキスト
	 * @return 入力データオブジェクト
	 */
	TData read(ExecutionContext ctx);

	/**
	 * 次に読み込むデータが存在するかどうかを返却する。
	 *
	 * @param ctx 実行コンテキスト
	 * @return 次に読み込むデータが存在する場合は{@code true}
	 */
	boolean hasNext(ExecutionContext ctx);

	/**
	 * このリーダの利用を停止し、内部的に保持している各種リソースを解放する。
	 *
	 * @param ctx 実行コンテキスト
	 */
	void close(ExecutionContext ctx);

	/**
	 * これ以上読み取るデータが無いことを示す例外。
	 */
	@Published(tag = "architect")
	class NoMoreRecord extends NotFound {

		/**
		 * {@code NoMoreRecord}オブジェクトを生成する。
		 */
		public NoMoreRecord() {
			super("all data has been processed.");
		}
	}
}
