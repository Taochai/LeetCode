import java.util.Arrays;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0) return -1;
        int[] dp = new int[amount+1];
        // dp[i] 表示和为i时所需要的最少的coin number
        // dp[i] 最多为i，所有的dp[i]不超过amount, 设为amount为了返回-1,
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for(int coin : coins){
                if(coin>i) continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
