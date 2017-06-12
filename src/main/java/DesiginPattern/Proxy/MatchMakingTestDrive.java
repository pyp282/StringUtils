package DesiginPattern.Proxy;

public class MatchMakingTestDrive {
    public PersonBean getOwnerProxy(PersonBean person) {
        return new OwnerInvocationHandler(person).getOwnerProxy(person);
    }

    public PersonBean getNonOwnerProxy(PersonBean person) {
        return new NonOwnerInvocationHandler(person).getNonOwnerProxy(person);
    }

    public void drive() {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe JavaBean");
        PersonBean ownerProxy = getOwnerProxy(joe);

        System.out.println("Name is: " + ownerProxy.getName());
        ownerProxy.setInterests("Bowling, Go");

        System.out.println("Interests set from owner proxy");

        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }

        System.out.println("Rating is: " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is: " + nonOwnerProxy.getName());

        try {
            nonOwnerProxy.setInterests("owling, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }

        nonOwnerProxy.setHotOrNotRating(4);
        System.out.println("Rating set from non owner proxy;");
        System.out.println("Rating is: " + nonOwnerProxy.getHotOrNotRating());

    }

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }
}
