package leetcode;

/*
    1.每个cell代表走到这里需要多少步
    2.grid[i][j] = grid[i-1][j]+grid[i][j-1]
    3.初始化，第一行，第一列全为0

*/
public class Leetcode62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) grid[i][j]=1;
                else{
                    grid[i][j] = grid[i-1][j] +grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
