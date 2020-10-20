package leetcode;

import java.util.*;
public class Leetcode438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            arr1[p.charAt(i)-'a']++;
        }
        /////////////////////////////////
        for(int i=0;i<s.length();i++){
            if(i<p.length()){
                arr2[s.charAt(i)-'a']++;
            }
            else{
                arr2[s.charAt(i-p.length())-'a']--;
                arr2[s.charAt(i)-'a']++;
            }
            if(Arrays.equals(arr1,arr2)) ans.add(i-p.length()+1);
        }
        return ans;
    }
}
