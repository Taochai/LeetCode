public class Leetcode1223 {

    //     int ans = 0;
//     public int dieSimulator(int n, int[] rollMax) {
//         if(n==0) return 0;

    //         for(int i=0;i<6;i++){
//             helper(n-1,i,1,rollMax);
//         }
//         return ans;
//     }
//     private void helper(int n,int curr,  int count, int[] rollMax){
//             if(count>rollMax[curr]) return;
//             if(n==0){
//                 ans++;
//                 return;
//             }
//         for(int i=0;i<6;i++){
//             if(i==curr){
//                 helper(n-1,i,count+1,rollMax);
//             }else{
//                 helper(n-1,i,1,rollMax);
//             }
//         }
//     }
    public int dieSimulator(int n, int[] rollMax) {
        int kmax = 15;
        int mod = (int)Math.pow(10,9)+7;
        int[][][] dp = new int[n+1][6][kmax+1];
        for(int j=0;j<6;j++){
            dp[1][j][1] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<6;j++){
                for(int p=0;p<6;p++){
                    for(int k=1;k<=rollMax[p];k++){
                        if(p!=j){
                            dp[i][j][1] = (dp[i][j][1]+dp[i-1][p][k]) % mod;
                        }
                        else if(k<rollMax[j]){
                            dp[i][j][k+1] = dp[i-1][j][k];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int j=0;j<6;j++){
            for(int k=1;k<=rollMax[j];k++){
                ans = (ans + dp[n][j][k]) % mod;
            }
        }
        return ans;
    }

}
