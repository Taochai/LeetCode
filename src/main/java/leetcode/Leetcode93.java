package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode93 {

    List<List<String>> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new ArrayList<>());
        return ans.stream().map(l -> String.join(".", l))
                .collect(Collectors.toList());
    }

    private void dfs(String s, int index, List<String> list) {
        if (list.size() > 4) return;
        if (index == s.length()) {
            if (list.size() == 4) {
                if (!ans.contains(list)) {
                    ans.add(new ArrayList<>(list));
                }
            }
            return;
        }

        for (int i = index; i < index + 3 && i < s.length(); i++) {
            if (s.charAt(index) == '0') {
                list.add("0");
                //可以剪枝，判断剩下的数字个数和list的长度的关系
                dfs(s, index + 1, list);
                list.remove(list.size() - 1);
                break;
            }
            int n = Integer.parseInt(s.substring(index, i + 1));
            if (n > 255) {
                break;
            }
            list.add(String.valueOf(n));
            dfs(s, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        List<String> strings = new Leetcode93().restoreIpAddresses("010010");
    }
}
