package databricks;

public class ZigZag {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,2,5,4,2};
        int[] ans = func(arr);
        for (int n : ans){
            System.out.println(n);
        }

    }
    public static int[] func(int[] arr){
        int[] ans = new int[arr.length-2];
        for(int i=0;i<ans.length;i++){
            if((arr[i]<arr[i+1] && arr[i+1]>arr[i+2] )||(arr[i]>arr[i+1] && arr[i+1]<arr[i+2] )){
                ans[i] = 1;
            }
        }
        return ans;
    }
}
