package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202HappyNumber {
    class Solution {
        public boolean isHappy(int n) {
            if(n==1) return true;
            Set<Integer> set = new HashSet<Integer>();
            set.add(n);
            while(n!=1){
                n = helper(n);
                if(set.contains(n)) return false;
                set.add(n);
            }
            return true;
        }
        public int helper(int n){
            int num = 0;

            while(n>=10){
                num += (n%10) * (n%10);
                n /= 10;
            }
            return num+ n*n;
        }
    }
}
