package basicKnowledge.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

//        service.execute(new Thread1());
//        service.execute(new Thread2());

        FutureTask<Integer> futureTask = new FutureTask<>(new ThreadCallable());
        Future<Integer> future = service.submit(new ThreadCallable());
        try {
            System.out.println("**********" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

class ThreadCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 100; i = i + 2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
        return 100;
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i = i + 2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 100; i = i + 2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
    }
}

