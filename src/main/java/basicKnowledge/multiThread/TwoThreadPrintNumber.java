package basicKnowledge.multiThread;

public class TwoThreadPrintNumber {


    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        new Thread(printNumber).start();
        new Thread(printNumber).start();
    }

}

class PrintNumber implements Runnable {
    private int number = 1;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                this.notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + "------" + number);
                    number++;

                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
