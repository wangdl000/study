package nablarch.core.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Nablarchが後方互換性を維持するAPIであることを表すアノテーション。
 * <p/>
 * Nablarchが後方互換性を維持するAPIのことを公開APIと呼ぶ。<br/>
 * 本アノテーションを付けたAPIは、javadocにより仕様が公開される。<br/>
 * 本アノテーションをクラス宣言に付けた場合は、クラスのpublicなメンバが全て公開APIとなる。<br/>
 * 特定のメソッドのみを公開APIとする場合は、本アノテーションをメソッド宣言に付ける。<br/>
 *
 * @author Masayuki Fujikuma
 */
@Target({ ElementType.TYPE,
		ElementType.FIELD,
		ElementType.CONSTRUCTOR,
		ElementType.METHOD,
		ElementType.ANNOTATION_TYPE })
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Published {

	/**
	 * 対象となる読者を識別する用途に使用するタグ（複数指定可）。
	 * <p/>
	 * 例えば、アーキテクト向けに公開したい場合は、
	 * {@code @Published(tag = "architect")}というようにタグを付与する。<br/>
	 * カスタムドックレットでAPIドキュメント生成時に、
	 * 出力対象タグを明示的に指定することで、
	 * そのタグを持つAPIのみを公開することができる。<br/>
	 * この際、タグが指定されていないAPIも出力対象となる。
	 * つまり、タグが指定されていない公開APIと"architect"タグが指定された公開APIが出力される。
	 */
	String[] tag() default { "" };
}
