package leetcode;

public class Leetcode283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        for(;fast<nums.length;fast++){
            if(nums[fast]!=0){
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
        }
    }

}
