package basicKnowledge.multiThread;

public class ProductConsumeTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread p1 = new Thread(new Producer(clerk));
        Thread c1 = new Thread(new Customer(clerk));

        p1.setName("producer");
        c1.setName("customer");

        p1.start();
        c1.start();
    }
}


class Clerk {
    private int productNumber = 5;

    /*这两个方法持有同一个monitor，同一时间只有一个方法可以运行。但是两个线程是在同时运行的。*/
    public synchronized void produceProduct() {
        if (productNumber < 20) {
            productNumber++;
            notify();
            System.out.println(Thread.currentThread().getName() + " is producing " + productNumber + "th product");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (productNumber > 0) {
            System.out.println(Thread.currentThread().getName() + " is consuming " + productNumber + "th product");
            productNumber--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.produceProduct();
        }
    }
}

class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.consumeProduct();
        }
    }
}
