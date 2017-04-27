package annotation;

import javax.print.DocFlavor;
import javax.xml.bind.annotation.XmlAnyElement;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnotation {

    String value() default "unknow";

}

class Person {

    @MyAnotation(value = "java")
    public void empty(){
        System.out.println("empty");
    }

    @MyAnotation
    @XmlAnyElement
    public void somebody(String name, int age){
        System.out.println("somebody'information: " + name + age);
    }
}
