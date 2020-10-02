public class Leetcode974 {

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        if(len==0) return 0;
        int[] sum = new int[len+1]; // 前缀和
        for(int i=0;i<len;i++){
            sum[i+1] = sum[i] + A[i];
        }
        int[] count = new int[K];
        for(int n: sum){
            count[(n%K+K)%K]++; //处理复数 -2 --> -2+K
        }
        int ans = 0;
        for(int c:count){
            if(c>1){
                ans += c*(c-1)/2; //c(n,2) = n*(n-1)/2
            }
        }
        return ans;
    }

}
