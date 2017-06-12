package DesiginPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NonOwnerInvocationHandler implements InvocationHandler{
    PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        try {
            if(method.getName().startsWith("get")){
                return method.invoke(person, args);
            }else if(method.getName().equals("setHotOrNotRating")){
                return method.invoke(person, args);
            }else if(method.getName().startsWith("set")){
                throw new IllegalAccessException();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }

}
