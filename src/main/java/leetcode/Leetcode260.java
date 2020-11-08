package leetcode;

public class Leetcode260 {
    class Solution {
        // public int[] singleNumber(int[] nums) {
        //     int[] ans = new int[2];
        //     Set<Integer> set = new HashSet<>();
        //     for(int n: nums){
        //         if(!set.contains(n)) set.add(n);
        //         else{
        //             set.remove(n);
        //         }
        //     }
        //     int index = 0;
        //     for(int n: set){
        //         ans[index++] = n;
        //     }
        //     return ans;
        // }
        public int[] singleNumber(int[] nums) {
            int[] ans = new int[2];
            // get x = a^b
            int x = 0;
            for(int num: nums){
                x ^= num;
            }
            // find one num x which will lead x&a==0,x&b!=0
            x = x&(~(x-1));
            for(int num: nums){
                if((num & x)==0){
                    ans[0]^=num;
                }else{
                    ans[1]^=num;
                }
            }
            return ans;
        }
    }
}
