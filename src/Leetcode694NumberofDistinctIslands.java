import java.util.*;
public class Leetcode694NumberofDistinctIslands {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    helper(grid,i,j,0,0,sb);
                    String s = sb.toString();
                    if(!set.contains(s)){
                        ans++;
                        set.add(s);
                    }
                }
            }
        }
        return ans;
    }
    public void helper(int[][] grid,int i, int j, int posr, int posc, StringBuilder sb){
        grid[i][j] = 0;
        sb.append(posr+""+posc);
        for(int[] dir : dirs){
            int newr = i + dir[0];
            int newc = j + dir[1];
            if(newr>=grid.length || newr<0 || newc >=grid[0].length || newc<0 || grid[newr][newc]==0) continue;
            helper(grid, newr, newc, posr+dir[0], posc+dir[1],sb);
        }
    }
}
