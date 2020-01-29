import java.util.ArrayList;
import java.util.List;

public class Leetcode866PrimePalindrome {
/*
1st time
两个function，判断是否prime，判断是否是palindrome.
Time Limit Exceeded
*/
//        public int primePalindrome(int N) {
//            while(true){
//                if(prime(N) && palindrome(N)){
//                    return N;
//                }
//                N++;
//            }
//        }
//        public boolean prime(int n){
//            //corner case
//            if(n==1) return false;
//            if(n==2) return true;
//            for(int i=2;i<=n/2;i++){
//                if(n%i==0) return false;
//            }
//            return true;
//        }
//        public boolean palindrome(int n){
//            if(n<10) return true;
//            List<Integer> l = new ArrayList<>();
//            while(n!=0){
//                l.add(n%10);
//                n = n/10;
//            }
//            for(int i=0;i<l.size()/2;i++){
//                if(l.get(i)!=l.get(l.size()-1-i)) return false;
//            }
//            return true;
//        }

}
