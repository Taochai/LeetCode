package leetcode;

import java.util.Stack;

public class Leetcode946ValidateStackSequences {

//     public boolean validateStackSequences(int[] pushed, int[] popped) {
//         //corner case
//         if(pushed==null || popped==null || pushed.length==0 || popped.length==0) return true;
//         int i=0, j=0;
//         Stack<Integer> s = new Stack<>();
//         while(j<popped.length){
//             if(s.isEmpty()) s.push(pushed[i]);
//             while(s.peek()!=popped[j] && i<pushed.length){
//                 i++;
//                 if(i>=pushed.length) return false;
//                 s.push(pushed[i]);

        //             }
//             if(i>=pushed.length) return false;
//             s.pop();
//             j++;
//         }
//         return true;
//     }

// O(n)
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            Stack<Integer> s = new Stack<>();
            int j = 0;
            for(int x :pushed){
                s.push(x);
                while(!s.isEmpty() && j < pushed.length && s.peek() == popped[j]){
                    s.pop();
                    j++;
                }
            }
            return j==pushed.length;
        }

}
