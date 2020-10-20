package leetcode;

public class Leetcode152 {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        int ans = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i=1;i<len;i++){
            max[i] = Math.max(nums[i] * (nums[i]>=0 ? max[i-1] : min[i-1]), nums[i]);
            min[i] = Math.min(nums[i] * (nums[i]>=0 ? min[i-1] : max[i-1]), nums[i]);
            ans = Math.max(ans,max[i]);
        }
        return ans;
    }

}
