package leetcode;/* 1st time
 1 用map过一遍string数组，记录单词和频率
 2 max heap来找frequency最大的k个数。 用PriorityQueue实现.自己写compare函数。
 时间复杂度：k*log(n)
*/
import java.util.*;

class Leetcode692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // 1.------> n
        Map<String,Integer>  m = new HashMap<>();
        for(String s : words){
            if(!m.containsKey(s)){
                m.put(s,0);
            }
            m.put(s,1+m.get(s));
        }
        // 2.------> N*log(N)  sort
        PriorityQueue<word> maxHeap = new PriorityQueue<>(new sortByFreq());
        Iterator<Map.Entry<String,Integer>> entries = m.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String,Integer> entry = entries.next();
            word tmp = new word(entry.getValue(),entry.getKey());
            maxHeap.offer(tmp);
        }
        // 3.------> k*log(n)
        List<String> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(maxHeap.poll().word);
        }
        return ans;
    }
}

class sortByFreq implements Comparator<word>{
    @Override
    public int compare(word o1, word o2) {
        if(o1.freq!=o2.freq){
            return o2.freq - o1.freq;
        }else{
            return o1.word.compareTo(o2.word);
        }
    }
}

class word{
    int freq;
    String word;
    public word(int _freq, String _word){
        this.freq = _freq;
        this.word = _word;
    }
}
