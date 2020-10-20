package leetcode;

public class Leetcode72EditDistance {

        public int minDistance(String word1, String word2) {
            //corner case
            if(word1.length()==0) return word2.length();
            if(word2.length()==0) return word1.length();
            int n1=word1.length(), n2=word2.length();
            //1st step dp[i][j] word1[0 --- i-1] word2[0 --- j-1]需要的操作步数
            int[][] dp = new int[n1+1][n2+1];
            //2nd initialize corner case
            for(int i=0;i<=n1;i++) dp[i][0] = i;
            for(int j=0;j<=n2;j++) dp[0][j] = j;
            //3rd
            for(int i=1;i<=n1;i++){
                for(int j=1;j<=n2;j++){
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                    }
                }
            }
            return dp[n1][n2];
        }

/*
    hor  i=3
    ro   j=2
    dp[2][1] ho --> r 需要的最小操作数2  replace
    dp[3][1] hor --> r 需要的最小操作数2 insert
    dp[2][2] ho --> ro 需要的最小操作数1 delete
    dp[3][2] = 2;
*/
}
