package leetcode;

/*
    1st time: 利用除法，商和余数来reverse
    越界问题，int的上下界 Integer.MAX_VALUE 和 Integer.MIN_VALUE
    reverse的值可能已经超出了界限，用long型来定义reverse的值，与上下界比较，最后再转回int型返回
 */
public class Leetcode7ReverseInteger {
    public int reverse(int x) {
        long ans = 0;
        while(x!=0){
            ans = ans*10 + x%10;
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE ) {
            return 0;
        }
        return (int)ans;
    }
}
