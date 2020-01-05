import java.util.Arrays;

/*
    1st time
    遍历一遍，再遍历每一个.
    time complexity: O(n*n)
    排序后用二分法会出现的错误：...23,24,33,34... 找到的结果是24+33， 实际结果应该是23+34. left最后等于right，代表有多少个小于目标值。
*/
public class Leetcode1099TwoSumLessThanK {
    /*
    brute force
    time complexity：O(n*n)
     */
    // public int twoSumLessThanK(int[] A, int K) {
    //     int ans = -1;
    //     for(int i=0;i<A.length;i++){
    //         for(int j=i+1;j<A.length;j++){
    //             int tmp = A[i] + A[j];
    //             if(tmp<K && tmp>ans) ans = tmp;
    //         }
    //     }
    //     return ans;
    // }
    //////////////错误的binary search
    public int twoSumLessThanK(int[] A, int K) {
        //corner case
        if(A.length==0 || A.length==1) return -1;
        int ans = -1;
        Arrays.sort(A);//时间复杂度???
        int l = 0, r = A.length;
        int mid = 0;
        while(l<r){
            mid = (r-l)/2 + l;
            if(mid == r) break;
            if(A[mid]+A[mid+1]==K){
                r = mid;
            }
            if(A[mid]+A[mid+1]<K){
                l = mid+1;
            }
            else if(A[mid]+A[mid+1]>K){
                r = mid;
            }
        }
        System.out.println(A[l]);
        if(l==A.length-1 || l==0) ans = -1;
        else{
            ans = A[l-1]+A[l];
        }
        return ans;
    }
}
