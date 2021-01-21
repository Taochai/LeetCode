package leetcode;

public class Leetcode1209 {
/*
* 用count记录每个index对应得character的次数，如果次数==k，就删掉last k characters，
* index也回退k， count和原来一样更新。
* */

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }


//    public String removeDuplicates(String s, int k) {
//        Stack<Character> stack = new Stack<>();
//        Queue<Character> queue = new LinkedList<>();
//
//        int index = 0;
//
//        while (index < s.length()) {
//            char c = s.charAt(index++);
//            if (queue.isEmpty()) {
//                if (stack.isEmpty() || stack.peek() != c) {
//                    stack.push(c);
//                    continue;
//                }
//                while (!stack.isEmpty() && stack.peek() == c) {
//                    queue.offer(stack.pop());
//                }
//                queue.offer(c);
//
//            } else {
//                if (c == queue.peek()) {
//                    queue.offer(c);
//                } else {
//                    while (!queue.isEmpty()) {
//                        stack.push(queue.poll());
//                    }
//                    stack.push(c);
//                }
//            }
//
//            if (queue.size() == k) queue.clear();
//        }
//        while (!queue.isEmpty()) {
//            stack.push(queue.poll());
//        }
//
//        StringBuilder ans = new StringBuilder();
//        while (!stack.isEmpty()) {
//            ans.append(stack.pop());
//        }
//        return ans.reverse().toString();
//    }


}
