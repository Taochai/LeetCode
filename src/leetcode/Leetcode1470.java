package leetcode;

public class Leetcode1470 {

    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[2*n];
        int i = 0, j = n;
        int m = 0;
        while(m<2*n){
            ans[m++] = nums[i++];
            ans[m++] = nums[j++];
        }
        return ans;
    }

}
