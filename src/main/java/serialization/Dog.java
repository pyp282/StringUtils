package serialization;

import java.io.Serializable;

/**
 * Created by bys on 16/07/2017.
 */
public class Dog extends Animal implements Serializable{
    private String name;
    private static String pet;

    public static String getPet() {
        return pet;
    }

    public static void setPet(String pet) {
        Dog.pet = pet;
    }

    public Dog() {
        System.out.println("Child contractor is called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
