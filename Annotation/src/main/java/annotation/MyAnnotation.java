package annotation;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int value() default 0;
    String name() default "jerry";
}
