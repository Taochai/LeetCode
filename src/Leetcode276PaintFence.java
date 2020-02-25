public class Leetcode276PaintFence {
    public int numWays(int n, int k) {
        //corner case
        if(n==0) return 0;
        if(n==1) return k;
        int same = k;
        int diff = k*(k-1);
        for(int i=2;i<n;i++){
            int tmpSame = diff;
            diff = same*(k-1) +diff*(k-1);
            same = tmpSame;
        }
        return diff+same;
    }
}
