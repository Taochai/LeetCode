package leetcode;

import java.util.*;
/*
    1st 方法类似496，把原数组扩展一倍处理。
    一定会有duplicates，所以stack和map里存index，不存value.
 */
public class Leetcode503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length*2;i++){
            while(!s.isEmpty() && nums[i%nums.length]>nums[s.peek()%nums.length]){
                m.put(s.pop(),nums[i%nums.length]);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            m.put(s.pop(),-1);
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = m.get(i);
        }
        return ans;
    }
}
