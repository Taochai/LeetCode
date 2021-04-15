package basicKnowledge.multiThread;

public class WindowTicketUsingThreadExtend {

    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("1");
        window2.setName("2");
        window3.setName("3");

        window1.start();
        window2.start();
        window3.start();
    }

}

//class Window extends Thread {
//    //存在线程安全问题，重票
//    private static int ticket = 100;
//
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (Window.class) {
//                if (ticket <= 0) {
//                    break;
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("window---" + getName() + "---ticket: " + ticket--);
//            }
//        }
//    }
//}

class Window extends Thread {
    //存在线程安全问题，重票
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (saleTicket()) break;
        }
    }

    private static synchronized boolean saleTicket() { //同步监视器: this 加了static后，同步监视器变成: Window.class
        if (ticket <= 0) {
            return true;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("window---" + Thread.currentThread().getName() + "---ticket: " + ticket--);
        return false;
    }
}

