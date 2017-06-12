package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 04/06/2017.
 */
public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }
}
