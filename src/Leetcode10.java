public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // init
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }
        //transfer function
        for(int si=1;si<=s.length();si++){
            for(int pi=1;pi<=p.length();pi++){
                if(p.charAt(pi-1)=='.' || p.charAt(pi-1)==s.charAt(si-1)){
                    dp[si][pi] = dp[si-1][pi-1];
                }
                else if(p.charAt(pi-1)=='*'){
                    if(p.charAt(pi-2)==s.charAt(si-1) || p.charAt(pi-2)=='.'){
                        dp[si][pi] = dp[si][pi-2] || dp[si-1][pi];
                    }else{
                        dp[si][pi] = dp[si][pi-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
