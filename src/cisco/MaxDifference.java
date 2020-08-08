package cisco;

public class MaxDifference {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,5,7,88,2,45,66};
        System.out.println(maxDiff(arr));
    }

    public static int maxDiff(int[] arr){
        int[] min = new int[arr.length];
        int minNum = arr[0];
        min[0] = minNum;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<minNum){
                minNum = arr[i];
            }
            min[i] = minNum;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            ans = Math.max(ans, arr[i]-min[i]);
        }
        return ans;
    }
}
