import java.util.PriorityQueue;

public class Leetcode1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // corner case
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        int x,y;
        while(pq.size()>=2){
            x = pq.poll();
            y = pq.poll();
            if(x==y) continue;
            else{
                pq.add(x-y);
            }
        }
        return pq.size()==0 ? 0 : pq.poll();
    }
}
