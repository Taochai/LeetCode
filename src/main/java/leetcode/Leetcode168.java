package leetcode;

public class Leetcode168 {

    public String convertToTitle(int n) {
        String ans = "";
        while(n > 0){
            if(n%26 != 0){
                ans = String.valueOf((char)(n%26 + 64)) + ans;
                n /= 26;
            }else{
                ans = "Z" + ans;
                // n--;
                n /= 26;
                n--;
                //上一位如果是Z， 前面就会少1.
            }
        }
        return ans;
    }
}
