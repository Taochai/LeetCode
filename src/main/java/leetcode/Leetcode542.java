package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x<0 || x>=m || y<0 || y>=n || matrix[x][y]<=matrix[curr[0]][curr[1]]+1) continue;
                matrix[x][y] = matrix[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{x,y});
            }
        }
        return matrix;
    }

}
