public class Leetcode443StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int ans = 0;
        char curr = chars[0];
        int cnt = 0;
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == curr) {
                cnt++;

            } else {
                if (cnt == 1) {
                    ans += 1;
                    chars[index++] = curr;
                } else {
                    chars[index++] = curr;
                    String s = Integer.toString(cnt);
                    for (char ss : s.toCharArray()) {
                        chars[index++] = ss;
                    }
                    ans += 1 + s.length();
                }
                curr = chars[i];
                cnt = 1;
            }

            if (i == chars.length - 1) {
                if (cnt == 1) {
                    ans += 1;
                    chars[index++] = curr;
                } else {
                    chars[index++] = curr;
                    String s = Integer.toString(cnt);
                    for (char ss : s.toCharArray()) {
                        chars[index++] = ss;
                    }
                    ans += 1 + s.length();
                }
            }
        }
        return ans;
    }
}
