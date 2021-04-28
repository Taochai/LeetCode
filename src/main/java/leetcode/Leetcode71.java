package leetcode;

import java.util.Stack;

public class Leetcode71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;

        String[] pathArr = path.split("/+");
        Stack<String> stack = new Stack<>();

        for (String s : pathArr) {
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        String ans = String.join("/", stack);
        return "/" + ans;
    }
}
