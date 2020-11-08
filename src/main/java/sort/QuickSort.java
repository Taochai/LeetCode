package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,66,55,3,77,9,15};
        quickSort(arr,0,arr.length-1);
        for (int n:arr) {
            System.out.print(n+"   ");
        }
    }
    //partition就是把pivot放在正确的位置
    // 并且确保左边的比pivot小，右边的比pivot大
    private static void quickSort(int[] arr,int l, int r){
        if(l<r){
            int pi = partition(arr,l,r);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,r);
        }
    }
    private static int partition(int[] arr, int l, int r){
        int pivot = arr[l];
        int i = l+1;
        for (int j = l+1; j <= r; j++) {
            if(arr[j]<=pivot){
               swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i-1,l);
        return i-1;
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
