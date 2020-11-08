package leetcode;

import java.util.*;
public class Leetcode362DesignHitCounter {

}
class HitCounter {
    // int cnt;
    PriorityQueue<Integer> pq;
    /** Initialize your data structure here. */
    public HitCounter() {
        // cnt = 0;
        pq = new PriorityQueue<Integer>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(pq.size()==0){
            pq.offer(timestamp);
            // cnt++;
        }else{

            while(pq.size()!=0 && timestamp-pq.peek()>=300){
                pq.poll();
            }
            pq.offer(timestamp);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(pq.size()!=0 && timestamp-pq.peek()>=300){
            pq.poll();
        }
        return pq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */