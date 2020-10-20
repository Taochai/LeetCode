package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1512 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for(int n : map.values()){
            if(n==1) continue;
            ans += combinate(n);
        }
        return ans;
    }
    private int combinate(int n){
        if(n==2) return 1;
        return n-1 + combinate(n-1);
    }
}
