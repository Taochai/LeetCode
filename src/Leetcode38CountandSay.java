public class Leetcode38CountandSay {
    String ans = "";
    public String countAndSay(int n) {
        helper(1,n,"1");
        return ans;
    }
    private void helper(int i, int n, String s){
        //跳出条件
        if(i==n){
            ans = s;
            return;
        };
        //递归主体
        StringBuilder tmp = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for(int j=1;j<s.length();j++){
            if(s.charAt(j)==prev) count++;
            else{
                tmp.append(""+count+prev);
                prev = s.charAt(j);
                count = 1;
            }
        }

        tmp.append(""+count+prev);
        helper(i+1, n, tmp.toString());
    }
}
