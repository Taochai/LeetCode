package basicKnowledge.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
 * JDK 动态代理
 * */
public class dynamicProxyUsingJDK {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();

        User proxyInstance = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("enhance1 ..................");
                method.invoke(user, args);
                System.out.println("enhance2 ..................");
                return null;
            }
        });

        proxyInstance.hello();
    }
}


