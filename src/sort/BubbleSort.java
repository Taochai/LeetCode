package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,66,55,3,77,9,15};
        bubbleSort(arr);
        for (int n:arr) {
            System.out.print(n+"   ");
        }
    }
/*
*  n个数，交换n-1轮
*  每一轮确定第n-i个最大数
* */
    private static void bubbleSort(int[] arr){
        int swap = 0;
        for (int i=0;i<arr.length-1;i++){
            for (int j = 0; j < arr.length-1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
