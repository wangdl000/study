package nablarch.fw;

import java.util.Map;

import nablarch.core.util.annotation.Published;

/**
 * リクエストを表すインタフェース。
 * 
 * @param <TParam> リクエストパラメータの型
 * @author Iwauo Tajima <iwauo@tis.co.jp>
 */
@Published
public interface Request<TParam> {
	/**
	 * リクエストパスを取得する。
	 * @return リクエストパス
	 */
	String getRequestPath();

	/**
	 * リクエストパスを設定する。
	 * @param requestPath リクエストパス
	 * @return オブジェクト自体
	 */
	Request<TParam> setRequestPath(String requestPath);

	/**
	 * リクエストパラメータを取得する。
	 *
	 * @param name パラメータ名
	 * @return パラメータの値
	 * @see #getParamMap()
	 */
	TParam getParam(String name);

	/**
	 * リクエストパラメータのMapを取得する。
	 *
	 * @return リクエストパラメータのMap
	 */
	Map<String, TParam> getParamMap();
}
