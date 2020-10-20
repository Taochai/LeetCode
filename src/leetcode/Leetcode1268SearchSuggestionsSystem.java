package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
   1st time: brute force解决。 按每次输入的string找对应的products。 如何按照lexicographically排序string array？
   --------> Arrays.sort(products);
    改进： copy一个products，每次删掉不符合的products
    ------discussion里有trie的做法。忘了trie是怎么搞得了。
*/
public class Leetcode1268SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        //时间复杂度O(nlogn)。
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            ans.add(search(products,searchWord.substring(0,i+1)));
        }
        return ans;
    }
    public List<String> search(String[] products, String word){
        List<String> l = new ArrayList<>();
        for(int i=0;i<products.length;i++){
            if(products[i].length()<word.length()) continue;
            if(products[i].substring(0,word.length()).equals(word)){
                l.add(products[i]);
            }
            if(l.size()==3) return l;
        }
        return l;
    }
}
