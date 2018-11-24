package nablarch.core.log;

import nablarch.core.log.LogUtil.ObjectCreator;
import nablarch.core.util.ObjectUtil;
import nablarch.core.util.annotation.Published;

/**
 * ログ出力機能の全体を取りまとめるクラス。<br>
 * <br>
 * クラスローダ毎に設定で指定された{@link LoggerFactory}の生成、保持を行う。<br>
 * ログ出力機能の実装に依存する初期処理、終了処理、{@link Logger}の生成は{@link LoggerFactory}に委譲する。<br>
 * クラスローダ毎に{@link LoggerFactory}を保持するのは、クラスローダ階層により生じる問題に対応するためである。
 * <p/>
 * 使用する{@link LoggerFactory}は、プロパティファイルに設定する。<br>
 * プロパティファイルのパスは、システムプロパティを使用して、”nablarch.log.filePath”をキーにファイルパスを指定する。<br>
 * このファイルパスは、クラスパスとファイルシステム上のパスのどちらを指定しても良い。<br>
 * ファイルパスの指定方法は、{@link nablarch.core.util.FileUtil#getResource(String)}を参照すること。<br>
 * システムプロパティを指定しなかった場合は、クラスパス直下のlog.propertiesを使用する。<br>
 * プロパティファイルが存在しない場合は、例外を送出する。<br>
 * <p/>
 * ログの出力先によってはリソースの確保と解放が必要となるため、本クラスは初期処理と終了処理を行う。<br>
 * 初期処理は、初回の{@link Logger}の取得が行われるタイミングで本クラスが内部的に実行する。<br>
 * 終了処理は、フレームワーク側で実行するタイミングを判断できないので、
 * ログの出力要求を行うアプリケーション毎にアプリケーションの終了時に{@link #terminate()}メソッドを呼び出すこと。<br>
 * アプリケーションの終了時とは、例えばWebアプリケーションの場合であれば、
 * ServletContextListener#contextDestroyedメソッドが呼ばれるタイミングを想定している。
 * 
 * @author Kiyohito Itoh
 * @see nablarch.core.log.LoggerFactory
 * @see Logger
 */
public final class LoggerManager {

	/** 隠蔽コンストラクタ。 */
	private LoggerManager() {
	}

	/** LoggerFactoryを生成する{@link ObjectCreator} */
	private static final ObjectCreator<LoggerFactory> LOGGER_FACTORY_CREATOR = new ObjectCreator<LoggerFactory>() {
		public LoggerFactory create() {
			String filePath = System.getProperty("nablarch.log.filePath", "classpath:log.properties");
			LogSettings settings = new LogSettings(filePath);
			LoggerFactory loggerFactory = ObjectUtil
					.createInstance(settings.getRequiredProp("loggerFactory.className"));
			loggerFactory.initialize(settings);
			return loggerFactory;
		}
	};

	/**
	 * ログ出力の終了処理を行う。<br>
	 * <br>
	 * クラスローダに紐付く全てのオブジェクトを解放する。
	 * 
	 * @see nablarch.core.log.LoggerFactory#terminate()
	 */
	@Published(tag = "architect")
	public static void terminate() {
		LoggerFactory loggerFactory = LogUtil.removeObjectBoundToContextClassLoader(LOGGER_FACTORY_CREATOR);
		if (loggerFactory != null) {
			loggerFactory.terminate();
		}
		LogUtil.removeAllObjectsBoundToContextClassLoader();
	}

	/**
	 * ロガーを取得する。<br>
	 * <br>
	 * 指定されたクラスのFQCNを指定して{@link #get(String)}メソッドを呼び出す。
	 * 
	 * @param clazz ロガー名に使用するクラス。クラスのFQCNをロガー名に使用する。
	 * @return ロガー
	 */
	@Published
	public static Logger get(Class<?> clazz) {
		return get(clazz.getName());
	}

	/**
	 * ロガーを取得する。<br>
	 * <br>
	 * クラスローダに紐付く{@link LoggerFactory}から取得したロガーを返す。<br>
	 * <br>
	 * ロガー名に対応するロガーが見つからない場合は、何も処理しないロガーを返す。
	 * 
	 * @param name ロガー名
	 * @return ロガー
	 */
	@Published
	public static Logger get(String name) {
		LoggerFactory loggerFactory = LogUtil.getObjectBoundToClassLoader(LOGGER_FACTORY_CREATOR);
		return loggerFactory.get(name);
	}
}
