package nablarch.core.repository;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * プロパティに対する値の設定を無視することを示すアノテーション。
 * <p>
 * このアノテーションが設定されたプロパティは、機能変更時などに廃止されたことを意味する。
 * このため、このアノテーションが設定されたプロパティに対して、何か値を設定したとしてもその値が動作上影響をあたえることはない。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
public @interface IgnoreProperty {

	/** メッセージ(廃止された理由) */
	String value() default "";
}
