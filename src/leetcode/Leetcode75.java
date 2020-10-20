package leetcode;

public class Leetcode75 {
    public void sortColors(int[] nums) {
        // count numbers of 0,1,2
        // two-pass solution
        // int[] colors = new int[3];
        // for(int num : nums) colors[num]++;
        // int index = 0;
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<colors[i];j++){
        //         nums[index++] = i;
        //     }
        // }
        int l = 0, r = nums.length-1;
        for(int i=0;i<=r;i++){
            if(nums[i]==0){
                swap(nums,i,l++);   //和0交换后，i正常+1
            }else if(nums[i]==2){
                swap(nums,i--,r--); // 和2交换后， i要前移一位
            }

        }
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
