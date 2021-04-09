- [leetcode](#leetcode)
  * [反射](#--)
    + [动态代理](#----)

# leetcode

## 反射

在程序运行期间，获得类的全部信息。

例子：通用的copy array的方法，在初始化数组的时候不知道数组内容的类型，可以用反射来获取。如果初始使用new Object[ ]，会导致不能强转到其他类型数组，比如Student[ ].

### 动态代理

java三种代理模式

代理模式:   设置一个中间代理来控制访问原目标对象，以达到增强原对象的功能和简化访问方式。

1. **静态代理**

2. **动态代理**(**JDK代理**，**借口代理**)

   ```java
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
   
           User proxyInstance = (User)Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new InvocationHandler() {
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
   
   interface User {
       void hello();
   }
   
   class UserImpl implements User {
   
       @Override
       public void hello() {
           System.out.println("hello user ..............");
       }
   }
   ```

3. **cglib代理**

   cglib使用字节码处理框架ASM，来转换字节码并生成新的类。被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。

   cglib与动态代理最大的**区别**就是

    - 使用动态代理的对象必须实现一个或多个接口

    - 使用cglib代理的对象则无需实现接口，达到代理类无侵入

   ```java
   package basicKnowledge.dynamicProxy;
   import net.sf.cglib.proxy.Enhancer;
   import net.sf.cglib.proxy.MethodInterceptor;
   import net.sf.cglib.proxy.MethodProxy;
   import java.lang.reflect.Method;
   
   public class ProxyFactory implements MethodInterceptor {
   
       private final Object target;//维护一个目标对象
       public ProxyFactory(Object target) {
           this.target = target;
       }
       
       //为目标对象生成代理对象
       public Object getProxyInstance() {
           //工具类
           Enhancer en = new Enhancer();
           //设置父类
           en.setSuperclass(target.getClass());
           //设置回调函数
           en.setCallback(this);
           //创建子类对象代理
           return en.create();
       }
       
       @Override
       public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
           System.out.println("enhance1 ..................");
           method.invoke(target, args);
           System.out.println("enhance2 ..................");
           return null;
       }
   }
   ```

   ```java
   package basicKnowledge.dynamicProxy;

public class dynamicProxyUsingCglib {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        ProxyFactory proxyFactory = new ProxyFactory(user);
        UserImpl proxyInstance = (UserImpl) proxyFactory.getProxyInstance();
        proxyInstance.hello();
    }
}
   ```

