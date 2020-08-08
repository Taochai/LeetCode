package cisco;

public class Leetcode91DecodeWays {
    public int numDecodings(String s) {
        if(s.length()==0 || s.equals("0")) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        for(int i=1;i<s.length();i++){
            if( s.charAt(i-1)!='0' && Integer.parseInt(s.substring(i-1,i+1))<=26){

                dp[i+1] += dp[i-1] ;
            }
            if(s.charAt(i)!='0'){

                dp[i+1] += dp[i] ;
            }
        }
        return dp[s.length()];
    }
}
