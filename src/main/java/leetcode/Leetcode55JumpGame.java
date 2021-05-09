package leetcode;

public class Leetcode55JumpGame {

    public boolean canJump(int[] nums) {

        if(nums.length==1) return true;
        int i=0;
        int maxIdx = 0; //max index can be reached
        while (i <= maxIdx) { //i 最多走到maxIdx，每往前一步，检查maxIdx是否到end.
            maxIdx = Math.max(maxIdx,i+nums[i]);
            if(maxIdx>=nums.length-1) return true;
            i++;
        }
        return false;


    }

}
