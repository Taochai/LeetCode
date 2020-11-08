package leetcode;

import java.util.TreeSet;

public class Leetcode1438 {

    public int longestSubarray(int[] nums, int limit) {
        TreeSet<Integer> set = new TreeSet<>((a, b) ->
                nums[a]==nums[b]? a-b : nums[a]-nums[b]);
        int l = 0, r = 1;
        int ans = 1;
        set.add(l);
        for(;r<nums.length;r++){
            set.add(r);
            while(nums[set.last()]-nums[set.first()]>limit){
                set.remove(l++);
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }

}
