package nablarch.core.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import nablarch.core.util.FileUtil;
import nablarch.core.util.annotation.Published;

/**
 * ログ出力機能の設定をロードして保持するクラス。
 * @author Kiyohito Itoh
 */
@Published(tag = "architect")
public class LogSettings {

	/** プロパティファイルのファイルパス */
	private String filePath;

	/** 設定内容 */
	private Map<String, String> props;

	/**
	 * コンストラクタ。
	 * @param filePath プロパティファイルのファイルパス
	 */
	public LogSettings(String filePath) {
		this.filePath = filePath;
		this.props = loadSettings(filePath);
	}

	/**
	 * プロパティファイルのファイルパスを取得する。
	 * @return プロパティファイルのファイルパス
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 全てのプロパティを取得する。
	 * @return 全てのプロパティ
	 */
	public Map<String, String> getProps() {
		return props;
	}

	/**
	 * プロパティファイルを読み込み、設定をロードする。<br>
	 * ロード後、システムプロパティの値で設定を上書きする。
	 * 
	 * @param filePath ファイルパス
	 * @return 設定
	 */
	protected Map<String, String> loadSettings(String filePath) {
		InputStream inStream = FileUtil.getResource(filePath);
		Properties props = new Properties();
		try {
			props.load(inStream);
		} catch (IOException e) {
			throw new IllegalArgumentException("failed to load the file. file path = [" + filePath + "]", e);
		} finally {
			FileUtil.closeQuietly(inStream);
		}

		Map<String, String> trimmedProps = trim(props);
		trimmedProps.putAll(trim(System.getProperties()));

		return trimmedProps;
	}

	/**
	 * プロパティのキーと値をトリミングする。
	 * @param props プロパティ
	 * @return トリミング後のプロパティ
	 */
	protected Map<String, String> trim(Properties props) {
		Map<String, String> trimmedProps = new HashMap<String, String>(props.size());
		for (Map.Entry<Object, Object> prop : props.entrySet()) {
			String key = prop.getKey().toString();
			String value = prop.getValue().toString();
			trimmedProps.put(key.trim(), value.trim());
		}
		return trimmedProps;
	}

	/**
	 * 必須プロパティを取得する。
	 * @param propName プロパティ名
	 * @return プロパティ値
	 * @throws IllegalArgumentException プロパティが存在しない場合
	 */
	public String getRequiredProp(String propName) throws IllegalArgumentException {
		String propValue = getProps().get(propName);
		if (propValue == null || propValue.length() == 0) {
			throw new IllegalArgumentException(
					"'" + propName + "' was not specified. file path = [" + getFilePath() + "]");
		}
		return propValue;
	}
}
