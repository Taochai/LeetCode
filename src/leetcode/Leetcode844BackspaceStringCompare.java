package leetcode;

public class Leetcode844BackspaceStringCompare {
//  用两个stack做这个问题也挺好的
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = helper(S);
        StringBuilder sb2 = helper(T);
        System.out.println(sb1);
        System.out.println(sb2);
        return sb1.toString().equals(sb2.toString());
    }
    private StringBuilder helper(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(sb.length()!=0) sb.deleteCharAt(sb.length()-1);

            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb;
    }
}
