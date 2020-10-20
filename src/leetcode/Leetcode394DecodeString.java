package leetcode;

//还有一种stack的写法。
public class Leetcode394DecodeString {

    int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        for(int i=pos;i<s.length();i++){
            if(s.charAt(i)!='[' && s.charAt(i)!=']' && !Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            else if(Character.isDigit(s.charAt(i))){
                num += s.charAt(i);
            }
            else if(s.charAt(i)=='['){
                pos = i+1; // 让下一次递归从'['后面开始；
                String next = decodeString(s);
                for (int n = Integer.valueOf(num); n > 0; n--) sb.append(next);
                num = ""; // num重新置为0，因为可能有这种情况2[a]3[b]，防止出现23次b
                i = pos;
            }else{
                pos = i;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
