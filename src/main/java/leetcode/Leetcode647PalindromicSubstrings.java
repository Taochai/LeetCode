package leetcode;

public class Leetcode647PalindromicSubstrings {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += palindromicNumber(s, i, i) + palindromicNumber(s, i, i + 1);
        }
        return ans;
    }

    private int palindromicNumber(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i--) == s.charAt(j++)) {
                count++;
            } else {
                break;
            }
        }
        return count;

    }
}
