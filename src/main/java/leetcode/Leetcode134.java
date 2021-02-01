package leetcode;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
         *  先判断全部的gas够不够用，如果够用，则一定存在solution.
         * */
        int remainGas = 0;
        for (int i = 0; i < gas.length; i++) {
            remainGas += gas[i] - cost[i];
        }
        if (remainGas < 0) {
            return -1;
        }
        /*
         *  循环判断单步是否满足条件
         *  如果满足条件，start point就不动。
         *  如果不满足条件，start point移动到不满足情况的下一个点，accumulate也重新清0计算。
         * */
        int startPoint = 0;
        int accumulate = 0;
        for (int i = 0; i < gas.length; i++) {
            int currCost = gas[i] - cost[i];
            if (accumulate + currCost < 0) {
                startPoint = i + 1;
                accumulate = 0;
                continue;
            }
            accumulate += gas[i] - cost[i];
        }

        return startPoint;
    }
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        int index = 0;
//        while (index < n) {
//            if (gas[index] - cost[index] < 0) {
//                index++;
//                continue;
//            }
//            int count = 0;
//            int sum = 0;
//            int i = index;
//            while (sum + gas[i] - cost[i] >= 0) {
//                sum += gas[i] - cost[i];
//                count++;
//                i = (i+1)%n;
//                if (count == n) return index;
//            }
//            if (i < index) return -1;
//            index = i;
//        }
//        return -1;
//    }
}
