package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 03/06/2017.
 */
public class GooseAdapter implements Quackable {
    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void notifyObservsers() {

    }

    @Override
    public void registerObserver(Observer observer) {

    }
}
