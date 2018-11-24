package nablarch.core.log.basic;

import nablarch.core.util.annotation.Published;

/**
 * ログレベルを表す列挙型。<br>
 * <br>
 * 本フレームワークにおけるログレベルは、FATAL>ERROR>WARN>INFO>DEBUG>TRACEの6段階とし、FATALからTRACEに向かって順にレベルが低くなる。<br>
 * <br>
 * レベルに応じた出力制御では、指定されたレベル以上のログを全て出力する。<br>
 * 例えば、WARNレベルが指定された場合は、FATALレベル,ERRORレベル,WARNレベルで出力を指示しているログのみ出力する。<br>
 * <br>
 * ログレベルの定義を下記に示す。<br>
 * 下記を参考にプロジェクト毎にログレベルの使用方法を決定すること。
 * <dl>
 * <dt>FATAL
 * <dd>アプリケーションの継続が不可能になる深刻な問題が発生したことを示す。<br>
 *     監視が必須で即通報および即対応が必要となる。<br>
 *     通常は、運用監視体制と密接に関わるため、個別アプリケーションではなくフレームワークで出力する。
 * <dt>ERROR
 * <dd>アプリケーションの継続に支障をきたす問題が発生したことを示す。<br>
 *     監視が必須であるが、通報および対応にFATALレベルほどの緊急性がない。<br>
 *     通常は、運用監視体制と密接に関わるため、個別アプリケーションではなくフレームワークで出力する。
 * <dt>WARN
 * <dd>すぐには影響を与えないが、放置しておくとアプリケーションの継続に支障をきたす問題になる恐れがある事象が発生したことを示す。<br>
 *     できれば監視した方がよいが、ERRORレベルほどの重要性がない。<br>
 *     通常は、運用監視体制と密接に関わるため、個別アプリケーションではなくフレームワークで出力する。
 * <dt>INFO
 * <dd>本番運用時にアプリケーションの情報を出力するログレベル。<br>
 *     アクセスログや統計ログが該当する。<br>
 *     通常は、運用監視体制と密接に関わるため、個別アプリケーションではなくフレームワークで出力する。<br>
 *     ログファイルのサイズが肥大化しないよう出力内容を設計する。
 * <dt>DEBUG
 * <dd>開発時にデバッグ情報を出力するログレベル。<br>
 *     SQLログや性能ログが該当する。<br>
 *     本番運用時は、ログファイルのサイズが肥大化するため出力してはならない。
 * <dt>TRACE
 * <dd>開発時にデバッグ情報より、さらに細かい情報を出力したい場合に使用するログレベル。<br>
 *     本番運用時は、ログファイルのサイズが肥大化するため出力してはならない。
 * </dl>
 * 
 * @author Kiyohito Itoh
 */
@Published(tag = "architect")
public enum LogLevel {

	/** 致命的なエラー */
	FATAL(0),

	/** エラー */
	ERROR(1),

	/** ワーニング */
	WARN(2),

	/** 情報 */
	INFO(3),

	/** デバッグ */
	DEBUG(4),

	/** トレース */
	TRACE(5);

	/** ログレベルの値 */
	private int value;

	/**
	 * コンストラクタ。
	 * @param value ログレベルの値
	 */
	LogLevel(int value) {
		this.value = value;
	}

	/**
	 * ログレベルの値を取得する。
	 * @return ログレベルの値
	 */
	public int getValue() {
		return value;
	}
}
