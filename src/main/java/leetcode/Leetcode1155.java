package leetcode;

public class Leetcode1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000000 + 7;
        int[][] dp = new int[d + 1][target + 1]; // dp[m][n] m个骰子，合为n的组合数。

        for (int i = 1; i <= f && i <= target; i++) {  // i<=target 防止target目标数太小
            dp[1][i] = 1;
        }

        for (int i = 2; i <= d; i++) {
            for (int k = 1; k <= target; k++) {
                for (int j = 1; j <= f && j < k; j++) {   //注意条件 j<k
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % mod;
                }
            }
        }
        return dp[d][target];
    }
}
