package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 03/06/2017.
 */
public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck( ) {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservsers();
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
