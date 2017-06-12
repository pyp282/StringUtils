package DesiginPattern.CompoundPattern;

/**
 * Created by bys on 03/06/2017.
 */
public class DuckSimulator {
    void simulator(Quackable duck) {
        duck.quack();
    }

    void simulator() {
        MallardDuck mallardDuck = new MallardDuck();
        RedheadDuck redheadDuck = new RedheadDuck();
        DuckCall duckCall = new DuckCall();
        RubberDuck rubberDuck = new RubberDuck();
        GooseAdapter gooseDuck = new GooseAdapter(new Goose());

        System.out.println("Duck Simulator with Goose Adapter");

        simulator(mallardDuck);
        simulator(redheadDuck);
        simulator(duckCall);
        simulator(rubberDuck);
        simulator(gooseDuck);

    }

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulator();
    }
}
