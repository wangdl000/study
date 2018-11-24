package nablarch.core.repository.initialization;

import nablarch.core.util.annotation.Published;

/**
 * 初期化処理を行うインタフェース。<br>
 * 初期化処理を必要とするクラスは本インタフェースを実装すること。
 *
 * @author Hisaaki Sioiri
 */
@Published(tag = "architect")
public interface Initializable {

	/**
	 * 初期化処理を行う。
	 */
	void initialize();
}
