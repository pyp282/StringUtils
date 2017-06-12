package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 03/06/2017.
 */
public class QuackCounter implements Quackable {
    Observable observable;
    Quackable duck;
    static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
        this.observable = new Observable(this);
    }


    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
        notifyObservsers();
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservsers() {
        observable.notifyObservsers();
    }
}
