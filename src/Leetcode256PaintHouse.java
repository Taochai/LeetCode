public class Leetcode256PaintHouse {

    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int len = costs.length;
        int[][] dp = new int[len][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        int ans = Math.min(dp[len - 1][0], dp[len - 1][1]);
        return Math.min(ans, dp[len - 1][2]);
    }

}
