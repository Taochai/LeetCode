package leetcode;

import java.util.Stack;

public class Leetcode1003 {
    public boolean isValid(String S) {
        // // stack
        // if(S.length()==0) return true;
        // Stack<Character> stack = new Stack<>();
        // for(char c: S.toCharArray()){
        //     if(c=='c'){
        //         if(stack.isEmpty() || stack.peek()!='b'){
        //             return false;
        //         }else{
        //             stack.pop();  // pop 'b';
        //             if(stack.isEmpty() || stack.peek()!='a'){
        //                 return false;
        //             }else{
        //                 stack.pop(); // pop 'a';
        //             }
        //         }
        //     }else{
        //         stack.push(c);
        //     }
        // }
        // return stack.isEmpty();
        if(S.charAt(0)!='a' || S.charAt(S.length()-1)!='c' || !S.contains("abc")){
            return false;
        }
        while(S.contains("abc")){
            S = S.replace("abc","");
        }
        return S.length()==0;
    }
}
