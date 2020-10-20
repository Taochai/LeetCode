package leetcode;

public class Leetcode121BestTimetoBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            // corner case:
            int len = prices.length;
            if(len==0 || len==1) return 0;
            int min = prices[0];
            int max = 0;
            for(int i=1;i<len;i++){
                max = Math.max(max,prices[i]-min);
                min = Math.min(min,prices[i]);
            }
            return max;
        }
    }
}
