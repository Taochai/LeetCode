package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode448 {
    //element in original array are all positive
    //use index to record every number
    //for each number, if it occurs, we set index(number-1) 等于负的，回头取值的时候再取绝对值
    //the positive number index+1 are answers
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            int index = Math.abs(num);
            if(nums[index-1]>0){
                nums[index-1] *= -1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
