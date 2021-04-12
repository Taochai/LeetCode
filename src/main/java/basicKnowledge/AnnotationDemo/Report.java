package basicKnowledge.AnnotationDemo;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Reports.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    String value() default "";
}
