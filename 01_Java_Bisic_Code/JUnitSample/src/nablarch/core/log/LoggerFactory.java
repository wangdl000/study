package nablarch.core.log;

import nablarch.core.util.annotation.Published;

/**
 * {@link Logger}を生成するインタフェース。<br>
 * <br>
 * ログ出力機能の実装毎に本インタフェースの実装クラスを作成する。<br>
 * <br>
 * LoggerFactoryは、{@link LoggerManager}により生成、管理される。<br>
 * {@link LoggerManager}は、初期処理においてLoggerFactoryの生成後に{@link #initialize(LogSettings)}メソッド、
 * 終了処理においてLoggerFactoryを破棄する際に{@link #terminate()}メソッドをそれぞれ1度だけ呼び出すので、
 * LoggerFactoryの初期処理と終了処理は複数スレッドから呼ばれることはない。
 * 
 * @author Kiyohito Itoh
 * @see LoggerManager
 */
@Published(tag = "architect")
public interface LoggerFactory {

	/**
	 * 初期処理を行う。<br>
	 * <br>
	 * ログの出力先に応じたリソースの確保などを行う。
	 * 
	 * @param settings ログ出力の設定
	 */
	void initialize(LogSettings settings);

	/**
	 * 終了処理を行う。<br>
	 * <br>
	 * ログの出力先に応じて確保しているリソースの解放などを行う。
	 */
	void terminate();

	/**
	 * {@link Logger}を取得する。<br>
	 * <br>
	 * {@link Logger}名に対応する{@link Logger}が見つからない場合は、何も処理しない{@link Logger}を返し、
	 * nullを返したり、例外を送出しないこと。
	 * 
	 * @param name {@link Logger}名
	 * @return {@link Logger}名に対応する{@link Logger}
	 */
	Logger get(String name);
}
