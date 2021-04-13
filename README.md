- [leetcode](#leetcode)
    - [反射](#反射)
        - [动态代理](#动态代理)
    - [注解](#注解)
        - [三类注解](#三类注解)
        - [元注解](#元注解)
        - [处理注解（反射）](#处理注解反射)
    - [多线程](#多线程)
        - [概念](#概念)
        - [创建](#创建)
        - [生命周期](#生命周期)
        - [同步](#同步)
        - [通信](#通信)

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
             UserImpl proxyInstance = (UserImpl)proxyFactory.getProxyInstance();
             proxyInstance.hello();
         }
     }
   ```

## 注解

注解（Annotation）是Java语言用于工具处理的标注.

### 三类注解

- 编译器使用的注解（@Override @SuppressWarnings）

  这类注解不会被编译进入`.class`文件，它们在编译后就被编译器扔掉了

- 编译进``` .class``` 文件，在结束后不存在内存中。

- 程序运行期能够读取的注解，加载后一直存在于JVM中。(@PostConstruct)

### 元注解

可以修饰其他注解的注解。

- @Target

- @Retention

    1. `SOURCE`类型的注解在编译期就被丢掉了；
    2. `CLASS`类型的注解仅保存在class文件中，它们不会被加载进JVM；
    3. `RUNTIME`类型的注解会被加载进JVM，并且在运行期可以被程序读取。

- @Repeatable

- @Documented

- @Inherited

  使用`@Inherited`定义子类是否可继承父类定义的`Annotation`。`@Inherited`仅针对`@Target(ElementType.TYPE)`类型的`annotation`有效，并且仅针对`class`
  的继承，对`interface`的继承无效.

  在使用的时候，如果一个类用到了`@Report`：

  ```java
  @Report(type=1)
  public class Person {
  }
  ```

  则它的子类默认也定义了该注解：

  ```java
  public class Student extends Person {
  }
  ```



**总结**：必须设置`@Target`来指定`Annotation`可以应用的范围；应当设置`@Retention(RetentionPolicy.RUNTIME)`便于运行期读取该`Annotation`。

### 处理注解（反射） ###

对于作用在runtime的注解:

	判断某个注解是否存在:

- `Class.isAnnotationPresent(Class)`

- `Field.isAnnotationPresent(Class)`

- `Method.isAnnotationPresent(Class)`

- `Constructor.isAnnotationPresent(Class)`

  反射API读取Annotation：

- `Class.getAnnotation(Class)`

- `Field.getAnnotation(Class)`

- `Method.getAnnotation(Class)`

- `Constructor.getAnnotation(Class)`

## 多线程 ##

### 创建线程

1. extends Thread

- One is to declare a class to be a subclass of Thread.

- This subclass should override the run method of class Thread.

An instance of the subclass can then be allocated and started.

```java
   class PrimeThread extends Thread {
    long minPrime;

    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        // compute primes larger than minPrime
            . . .
    }
}
```

- The following code would then create a thread and start it running:

``` java
         PrimeThread p = new PrimeThread(143);
         p.start();
```

start()：开启新的线程 + 执行run()方法

2.
3.

### 生命周期

### 同步

解决安全问题

### 通信

