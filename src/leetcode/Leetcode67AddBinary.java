package leetcode;

public class Leetcode67AddBinary {
    public String addBinary(String a, String b) {
        String ans = "";
        int len1 = a.length(), len2 = b.length();
        int  move = 0;
        int i=len1-1, j=len2-1;
        int sum = 0;
        while(i>=0 || j>=0){
            int num1 = (i<0 ? 0 : Integer.parseInt(a.charAt(i)+""));
            int num2 = (j<0 ? 0 : Integer.parseInt(b.charAt(j)+""));
            sum = num1+num2+move;
            ans = "" + sum % 2 + ans;
            move = sum / 2;
            i--;
            j--;
        }
        if(move!=0) ans ="" + 1 + ans;
        return ans;
    }
}
