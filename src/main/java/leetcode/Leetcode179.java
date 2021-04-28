package leetcode;

import java.util.PriorityQueue;

/*
    对于 [4,42][4,42]，比较 442 > 424442>424，需要把 44 放在前面；
    对于 [4,45][4,45]，比较 445 < 454445<454，需要把 4545 放在前面。
    排序规则满足传递性，两个元素比较就可以确定它们在排序以后的相对位置关系。
    String.compareTo()可以比较代表数字的字符串。
* */
public class Leetcode179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        PriorityQueue<String> pq = new PriorityQueue<>((x, y) -> (x + y).compareTo(y + x));

        for (int n : nums) {
            pq.offer(String.valueOf(n));
        }
        String ans = "";
        while (!pq.isEmpty()) {
            ans = pq.poll() + ans;
        }
        if (ans.charAt(0) == '0') return "0";
        return ans;
    }
}
