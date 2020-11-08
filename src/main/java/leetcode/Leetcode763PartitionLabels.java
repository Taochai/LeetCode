package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode763PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        // corner case
        List<Integer> ans = new ArrayList<>();
        //************************
        //HashMap改成int[26]会快很多
        //
        //
        //
        //*************************
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
        int start = 0, end = Integer.MIN_VALUE;
        for(int i=0;i<S.length() && start<S.length();i++){
            end = Math.max(end,map.get(S.charAt(i)));
            if(i==end){
                ans.add(end-start+1);
                start = end+1;
            }

        }
        return ans;
    }
}
/*
这道题给了我们一个字符串S，然我们将其尽可能多的分割为子字符串，条件是每种字符最多只能出现在一个子串中。比如题目汇总的例子，字符串S中有多个a，这些a必须只能在第一个子串中，再比如所有的字母e值出现在了第二个子串中。那么这道题的难点就是如何找到字符串的断点，即拆分成为子串的位置。我们仔细观察题目中的例子，可以发现一旦某个字母多次出现了，那么其最后一个出现位置必须要在当前子串中，字母a，e，和j，分别是三个子串中的结束字母。所以我们关注的是每个字母最后的出现位置，我们可以使用一个 HashMap 来建立字母和其最后出现位置之间的映射，那么对于题目中的例子来说，我们可以得到如下映射：

        a -> 8
        b -> 5
        c -> 7
        d -> 14
        e -> 15
        f -> 11
        g -> 13
        h -> 19
        i -> 22
        j -> 23
        k -> 20
        l -> 21

        建立好映射之后，就需要开始遍历字符串S了，我们维护一个 start 变量，是当前子串的起始位置，还有一个 last 变量，是当前子串的结束位置，每当我们遍历到一个字母，我们需要在 HashMap 中提取出其最后一个位置，因为一旦当前子串包含了一个字母，其必须包含所有的相同字母，所以我们要不停的用当前字母的最后一个位置来更新 last 变量，只有当i和 last 相同了，即当 i = 8 时，当前子串包含了所有已出现过的字母的最后一个位置，即之后的字符串里不会有之前出现过的字母了，此时就应该是断开的位置，我们将长度9加入结果 res 中，同理类推，我们可以找出之后的断开的位置*/
