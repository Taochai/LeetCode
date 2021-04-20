package basicKnowledge.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WindowTicketUsingLOCK {
    /*仍然存在线程安全问题*/
    public static void main(String[] args) {
        WindowRunnable1 windowRunnable1 = new WindowRunnable1();

        Thread window1 = new Thread(windowRunnable1);
        Thread window2 = new Thread(windowRunnable1);
        Thread window3 = new Thread(windowRunnable1);

        window1.setName("1");
        window2.setName("2");
        window3.setName("3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class WindowRunnable1 implements Runnable {
    private int ticket = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("window---" + Thread.currentThread().getName() + "---ticket: " + ticket--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}




