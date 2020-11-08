package leetcode;

// 1st time
/*
    注意处理 2，2，2，5这样有相同价格的情况就可以。
 */
public class Leetcode122BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        //corner case
        if(prices.length==0 || prices.length==1) return 0;

        int ans=0;
        int low = -1;
        for(int i=0;i<prices.length;i++){
            //两个特殊情况
            if(i==0){
                if(prices[i]<prices[i+1]){
                    low = prices[i];
                }
            }
            else if(i==prices.length-1){
                if(prices[i]>prices[i-1]){
                    ans += low == -1 ? 0 : prices[i]-low;
                    low = -1;
                }
            }
            else{
                if(prices[i]<=prices[i-1] && prices[i]<prices[i+1]){
                    low = prices[i];
                }
                if(prices[i]>prices[i-1] && prices[i]>=prices[i+1]){
                    ans += low == -1 ? 0 : prices[i]-low;
                    low = -1;
                }
            }

        }
        return ans;
    }
}
