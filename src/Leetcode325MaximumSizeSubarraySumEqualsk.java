import java.util.HashMap;

public class Leetcode325MaximumSizeSubarraySumEqualsk {

        public int maxSubArrayLen(int[] nums, int k) {
            //corner case
            if(nums.length==0) return 0;
            int ans = 0;
            int sum = 0;
            HashMap<Integer,Integer> m = new HashMap<>();
            m.put(0,-1);
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
                // if(sum==k) ans = i+1;
                if(!m.containsKey(sum)) m.put(sum, i);
                if(m.containsKey(sum-k)) ans = Math.max(i - m.get(sum - k), ans);
            }
            return ans;
        }

}
