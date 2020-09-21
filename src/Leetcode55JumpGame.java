public class Leetcode55JumpGame {

    public boolean canJump(int[] nums) {

        if(nums.length==1) return true;
        int i=0;
        int maxIdx = 0;
        while(i<=maxIdx){
            maxIdx = Math.max(maxIdx,i+nums[i]);
            if(maxIdx>=nums.length-1) return true;
            i++;
        }
        return false;


    }

}
