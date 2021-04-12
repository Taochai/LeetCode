package basicKnowledge.AnnotationDemo;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Reports {
    Report[] value();
}
