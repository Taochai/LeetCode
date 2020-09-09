public class Leetcode724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        double sum = 0;
        for(int n: nums){
            sum += n;
        }
        double sumL = 0;

        for(int i=0;i<nums.length;i++){
            if(i==0) sumL = 0;
            else  sumL += nums[i-1];
            if(sumL==(sum-nums[i])/2) return i;
        }
        return -1;
    }
}
