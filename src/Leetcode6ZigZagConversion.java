public class Leetcode6ZigZagConversion {
    // 1st time:
    // 找规律就ok了
    // 时间复杂度: O(n)
        public String convert(String s, int numRows) {
            // corner case:
            if(numRows<=1) return s;
            StringBuilder[] sb = new StringBuilder[numRows];
            //初始化数组
            for(int i=0;i<numRows;i++){
                sb[i] = new StringBuilder("");
            }
            //遍历input string
            for(int i=0;i<s.length();i++){
                int index = i % (2*numRows-2);
                index = index < numRows ? index : 2*numRows -2 - index;
                sb[index].append(s.charAt(i));
            }
            StringBuilder ans = new StringBuilder("");
            for(int i=0;i<sb.length;i++){
                ans.append(sb[i]);
            }
            return ans.toString();
        }


}
