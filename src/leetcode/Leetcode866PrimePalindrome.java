package leetcode;

public class Leetcode866PrimePalindrome {
    /*
    1st time
    找出大于N的所有回文数，判断是否prime.
    偶数的回文数一定会被11整除
    xy => xyx x(0->9)
    xyz => xyzyx xy(10->99)
    最大的ans小于2*10^8， 其前置最大为20,000
    String 没有reverse, 有toCharArray();
    StringBuilder有reverse
    Math.pow(a,b)是double，要转成int。
    isPrime写的很有趣。
    下一次再优化吧，电脑莫名嘟的响。。。
*/
        public int primePalindrome(int N) {
            if(N<=2) return 2;
            if(N<=3) return 3;
            if(N<=5) return 5;
            if(N<=7) return 7;
            if(N<=11) return 11;
            String str = Integer.toString(N);
            int ex = str.length()/2;
            for(int i=(int)Math.pow(10,ex);i<20000;i++){
                String s = Integer.toString(i);
                String s1 = s.substring(0,s.length()-1);
                StringBuilder s2 = new StringBuilder(s1);
                s2.reverse();
                String s3 = s2.toString();
                s = s+s3;
                int sValue = Integer.parseInt(s);
                if(sValue>=N && isPrime(sValue)) return sValue;
            }
            return -1;
        }
        public boolean isPrime(int n){
            if(n%2==0) return n==2;
            for(int i=3;i*i<=n;i+=2){
                if(n%i==0) return false;
            }
            return true;
        }

}
