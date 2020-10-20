package leetcode;

public class Leetcode189RotateArray {

//    class Solution {
//        public void rotate(int[] nums, int k) {
//            if(nums==null || nums.length==0 || nums.length==1) return;
//
//            int tmp = nums[0];
//            int n = 0;
//            int start = 0;
//            int index = start;
//            int len = nums.length;
//            while(n<len){
//
//                index = (index+k)%len;
//
//                int tmpp = nums[index];
//                nums[index] = tmp;
//                tmp = tmpp;
//                n++;
//                if(index==start && n < len){
//                    index++;
//                    start++;
//                    tmp = nums[index];
//                }
//            }
//        }
//    }
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
}
