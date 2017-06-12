package DesiginPattern.CompoundPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bys on 04/06/2017.
 */
public class Flock implements Quackable {
    List quackers = new ArrayList();

    public void add(Quackable duck) {
        quackers.add(duck);
    }
    @Override
    public void quack() {
        for (Object quacker : quackers) {
            Quackable quackable = (Quackable) quacker;
            quackable.quack();
        }

    }
}
