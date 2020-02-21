//1st time, 就是A[0]不动，然后swapA,B， 然后A[0]不动，swapB,A。
//          就是B[0]不动，然后swapA,B， 然后A[0]不动，swapB,A。
public class Leetcode1007MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int ans1 = Math.min(count(A[0],A,B),count(A[0],B,A));
        int ans2 = Math.min(count(B[0],A,B),count(B[0],B,A));
        int ans = Math.min(ans1,ans2);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int count(int num, int[] A, int[] B){
        int cnt = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]==num) continue;
            else if(B[i]==num) cnt++;
            else
                return Integer.MAX_VALUE;
        }
        return cnt;
    }
}
