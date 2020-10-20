package leetcode;

import java.util.PriorityQueue;

// 1st time.
// PriorityQueue--->最小堆,每次找到最小的两个stick,累加cost
//Java PriorityQueue (Java Doc)
// O(log n) time for the enqueing and dequeing methods (offer, poll, remove() and add)
// O(n) for the remove(Object) and contains(Object) methods
// O(1) for the retrieval methods (peek, element, and size)
class Leetcode1167MinimumCosttoConnectSticks {
    public int connectSticks(int[] sticks) {
        //corner case
        if(sticks.length==1) return 0;
        //initial PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<sticks.length;i++){
            pq.add(sticks[i]);
        }
        int cost = 0;
        while(pq.size()>=2){
            int min1 = pq.poll();
            int min2 = pq.poll();
            cost += min1+min2;
            pq.offer(min1+min2);
        }
        return cost;
    }
}
