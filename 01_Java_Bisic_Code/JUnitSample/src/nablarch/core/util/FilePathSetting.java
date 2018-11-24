package nablarch.core.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import nablarch.core.repository.SystemRepository;
import nablarch.core.util.annotation.Published;
import nablarch.core.util.map.CaseInsensitiveMap;

/**
 * ベースパスの論理名と物理パスとの対応を管理するクラス。 
 * 
 * @author Iwauo Tajima
 */
@Published(tag = "architect")
public class FilePathSetting {

	/** ベースパスの論理名と物理パスとの対応を収めたMap */
	private Map<String, URL> basePathSettings = new CaseInsensitiveMap<URL>();

	/** 
	 * ベースパスの論理名とデフォルト拡張子との対応を収めたMap。
	 * ベースパスに対応するデフォルトの拡張子を使用する場合は、 本プロパティの設定を行う。
	 */
	private Map<String, String> fileExtensions = new CaseInsensitiveMap<String>();

	/** システムリポジトリ上の登録名 */
	private static final String REPOSITORY_KEY = "filePathSetting";

	/**
	 * デフォルトのコンバータ設定情報保持クラスのインスタンス。
	 * リポジトリからインスタンスを取得できなかった場合に、デフォルトでこのインスタンスが使用される。
	 */
	private static final FilePathSetting DEFAULT_SETTING = new FilePathSetting();

	/**
	 * このクラスのインスタンスをリポジトリより取得する。
	 * リポジトリにインスタンスが存在しない場合は、デフォルトの設定で生成したこのクラスのインスタンスを返却する。
	 * @return このクラスのインスタンス
	 */
	public static FilePathSetting getInstance() {
		FilePathSetting setting = SystemRepository.get(REPOSITORY_KEY);
		if (setting == null) {
			return DEFAULT_SETTING;
		}
		return setting;
	}

	/**
	 * 指定されたベースパスの直下に存在するファイルの抽象パスを取得する。
	 * ファイルが存在しない場合は新たにファイルを作成してその抽象パスを返却する。
	 * 
	 * @param  basePathName ベースパスの論理名
	 * @param  fileName     取得するファイル名
	 * @return 抽象パス
	 * @throws IllegalArgumentException
	 *             指定されたベースパス論理名に対応する物理パスが
	 *             設定されていない場合
	 */
	public File getFile(String basePathName, String fileName)
			throws IllegalArgumentException {
		return resolvePath(basePathName, fileName, true);
	}

	/**
	 * 指定されたベースパスの直下に存在するファイルの抽象パスを取得する。
	 * その抽象パスを返却する。ファイルが存在しない場合はnullを返却する。
	 * 
	 * @param  basePathName ベースパスの論理名
	 * @param  fileName     取得するファイル名
	 * @return 抽象パス
	 * @throws IllegalArgumentException
	 *             指定されたベースパス論理名に対応する物理パスが
	 *             設定されていない場合
	 */
	public File getFileIfExists(String basePathName, String fileName)
			throws IllegalArgumentException {
		File resolved = resolvePath(basePathName, fileName, false);
		return resolved.exists() ? resolved : null;
	}

	/**
	 * 指定されたベースパスの直下に存在するファイルの抽象パスを取得する。
	 * 
	 * @param  basePathName ベースパスの論理名
	 * @param  fileName     取得するファイル名
	 * @return 抽象パス
	 * @throws IllegalArgumentException
	 *             指定されたベースパス論理名に対応する物理パスが
	 *             設定されていない場合
	 */
	public File getFileWithoutCreate(String basePathName, String fileName)
			throws IllegalArgumentException {
		return resolvePath(basePathName, fileName, false);
	}

	/**
	 * 指定されたベースパスの直下に存在するファイルの抽象パスを作成して返却する。
	 * 
	 * @param  basePathName ベースパスの論理名
	 * @param  fileName     取得するファイル名
	 * @param  createNew    指定したファイルが存在しない場合に新規ファイルを
	 *                       作成するかどうか。（作成する場合はtrue）
	 * @return 抽象パス
	 * @throws IllegalArgumentException
	 *             指定されたベースパス論理名に対応する物理パスが
	 *             設定されていない場合
	 */
	protected File resolvePath(String basePathName, String fileName, boolean createNew)
			throws IllegalArgumentException {
		URL basePathUrl = getBasePathUrl(basePathName);

		// ベースパスに対応する拡張子が存在するならば、引数のファイル名に拡張子を結合する
		String fileNameJoinExtension = getFileNameJoinExtension(basePathName, fileName);
		File file = new File(basePathUrl.getFile(), fileNameJoinExtension);
		if (!file.exists()) {
			if (!createNew) {
				return file;
			}
			try {
				if (!file.createNewFile()) {
					throw new RuntimeException(
							"Could not create new file at " + file.getAbsolutePath());
				}

			} catch (IOException e) {
				throw new RuntimeException(
						"Could not create new file at " + file.getAbsolutePath(), e);
			}
		}
		return file;
	}

	/**
	 * ベースパスのURLを取得する。
	 * @param basePathName ベースパスの論理名
	 * @return URL
	 */
	public URL getBasePathUrl(String basePathName) {
		URL basePathUrl = basePathSettings.get(basePathName);
		if (basePathUrl == null) {
			throw new IllegalArgumentException(
					"Unknown basePathName: " + basePathName);
		}
		return basePathUrl;
	}

	/**
	 * ベースディレクトリを取得する。
	 * @param basePathName ベースパスの論理名
	 * @return ベースディレクトリ
	 */
	public File getBaseDirectory(String basePathName) {
		URL url = getBasePathUrl(basePathName);
		File dir = new File(url.getFile());
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(
					"not a directory. basePathName:" + basePathName);
		}
		return dir;
	}

	/**
	 * ベースパスの論理名に対応する拡張子が存在する場合、ファイル名と拡張子を結合した文字列を返却する。
	 * 対応する拡張子が存在しない場合は、引数のファイル名をそのまま返却する。
	 * @param  basePathName ベースパスの論理名
	 * @param  fileName ファイル名
	 * @return ファイル名と拡張子を結合した文字列
	 */
	protected String getFileNameJoinExtension(String basePathName, String fileName) {

		if (!fileExtensions.containsKey(basePathName)) {
			return fileName;
		}

		return fileName + "."
				+ fileExtensions.get(basePathName);
	}

	/**
	 * ベースパスの論理名と物理パスとの対応を収めたMapを設定する。
	 * @param basePathSettings ベースパスの論理名と物理パス（URLで指定）との対応を収めたMap
	 * @return このクラス自体のインスタンス
	 */
	public FilePathSetting setBasePathSettings(Map<String, String> basePathSettings) {
		for (Map.Entry<String, String> entry : basePathSettings.entrySet()) {
			addBasePathSetting(entry.getKey(), entry.getValue());
		}
		return this;
	}

	/**
	 * ベースパスの設定を追加する。
	 * <p/>
	 * ベースパスにはディレクトリのみ指定できる。ディレクトリでない場合、例外をスローする。
	 * <p/>
	 * ベースパスはURLで指定すること。URLを使用して、ファイルシステムとクラスパス上のリソースを指定することができる。<br/>
	 * URLのフォーマットは下記の通りである。
	 * <pre>
	 *     &lt;スキーム名&gt;:&lt;リソースのパス&gt;
	 *
	 *     スキーム名:
	 *         ファイルパスの場合 "file"
	 *         クラスパスの場合 "classpath"
	 * </pre>
	 * URLの指定例を下記に示す。<br>
	 * <pre>
	 *     ファイルパスの場合
	 *         "file:./main/format"
	 *
	 *     クラスパスの場合
	 *         "classpath:web/format"
	 * </pre>
	 * ベースパスにクラスパスを指定する場合、そのパスにはディレクトリが存在している必要がある。ディレクトリが存在しない場合は、例外をスローする。
	 * <p/>
	 * ベースパスにファイルパスを指定する場合、そのパスにディレクトリが存在していなければ、本メソッド内でディレクトリを作成する。
	 * 
	 * @param basePathName ベースパスの論理名
	 * @param path ベースパス（URLで指定）
	 * @return このクラス自体のインスタンス
	 */
	public FilePathSetting addBasePathSetting(String basePathName, String path) {

		URL baseDirUrl = FileUtil.getResourceURL(path);

		// パスの参照先が実在しない。
		// もしくは、JARアーカイブ内のディレクトリである。
		if (baseDirUrl == null) {
			throw new IllegalStateException(
					"invalid base path was specified. the assigned path couldn't be found "
							+ "or was inside in a JAR archive."
							+ getAddBasePathExceptionMessage(basePathName, path));
		}

		// パスの参照先がJARアーカイブ内のリソースであった場合。
		if (baseDirUrl.toString().startsWith("jar:")) {
			throw new IllegalStateException(
					"invalid base path was specified. a base path can not be a JAR interior path."
							+ getAddBasePathExceptionMessage(basePathName, path));
		}

		File baseDir = new File(baseDirUrl.getFile());

		if (baseDir.exists() && !baseDir.isDirectory()) {
			throw new IllegalStateException(
					Builder.concat("invalid base path was specified. base path was not directory. ",
							"absolute path of the base path=[", baseDir.getAbsoluteFile(), "], ",
							getAddBasePathExceptionMessage(basePathName, path)));
		}
		if (!baseDir.exists() && !baseDir.mkdirs()) {
			throw new IllegalStateException(
					Builder.concat("couldn't create the base directory. ", "absolute path of the directory path=[",
							baseDir.getAbsolutePath(), "], ", getAddBasePathExceptionMessage(basePathName, path)));
		}
		basePathSettings.put(basePathName, baseDirUrl);
		return this;
	}

	/**
	 * ベースパスを追加する際に発生する例外メッセージの共通部を取得する。
	 * @param basePathName ベースパスの論理名
	 * @param path ベースパス
	 * @return ベースパスが不正な場合の例外メッセージの共通部
	 */
	private static String getAddBasePathExceptionMessage(String basePathName, String path) {
		return Builder.concat("base path=[", path, "], base path name=[", basePathName, "].");
	}

	/**
	 * ベースパスの論理名に対応する拡張子を追加する。
	 * @param name ベースパスの論理名
	 * @param extension ベースパスの論理名に対応する拡張子
	 * @return このクラス自体のインスタンス
	 */
	public FilePathSetting addFileExtensions(String name, String extension) {
		fileExtensions.put(name, extension);
		return this;
	}

	/**
	 * ベースパスの論理名と物理パスとの対応を収めたMapを取得する。
	 * @return ベースパスの論理名と物理パスとの対応を収めたMap
	 */
	public Map<String, URL> getBasePathSettings() {
		return basePathSettings;
	}

	/**
	 * ベースパスの論理名と拡張子との対応を収めたMapを取得する。
	 * @return ベースパスの論理名とデフォルト拡張子との対応を収めたMap
	 */
	public Map<String, String> getFileExtensions() {
		return fileExtensions;
	}

	/**
	 * ベースパスの論理名と拡張子との対応を収めたMapを設定する。
	 * @param fileExtensions ベースパスの論理名とデフォルト拡張子との対応を収めたMap
	 */
	public void setFileExtensions(Map<String, String> fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

}
