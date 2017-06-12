package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 04/06/2017.
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + "just quacked!");
    }
}
