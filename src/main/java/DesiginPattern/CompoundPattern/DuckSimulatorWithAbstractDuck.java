package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 04/06/2017.
 */
public class DuckSimulatorWithAbstractDuck {
    void simulator(AbstractDuckFactory abstractDuckFactory) {
        Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
        Quackable redHeadDuck = abstractDuckFactory.createRedheadDuck();
        Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
        Quackable duckCall = abstractDuckFactory.createDuckCall();
        Quackable gooseAdapter = new GooseAdapter(new Goose());

        System.out.println("Duck Simulator: With Duck Factory");

        simulator(mallardDuck);
        simulator(redHeadDuck);
        simulator(rubberDuck);
        simulator(duckCall);
        simulator(gooseAdapter);

        System.out.println("The Ducks quacked " + QuackCounter.getNumberOfQuacks() + " times") ;

    }

    void simulator(Quackable duck) {
        duck.quack();
    }

    public static void main(String[] args) {
        DuckSimulatorWithAbstractDuck duckSimulator = new DuckSimulatorWithAbstractDuck();
        AbstractDuckFactory abstractDuckFactory = new DuckCounterFactory();
        duckSimulator.simulator(abstractDuckFactory);

    }
}
