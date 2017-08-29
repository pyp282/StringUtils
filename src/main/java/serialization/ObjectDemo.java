package serialization;

import java.io.*;

/**
 * Created by bys on 16/07/2017.
 */
public class ObjectDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog = new Dog();
        dog.setAge(4);
        dog.setName("Alalala");
        dog.setPet("Pettinggggggggggg");

        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/bys/Documents/JavaData/Projects/dog.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(dog);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream(new File("/Users/bys/Documents/JavaData/Projects/dog.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        Dog two = (Dog)object;

        objectInputStream.close();
        fileInputStream.close();

        System.out.println("two.getAge(): " + two.getAge());
        System.out.println("two.getName(): " + two.getName());
        System.out.println(dog.getPet());


    }
}
