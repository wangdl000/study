package nablarch.core.repository;

import java.util.Map;

import nablarch.core.util.annotation.Published;

/**
 * {@link SystemRepository}に保持するオブジェクトを読み込むインタフェース。
 * 
 * @author Koichi Asano 
 *
 */
@Published(tag = "architect")
public interface ObjectLoader {
	/**
	 * {@link SystemRepository}に登録するオブジェクトを読み込む。<br/>
	 * キーがオブジェクトの名前、Valueを読み込むオブジェクトであるMapを作成し、返却する。
	 *
	 * @return キーがオブジェクトの名前、Valueが読み込むオブジェクトであるMap。
	 */
	Map<String, Object> load();
}
