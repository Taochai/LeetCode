package leetcode;

/*
2nd time: 把原字符串分组，找规律。
 */
public class Leetcode6ZigZagConversion {
    public String convert(String s, int numRows) {
        //corner case:
        if(s.length()==0 || s.length()==1 || numRows==1) return s;

        String[] arr = new String[numRows];
        for(int i=0;i<numRows;i++){
            arr[i] = "";
        }
        int a = 2*numRows - 2;
        for(int i=0;i<s.length();i++){
            int index = i % a;
            if(index<numRows){
                arr[index] += s.charAt(i);
            }else{
                arr[a-index] += s.charAt(i);
            }
        }
        String ans = "";
        for(int i=0;i<numRows;i++){
            ans += arr[i];
        }
        return ans;
    }
}
