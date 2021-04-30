package leetcode;

/*给定两个以字符串形式表示的非负整num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
        示例 1:
        输入: num1 = "2", num2 = "3"
        输出: "6"

        示例 2:
        输入: num1 = "123", num2 = "456"
        输出: "56088"
        说明：
        num1和num2的长度小于110。
        num1 和num2 只包含数字0-9。
        num1 和num2均不以零开头，除非是数字 0 本身。
        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
*/
public class Leetcode43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String ans = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String tmpResult = multiplyHelper(num1, num2.charAt(i), num2.length() - 1 - i);
            ans = sumTwoString(ans, tmpResult);
        }
        return ans;
    }

    private String sumTwoString(String s1, String s2) {
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//        int sum = 0;
//        int add = 0;
//        while (index < s1.length() && index < s2.length()) {
//            sum = s1.charAt(s1.length() - 1 - index)-'0' + s2.charAt(s2.length()-1-index)-'0' +add;
//            add = sum / 10;
//            sb.append(sum % 10);
//            index++;
//        }
//
//        while (index<s1.length()) {
//            sum = s1.charAt(s1.length() -1 -index )-'0' + add;
//            add = sum / 10;
//            sb.append(sum % 10);
//            index++;
//        }
//        while (index<s2.length()) {
//            sum = s2.charAt(s2.length() -1 -index )-'0' + add;
//            add = sum / 10;
//            sb.append(sum % 10);
//            index++;
//        }
//        if (add == 1) {
//            sb.append(1);
//        }
//        return sb.reverse().toString();
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1;
        int sum = 0, add = 0;
        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            sum = x + y + add;
            sb.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    private String multiplyHelper(String num1, char c, int n) {
        int productNum = c - '0';
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("0");
        }
        int product = 0, add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            product = (num1.charAt(i) - '0') * productNum + add;
            add = product / 10;
            result.append(product % 10);
        }
        if (add != 0) {
            result.append(add);
        }

        return result.reverse().toString();
    }


    public static void main(String[] args) {
        Leetcode43 leetcode43 = new Leetcode43();
//        System.out.println(leetcode43.multiply("2", "3"));
        System.out.println(leetcode43.multiply("123", "456"));
    }
}


//class Solution {
//    public String multiply(String num1, String num2) {
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//        String ans = "0";
//        int m = num1.length(), n = num2.length();
//        for (int i = n - 1; i >= 0; i--) {
//            StringBuffer curr = new StringBuffer();
//            int add = 0;
//            for (int j = n - 1; j > i; j--) {
//                curr.append(0);
//            }
//            int y = num2.charAt(i) - '0';
//            for (int j = m - 1; j >= 0; j--) {
//                int x = num1.charAt(j) - '0';
//                int product = x * y + add;
//                curr.append(product % 10);
//                add = product / 10;
//            }
//            if (add != 0) {
//                curr.append(add % 10);
//            }
//            ans = addStrings(ans, curr.reverse().toString());
//        }
//        return ans;
//    }
//
//    public String addStrings(String num1, String num2) {
//        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
//        StringBuffer ans = new StringBuffer();
//        while (i >= 0 || j >= 0 || add != 0) {
//            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
//            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
//            int result = x + y + add;
//            ans.append(result % 10);
//            add = result / 10;
//            i--;
//            j--;
//        }
//        ans.reverse();
//        return ans.toString();
//    }
//}
