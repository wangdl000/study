package nablarch.core.repository;

import java.util.HashMap;
import java.util.Map;

import nablarch.core.util.annotation.Published;

/**
 * 設定値およびコンポーネントを保持するクラス。<br/>
 * アプリケーションの設定値の取得とコンポーネントを生成する責務は{@link ObjectLoader}を実装したクラスが持つ。
 * 
 * @author Koichi Asano 
 */
public final class SystemRepository {

	/**
	 * 隠蔽コンストラクタ。
	 */
	private SystemRepository() {

	}

	/**
	 * リポジトリに配置されたオブジェクトのMap。
	 */
	private static Map<String, Object> objects = new HashMap<String, Object>();

	/**
	 * ロードされたオブジェクトをクリアする。
	 */
	@Published(tag = "architect")
	public static void clear() {
		objects.clear();
	}

	/**
	 * {@link ObjectLoader}からオブジェクトをロードする。
	 * <p/>
	 * 本メソッドは、登録済みのオブジェクトに対して追加でロードを行う。
	 * よって、登録済みのオブジェクトは、再度本メソッドを起動してもクリアされない。
	 * <p/>
	 * 登録済みのオブジェクトと同名のオブジェクトを{@link ObjectLoader}からロードした場合上書きされる。
	 *
	 * @param loader オブジェクトローダ
	 */
	@Published(tag = "architect")
	public static void load(ObjectLoader loader) {
		for (Map.Entry<String, Object> entry : loader.load().entrySet()) {
			objects.put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * コンポーネント名を指定して、リポジトリに登録されたコンポーネントを取得する。
	 * 
	 * @param name コンポーネント名
	 * @return リポジトリに登録されたコンポーネント
	 */
	@Published
	public static Object getObject(String name) {
		return objects.get(name);
	}

	/**
	 * 設定値の登録名を指定してリポジトリに登録された文字列の設定値を取得する。
	 * 
	 * @param name 設定値の登録名
	 * @return リポジトリに登録された文字列設定値
	 * @throws ClassCastException
	 *     リポジトリに登録されたオブジェクトが、String型にキャストできない型であった場合
	 */
	@Published
	public static String getString(String name) {
		return (String) objects.get(name);
	}

	/**
	 * 設定値の登録名を指定してリポジトリに登録された真偽値の設定値を取得する。
	 * <p/>
	 * 以下の文字列と一致する設定値が登録されていた場合に「true」を返却する。大文字・小文字は区別しない。
	 * <ul>
	 *     <li>"true"</li>
	 *     <li>"on"</li>
	 *     <li>"yes"</li>
	 * </ul>
	 *
	 * @param name 設定値の登録名
	 * @return リポジトリに登録されたBoolean型の設定値
	 * @throws ClassCastException
	 *     リポジトリに登録されたオブジェクトが、String型にキャストできない型であった場合
	 */
	@Published
	public static boolean getBoolean(String name) {
		String value = (String) objects.get(name);
		return ("on".equalsIgnoreCase(value)
				|| "true".equalsIgnoreCase(value)
				|| "yes".equalsIgnoreCase(value));
	}

	/**
	 * リポジトリに登録されたコンポーネントを取得する。
	 *
	 * @param <T> 取得するコンポーネントの型
	 * @param name コンポーネント名
	 * @return コンポーネント コンポーネントが見つからなかった場合はnullを返却する
	 * @throws ClassCastException
	 *     型引数{@code <T>}が、リポジトリに登録されたコンポーネントの型と一致しなかった場合
	 */
	@SuppressWarnings("unchecked")
	@Published
	public static <T> T get(String name) throws ClassCastException {
		return (T) objects.get(name);
	}
}
