package leetcode;

public class Leetcode125 {
    public boolean isPalindrome(String s) {
        //corner case
        if(s.length()==0) return true;
        int i=0,j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i)) !=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
