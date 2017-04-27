package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunAnnotation {

    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Method somebody = Person.class.getMethod("somebody", String.class, int.class);
        somebody.invoke(person, "lily", 23);

        boolean present = somebody.isAnnotationPresent(MyAnotation.class);
        System.out.println(present);

        String value = somebody.getAnnotation(MyAnotation.class).value();
        System.out.println(value);

        somebody.getAnnotation(MyAnotation.class).value();

        Annotation[] annotations = somebody.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }

        Method empty = Person.class.getMethod("empty");
        empty.invoke(person);

        
    }
}
