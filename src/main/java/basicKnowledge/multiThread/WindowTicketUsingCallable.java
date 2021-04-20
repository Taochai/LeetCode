package basicKnowledge.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class WindowTicketUsingCallable {
    public static void main(String[] args) {
        WindowCallable windowCallable = new WindowCallable();

        FutureTask<Integer> futureTask = new FutureTask<>(windowCallable);

        new Thread(futureTask).start();

        try {
            Integer sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class WindowCallable implements Callable<Integer> {
    private int ticketNumber = 100;

    @Override
    public Integer call() {
        int sum = 0;
        while (ticketNumber > 0) {
            ticketNumber--;
            sum += 2;
        }
        return sum;
    }
}
