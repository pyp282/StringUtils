package DesiginPattern.CompoundPattern;


/**
 * Created by bys on 04/06/2017.
 */
public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservsers();
}
