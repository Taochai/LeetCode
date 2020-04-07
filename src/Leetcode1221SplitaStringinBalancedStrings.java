public class Leetcode1221SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        // corner case
        if(s.length()==0 || s.length()==1) return 0;
        int ans = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L') count++;
            else count--;
            if(count==0){
                ans++;
            }
        }
        return ans;
    }
}
