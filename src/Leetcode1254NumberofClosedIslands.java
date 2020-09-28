public class Leetcode1254NumberofClosedIslands {
//            [0,0,1,1,0,1,0,0,1,0],
//            [1,1,0,1,1,0,1,1,1,0],
//            [1,0,1,1,1,0,0,1,1,0],
//            [0,1,1,0,0,0,0,1,0,1],
//            [0,0,0,0,0,0,1,1,1,0],
//            [0,1,0,1,0,1,0,1,1,1],
//            [1,0,1,0,1,1,0,0,0,1],
//            [1,1,1,1,1,1,0,0,0,0],
//            [1,1,1,0,0,1,0,1,0,1],
//            [1,1,1,0,1,1,0,1,1,0];
/*
*   先把边界为0的情况用dfs处理掉，然后再全局dfs，ans++
* */
    int ans = 0;
    public int closedIsland(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            dfs(i,0,grid);
            dfs(i,grid[0].length-1,grid);
        }
        for(int j=0;j<grid[0].length;j++){
            dfs(0,j,grid);
            dfs(grid.length-1,j,grid);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    private void dfs(int i, int j, int[][] grid){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1) return;
        if(grid[i][j]==1) return;
        grid[i][j]=1;
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
    }
}
