package reflection;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tikitoo on 2015/12/7.
 */


@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    public String name();

    public String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotationMethod {
    public String name();

    public String value();
}

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.CLASS)
@interface MethodInfo {
    String author() default "tikitoo";
    String date();
    int revision() default 1;
    String comments();
}



