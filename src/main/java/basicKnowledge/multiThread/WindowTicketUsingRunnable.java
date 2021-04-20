package basicKnowledge.multiThread;

public class WindowTicketUsingRunnable {
    /*仍然存在线程安全问题*/
    public static void main(String[] args) {
        WindowRunnable1 windowRunnable = new WindowRunnable1();

        Thread window1 = new Thread(windowRunnable);
        Thread window2 = new Thread(windowRunnable);
        Thread window3 = new Thread(windowRunnable);

        window1.setName("1");
        window2.setName("2");
        window3.setName("3");

        window1.start();
        window2.start();
        window3.start();
    }
}

//class WindowRunnable implements Runnable {
//    private int ticket = 100;
//    final Object obj = new Object();
//
//    @Override
//    public void run() {
//        synchronized (obj) {
//            while (true) {
//                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("window---" + Thread.currentThread().getName() + "---ticket: " + ticket--);
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//}

class WindowRunnable implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (saleTicket()) break;
        }
    }

    private synchronized boolean saleTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("window---" + Thread.currentThread().getName() + "---ticket: " + ticket--);
        } else {
            return true;
        }
        return false;
    }
}


