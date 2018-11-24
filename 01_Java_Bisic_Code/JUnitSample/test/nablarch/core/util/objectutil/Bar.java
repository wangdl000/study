package nablarch.core.util.objectutil;

/**
 * {@link nablarch.core.util.ObjectUtilTest}で使用されるクラス。
 * (staticでない)プロパティbarを持つ({@link #setBaz(String)} )})。
 */
public class Bar {
	private String baz;

	public String getBaz() {
		return baz;
	}

	public void setBaz(String baz) {
		this.baz = baz;
	}
}
