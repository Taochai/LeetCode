package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode187 {
    /*
    * 存在hashset中，十个十个找，重复就加在答案里
    * */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> set1 = new HashSet<>();

        for(int i=0;i<s.length()-9;i++){
            String ss = s.substring(i,i+10);
            if(set.contains(ss)){
                set1.add(ss);
            }else{
                set.add(ss);
            }
        }
        return new ArrayList<>(set1);
    }
}
