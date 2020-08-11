public class Leetcode14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder sb = new StringBuilder();
        String s = strs[0];

        for(int i=0;i<s.length();i++){
            for(String str : strs){
                if(i>=str.length() || str.charAt(i)!=s.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
