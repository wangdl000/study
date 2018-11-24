package nablarch.core.util.objectutil;

/**
 * {@link nablarch.core.util.ObjectUtilTest}で使用されるクラス。
 * staticなプロパティbarを持つ({@link #setBar(Bar)})。
 */
public class Foo {

	private static Bar bar;

	public static Bar getBar() {
		return bar;
	}

	public static void setBar(Bar bar) {
		Foo.bar = bar;
	}

}