package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bys on 20/06/2017.
 */
public class NewFeatures {
    public static void lambdaDemo() {
        List<String> names = Arrays.asList("peter", "mike", "xenia", "anna");

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

    }


}
