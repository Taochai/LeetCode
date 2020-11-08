package leetcode;

public class Leetcode191Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1); // 消除n里最右的一个1
        }
        return count;
    }
}
