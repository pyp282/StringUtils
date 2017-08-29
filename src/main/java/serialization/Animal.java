package serialization;

import java.io.Serializable;

/**
 * Created by bys on 16/07/2017.
 */
public class Animal{
    private int age;

    public Animal() {
        System.out.println("Parent Contractor is called");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
