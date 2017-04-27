package EnCoding;

import java.nio.charset.Charset;

/**
 * Created by bys on 02/04/2017.
 */
public class EnCodingDemo {
    public static void main(String[] args) {
        System.out.println("JDK version:" + System.getProperty("java.version"));
        System.out.println("Default Charset:" + Charset.defaultCharset());
    }
}
