package leetcode;

import java.util.Stack;

public class Leetcode227BasicCalculator2 {

    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int num = 0; //num first factor
        char lastOperator = '+'; // first operator is '+'
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' ' && i!=s.length()-1) continue;
            if(Character.isDigit(c)){
                num = num*10 + c - '0';

            }
            //如果是操作符，就分析之前的那个操作符，是* / 就处理，stack.peek()+  操作符 + num;
            if(!Character.isDigit(c) || i==s.length()-1){

                if(lastOperator=='+'){
                    stack.push(num);

                }
                else if(lastOperator=='-'){
                    stack.push(-1*num);

                }
                else if(lastOperator=='*'){
                    stack.push(stack.pop()*num);
                }
                else if(lastOperator=='/'){
                    stack.push(stack.pop()/num);
                }
                num = 0;
                lastOperator = c;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
