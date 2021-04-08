package basicKnowledge.dynamicProxy;

public class dynamicProxyUsingCglib {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        ProxyFactory proxyFactory = new ProxyFactory(user);
        UserImpl proxyInstance = (UserImpl) proxyFactory.getProxyInstance();
        proxyInstance.hello();
    }
}


