public class Leetcode287FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for(int num: nums){
            arr[num]++;
        }
        for(int i=0;i<arr.length;i++){

            if(arr[i]>1) return i;

        }
        return 0;
    }
}
