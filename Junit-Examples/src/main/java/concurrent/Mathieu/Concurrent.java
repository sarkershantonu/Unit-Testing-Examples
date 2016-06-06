package concurrent.Mathieu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Original posts : https://dzone.com/articles/concurrent-junit-tests
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Concurrent {
	 int threads() default 5;
}
