public class Leetcode547FriendCircles {
    public int findCircleNum(int[][] M){
        int ans = 0;
        boolean[] visited = new boolean[M.length];
        for(int i=0;i<M.length;i++){
            if(!visited[i]){
                dfs(visited,M,i);
                ans++;
            }
        }
        return ans;
    }
    private void dfs(boolean[] visited, int[][] M, int i){
        for(int j=0;j<M[0].length;j++){
            if(M[i][j]==1 && !visited[j]){
                visited[j] = true;
                dfs(visited,M,j);
            }
        }
    }

//     public int findCircleNum(int[][] M) {
//         if(M.length==0 || M[0].length==0) return 0;
//         int ans = 0;
//         for(int i=0;i<M.length;i++){
//             for(int j=0;j<M[0].length;j++){
//                 if(M[i][j]==1){
//                     ans++;
//                     dfs(i,j,M);
//                 }
//             }
//         }
//         return ans;
//     }
//     private void dfs(int i, int j, int[][] M){
//         if(i<0 || j<0 || i>=M.length || j>=M[0].length) return;
//         if(M[i][j]==0) return;
//         M[i][j] = 0;
//         for(int m=0;m<M.length;m++){
//             if(M[m][j]==1) dfs(m,j,M);
//             M[m][j] = 0;
//         }
//         for(int n=0;n<M[0].length;n++){
//             if(M[i][n]==1) dfs(i,n,M);
//             M[i][n] = 0;
//         }

//     }
}
