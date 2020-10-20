package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode346MovingAveragefromDataStream {
    int sum;
    Queue<Integer> s;
    int size;
    /** Initialize your data structure here. */
    public Leetcode346MovingAveragefromDataStream(int size) {
        this.sum = 0;
        this.s = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if(s.size()<size){
            sum += val;
            s.offer(val);
            return (double) sum/s.size();
        }else{
            sum -=s.poll();
            sum +=val;
            s.offer(val);
            return (double) sum/s.size();
        }

    }
}
