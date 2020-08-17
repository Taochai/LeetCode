import java.util.PriorityQueue;

public class Leetcode295FindMedianFromDataStream {
    /*
    *
    * 因为和small里的值对比，并且在small为空的时候加进去，所以要让small里的值比large里的值多一个。
    *
    * */
    class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;
        /** initialize your data structure here. */
        public MedianFinder() {
            small = new PriorityQueue<>((o1,o2) -> o2-o1);
            large = new PriorityQueue<>();

        }

        public void addNum(int num) {
            if(small.size()==0 || num<=small.peek()){
                small.add(num);
            }else{
                large.add(num);
            }

            if(large.size()>small.size()){
                small.add(large.poll());
            }
            else if(small.size() > 1+large.size()){
                large.add(small.poll());
            }


        }

        public double findMedian() {
            if(small.size()==large.size()){
                return (double)(0.5 * (small.peek()+large.peek()));
            }
            return (double)small.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
