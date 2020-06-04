import java.util.Arrays;
/*
    先假设全部去cityA，然后计算每一个人去cityB要增加多少成本，
    然后排序成本，把最小的N的成本换成去cityB，并且加到总成本。
 */
public class Leetcode1029TwoCityScheduling {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int totalCost = 0;
            int N = costs.length;
            int[] diff = new int[N];
            for(int[] cost : costs){
                totalCost += cost[0];
            }
            for(int i=0;i<N;i++){
                diff[i] = costs[i][1]-costs[i][0];
            }
            Arrays.sort(diff);
            for(int i=0; i<N/2;i++){
                totalCost += diff[i];
            }
            return totalCost;
        }
    }

}
