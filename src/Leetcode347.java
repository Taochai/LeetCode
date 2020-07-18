import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            if(!map.containsKey(n)){
                map.put(n,0);
            }else{
                map.put(n,map.get(n));
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue()-o2.getValue());
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(entry);
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
