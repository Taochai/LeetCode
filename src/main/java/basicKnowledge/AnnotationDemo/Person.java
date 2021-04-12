package basicKnowledge.AnnotationDemo;

@Report
public class Person {
    public static void main(String[] args) {
        Person person = new Person();
        boolean annotationPresent = person.getClass().isAnnotationPresent(Report.class);
        System.out.println(annotationPresent);
        System.out.println(Person.class.isAnnotationPresent(Report.class));
        Report annotation = Person.class.getAnnotation(Report.class);
        System.out.println(annotation);
    }
}
