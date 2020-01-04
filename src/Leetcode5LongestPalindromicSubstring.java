/*
    1st time
    对每一个字符，搜索以他为中心的最长palindromic string.
    time complexity: O(n*n)
    代码可以简化，下次简化代码。
 */
public class Leetcode5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            ans = ans.length()> judge(s,i).length()? ans :  judge(s,i);
        }
        return ans;
    }
    public String judge(String s, int index){
        String s1 = "";
        String s2 = "";
        String s3 = "";
        //1st case:
        int i =index, j =index;
        while(i>=0 && j<= s.length()-1){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else{
                break;
            }
        }
        s1 = s.substring(i+1,j);
        //2nd case:
        if(index==s.length()-1){

        }else{
            i =index; j =index+1;
            while(i>=0 && j<= s.length()-1){
                if(s.charAt(i)==s.charAt(j)){
                    i--;
                    j++;
                }else{
                    break;
                }
            }
            s2 = s.substring(i+1,j);
        }

        //3rd case:
//            if(index==0){

//         }else{
//             i =index-1; j =index;
//             while(i>=0 && j<= s.length()-1){
//                 if(s.charAt(i)==s.charAt(j)){
//                     i--;
//                     j++;
//                 }else{
//                     break;
//                 }
//             }
//             s3 = s.substring(i+1,j);
//         }
        return ((s1.length()>s2.length())?  s1 : s2 );
        // return ((s1.length()>s2.length())?  s1 : s2 ).length()>s3.length() ? ((s1.length()>s2.length())?  s1 : s2 ) : s3;
    }
}
