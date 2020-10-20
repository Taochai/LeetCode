package leetcode;

public class Leetcode277 {
    // public int findCelebrity(int n) {
    //     int[] candidate = new int[n];
    //     //0---> 是  1--->不是
    //         for(int i=0;i<n;i++){
    //             if(candidate[i]==1) continue;
    //             for(int j=0;j<n;j++){
    //                 if(i==j) continue;
    //                 if(knows(i,j) || !knows(j,i)){
    //                     candidate[i] = 1;
    //                     break;
    //                 }else{
    //                     candidate[j] = 1; // else j knows i
    //                 }
    //             }
    //             if(candidate[i]==0) return i;
    //         }
    //     return -1;
    // }
    /////////////////////////////////////////////////////////////
    public int findCelebrity(int n){
        int ans = 0;
        for(int i=0;i<n;i++){
            if(knows(ans,i)) ans = i;
        }
        for(int i=0;i<n;i++){
            if((ans!=i && knows(ans,i)) || !knows(i,ans) ) return -1;
        }
        return ans;
    }
    //防止报错随便写的
    private boolean knows(int ans, int i) {
        return true;
    }
}
