package multiThread;

import org.openjdk.jol.info.ClassLayout;

public class multithreadTest {
    public static void main(String[] args) {
        Object o = new Object();
        Object oo = new Object();
        //打印内存布局
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(oo).toPrintable());
        //把对象上锁
        synchronized (o){
            o.hashCode();
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

    }
}
