package leetcode;

public class Leetcode518CoinChange2 {
    //看看grandyang的blog吧。
    //感受一下和上楼梯的区别。
    // public int change(int amount, int[] coins) {
    //         int[][] dp = new int[coins.length+1][amount+1];
    //         dp[0][0] = 1;
    //         for(int i=1;i<=coins.length;i++){
    //             dp[i][0] = 1;
    //             for(int j=1;j<=amount;j++){
    //                 dp[i][j] = dp[i-1][j] +  (j>=coins[i-1] ? dp[i][j-coins[i-1]] : 0);
    //             }
    //         }
    //         return dp[coins.length][amount];
    //     }

    public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];
        arr[0] = 1;
        for (int c : coins)
            for (int i = c; i <= amount; i++)
                arr[i] += arr[i - c];
        return arr[amount];
    }
}

