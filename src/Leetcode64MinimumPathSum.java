public class Leetcode64MinimumPathSum {
    public int minPathSum(int[][] grid) {

        //each cell means the minimum path
        //grid[i][j] = grid[i][j] + Math.min(left,up)
        //initialization: first row & first column
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) continue;
                else if(i==0) grid[i][j] = grid[i][j] + grid[i][j-1];
                else if(j==0) grid[i][j] = grid[i][j] + grid[i-1][j];
                else{
                    grid[i][j] = grid[i][j] + Math.min( grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        int r = grid.length;
        int c = grid[0].length;
        return grid[r-1][c-1];
    }
}
