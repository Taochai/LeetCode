import java.util.HashSet;
import java.util.Set;

public class Leetcode3LongestSubstringWithoutRepeatingCharacters {

}
//1st time: sliding window--->two pointer
//用HashSet存出现过的Character
//同步更新ans
//time complexity O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //corner case
        if(s.length()==0) return 0;
        int i=0,j=0;
        int ans = 0;
        Set<Character> m = new HashSet<>();
        while(i<s.length() && j<s.length()){
            if(!m.contains(s.charAt(j))){
                m.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }
            else{
                m.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
