import java.util.*;

public class Leetcode127WordLadder {
}
// 1st time: 没做出来.
// 最短路径问题，搜索问题，BFS
// 循环生成小写字母表的方法
class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet(wordList);
        if(!dict.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int l = beginWord.length();
        int step = 0;
        while(q.size()>0){
            step++;
            for(int size=q.size();size>0;size--){
                String word = q.poll();
                //处理单词的每一位
                for(int i=0;i<l;i++){
                    for(char j='a';j<='z';j++ ){
                        String newWord = word.substring(0,i) + j + word.substring(i+1,l);
                        if(newWord.equals(endWord)) return step + 1;
                        if(!dict.contains(newWord)) continue;
                        q.offer(newWord);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
