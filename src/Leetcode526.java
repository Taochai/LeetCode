public class Leetcode526 {
/*
* 其实就是对于每一个位置，遍历所有可能的数，如果满足条件，就走一个位置，找出所有的组合。
* 如果没有满足的，for循环结束后helper函数也结束了。
*
* */
    int ans = 0;
    public int countArrangement(int N) {
        int[] used = new int[N+1];
        helper(N,1,used);
        return ans;
    }
    private void helper(int N, int pos, int[] used){
        if(pos>N){
            ans++;
            return;
        }
        for(int i=1;i<=N;i++){
            if(used[i]==0 && (i%pos==0 || pos%i==0)){
                used[i]=1;
                helper(N,pos+1,used);
                used[i]=0;
            }
        }
    }
}
