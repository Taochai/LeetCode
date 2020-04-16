import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Leetcode451SortCharactersByFrequency {

        public String frequencySort(String s) {
            // corner case
            if(s==null || s.length()==0 || s.length()==1) return s;
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }else{
                    map.put(s.charAt(i),1);
                }
            }
            List<Character> l = new ArrayList<>(map.keySet());
            Collections.sort(l,(a, b) -> map.get(b)-map.get(a));
            StringBuilder sb = new StringBuilder();
            for(char c : l){
                for(int j=0;j<map.get(c);j++){
                    sb.append(c);
                }
            }
            return sb.toString();
        }

}
//sort nlog(n)