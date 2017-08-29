package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 03/06/2017.
 */
public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }

    @Override
    public void notifyObservsers() {

    }

    @Override
    public void registerObserver(Observer observer) {

    }
}
