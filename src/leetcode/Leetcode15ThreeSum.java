package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15ThreeSum {
    /*
    * 对原数组进行排序，然后开始遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了。这里可以先做个剪枝优化，就是当遍历到正数的时候就 break，为啥呢，因为数组现在是有序的了，如果第一个要 fix 的数就是正数了，则后面的数字就都是正数，就永远不会出现和为0的情况了。然后还要加上重复就跳过的处理，处理方法是从第二个数开始，如果和前面的数字相等，就跳过，因为不想把相同的数字fix两次。对于遍历到的数，用0减去这个 fix 的数得到一个 target，然后只需要再之后找到两个数之和等于 target 即可。用两个指针分别指向 fix 数字之后开始的数组首尾两个数，如果两个数和正好为 target，则将这两个数和 fix 的数一起存入结果中。然后就是跳过重复数字的步骤了，两个指针都需要检测重复数字。如果两数之和小于 target，则将左边那个指针i右移一位，使得指向的数字增大一些。同理，如果两数之和大于 target，则将右边那个指针j左移一位，使得指向的数字减小一些
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;

            int l = i+1, r = nums.length-1;

            while(l<r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return ans;
    }

}
