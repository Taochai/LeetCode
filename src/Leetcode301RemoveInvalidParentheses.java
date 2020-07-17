import java.util.ArrayList;
import java.util.List;

public class Leetcode301RemoveInvalidParentheses {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int l = 0, r = 0;
            for(char c : s.toCharArray()){
                if(c=='(') l++;
                if(c==')'){
                    if(l>0) l--;
                    else{
                        r++;
                    }
                }
            }
            List<String> ans = new ArrayList<>();
            dfs(s,0,l,r,ans);
            return ans;

        }
        private void dfs(String s, int start, int l, int r, List<String> ans){
            if(l==0 && r==0){

                if(isValid(s)) ans.add(s);
                return;
            }
//            for(int i=start;i<s.length();i++){
//                if(i!=start && s.charAt(i)==s.charAt(i-1)) continue;
//                if(s.charAt(i)=='(' || s.charAt(i)==')'){
//                    String curr = s.substring(0,i)+s.substring(i+1);
//                    if(r>0 && s.charAt(i)==')') dfs(curr,i,l,r-1,ans);
//                    else if(l>0 && s.charAt(i)=='(') dfs(curr,i,l-1,r,ans);
//                }
//            }
            for(int i=start;i<s.length();i++){
                if(i!=start && s.charAt(i)==s.charAt(i-1)) continue;
                if(s.charAt(i)=='(' && l>0){
                    String curr = s.substring(0,i)+s.substring(i+1);
                    // if(!isValid(curr)) continue;
                    if(l>0){
                        dfs(curr,i,l-1,r,ans);
                    }
                }
                else if(s.charAt(i)==')' && r>0){
                    String curr = s.substring(0,i)+s.substring(i+1);
                    // if(!isValid(curr)) continue;
                    if(r>0){
                        dfs(curr,i,l,r-1,ans);
                    }
                }
            }

        }

        private boolean isValid(String s){
            int cnt = 0;
            for(char c: s.toCharArray()){
                if(c=='(') cnt++;
                if(c==')') cnt--;
                if(cnt<0) return false;
            }
            return cnt==0;
        }
    }
}
