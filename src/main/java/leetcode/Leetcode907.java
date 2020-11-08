package leetcode;

import java.util.Stack;

public class Leetcode907 {
    // public int sumSubarrayMins(int[] A) {
    //     int M = (int)Math.pow(10,9)+7;
    //     int ans = A[0];
    //     int[] dp = new int[A.length];
    //     dp[0] = A[0];
    //     for(int i=1;i<A.length;i++){
    //         if(A[i]>=A[i-1]){
    //             dp[i] = A[i] + dp[i-1];
    //         }else{
    //             int j = i-1;
    //             while(j>=0 && A[i] < A[j]){
    //                 j--;
    //             }
    //             if(j<0){
    //                 dp[i] = (i+1)*A[i];
    //             }else{
    //                 dp[i] = dp[j] + (i-j)*A[i];
    //             }
    //         }
    //         ans = (ans+dp[i])%M;
    //     }
    //     return ans;
    // }
    public int sumSubarrayMins(int[] A) {
        int M = (int)Math.pow(10,9)+7;
        int ans = 0;
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] dp = new int[len+1];
        for(int i=0;i<len;i++){
            while(stack.peek() != -1 && A[i] <=A[stack.peek()]){
                stack.pop();
            }
            dp[i+1] = (dp[stack.peek()+1] + (i-stack.peek())*A[i]);
            stack.push(i);
            ans = (ans + dp[i+1]) % M;
        }
        return ans;
    }
}
