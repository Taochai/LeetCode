package leetcode;

public class Leetcode997 {

    public int findJudge(int N, int[][] trust) {
        int[] judge = new int[N+1];
        //0代表能行，-1代表不行
        for(int[] t : trust){
            judge[t[0]] = -1;
            if(judge[t[1]]==-1){
                continue;
            }
            judge[t[1]]++;

        }
        for(int i=1;i<N+1;i++){
            if(judge[i]==N-1) return i;
        }
        return -1;
    }

}
