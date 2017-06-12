package DesiginPattern.CompoundPattern;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bys on 04/06/2017.
 */
public class Observable implements QuackObservable {
    List<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservsers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }

    }
}
