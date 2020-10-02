public class Leetcode1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length;

        int[] sum = new int[len];
        sum[0] = A[0];
        for(int i=1;i<len;i++){
            sum[i] = sum[i-1]+A[i];
        }

        int ans = sum[L+M-1];
        int maxl = sum[L-1], maxm =sum[M-1];
        //sum[x]-sum[x-y] 是以x结尾的，长度为x的和
        for(int i = L+M;i<len;i++){
            int currL = sum[i]-sum[i-L];
            int currM = sum[i]-sum[i-M];
            maxl = Math.max(maxl,sum[i-M]-sum[i-M-L]);
            maxm = Math.max(maxm,sum[i-L]-sum[i-M-L]);
            ans = Math.max(ans,Math.max(currL+maxm,currM+maxl));
        }

        return ans;
    }
}
