// 1st time
public class Leetcode8StringtoInteger {
    public int myAtoi(String str) {
        //corner case
        if(str==null || str.length()==0) return 0;
        String s = str.trim();
        int sign = 1;
        long ans = 0;
        for(int i=0;i<s.length();i++){
            if(i==0 && s.charAt(i)=='+'){
            }
            else if(i==0 && s.charAt(i)=='-'){
                sign = -1;
            }else if(!Character.isDigit(s.charAt(i))){
                return (int)ans*sign;
            }else{
                ans = ans*10 + s.charAt(i)-'0';
                if(ans*sign>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(ans*sign<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int)ans*sign;
    }
}
