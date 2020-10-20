//public class Leetcode1116 {
//    class ZeroEvenOdd {
//        private int n;
//        boolean isZeroPrinted;
//        boolean isOddPrinted;
//
//        public ZeroEvenOdd(int n) {
//            this.n = n;
//        }
//        /*
//        * wait() 必须在synchronized
//        * notifyAll() 通知其他进程可以运行
//        *
//        *
//        * */
//        // printNumber.accept(x) outputs "x", where x is an integer.
//        public void zero(IntConsumer printNumber) throws InterruptedException {
//            for(int i=0;i<n;i++){
//                synchronized(this){
//                    while(isZeroPrinted){
//                        wait();
//                    }
//                    printNumber.accept(0);
//                    isZeroPrinted = true;
//                    notifyAll();
//                }
//            }
//        }
//
//        public void even(IntConsumer printNumber) throws InterruptedException {
//            for(int i=2;i<=n;i+=2){
//                synchronized(this){
//                    while(!isZeroPrinted || !isOddPrinted){
//                        wait();
//                    }
//                    printNumber.accept(i);
//                    isZeroPrinted = false;
//                    isOddPrinted = false;
//                    notifyAll();
//                }
//            }
//        }
//
//        public void odd(IntConsumer printNumber) throws InterruptedException {
//            for(int i=1; i<=n; i += 2){
//                synchronized(this){
//                    while(!isZeroPrinted || isOddPrinted){
//                        wait();
//                    }
//                    printNumber.accept(i);
//                    isZeroPrinted = false;
//                    isOddPrinted = true;
//                    notifyAll();
//                }
//            }
//        }
//    }
//}
