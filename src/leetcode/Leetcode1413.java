package leetcode;

public class Leetcode1413 {

    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = ans;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 1) {
                ans += 1 - sum;
                sum = 1;
            }
        }
        return ans;
    }
}
