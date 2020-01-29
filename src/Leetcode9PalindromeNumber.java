public class Leetcode9PalindromeNumber {
    /*
    1st time从两头比较
*/
        public boolean isPalindrome(int x) {
            if(x<0) return false;
            if(x==0) return true;
            int div = 1;
            while(x/div>=10){
                div = div*10;
            }
            int left=0,right=0;
            while(x!=0){
                left = x/div;
                right = x%10;
                if(left!=right) return false;
                x = (x-div*left)/10;
                div /=100;
            }
            return true;
        }

}
