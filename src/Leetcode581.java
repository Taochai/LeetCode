public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        //从左往右，更新max，只要比max小的，就是需要sort的元素。
        //从右往左，更新min，只要比min大的，就是需要sort的元素
        if(nums==null || nums.length<2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = -2, end = -1;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(nums[i]<max){
                start = i;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            min = Math.min(min,nums[i]);
            if(nums[i]>min){
                end = i;
            }
        }
        return start - end + 1;
//         if(nums == null) return 0;
//         int len = nums.length;
//         if(len <2) return 0;

//        //here start = -2 and end = -1..because if there the array doesn't have any issue..
//        //then return will be 0

//        //move from start to find the number out of position
//        int max = Integer.MIN_VALUE;
//        int start = -2;
//        for(int i=0; i< len;i++){
//            max = Math.max(max, nums[i]);
//            //this is to compare the last number which is smaller than max
//            //this will give you the actual index where the number out of position should be
//            if(nums[i] < max){
//                start = i;
//            }
//        }

//        //move from end to find the number out of position
//        int min = Integer.MAX_VALUE;
//        int end = -1;
//        for(int i=len-1 ; i>=0 ; i--){
//            min = Math.min(min, nums[i]);
//             //this is to compare the last number which is greater than min
//            //this will give you the actual index where the number out of position should be
//            if(nums[i] > min){
//                end = i;
//            }
//        }

//        return start - end + 1;

    }
}
