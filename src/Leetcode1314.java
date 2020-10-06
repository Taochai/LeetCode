public class Leetcode1314 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length, col = mat[0].length;
        int[][] preSum = new int[row][col];
        for(int i=0;i<row;i++){
            int sum = 0;
            for(int j=0;j<col;j++){
                sum += mat[i][j];
                preSum[i][j] = sum;
                if(i>0) preSum[i][j] += preSum[i-1][j];
            }
        }

        int[][] ans = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int x1 = Math.max(0,i-K);
                int y1 = Math.max(0,j-K);
                int x2 = Math.min(row-1,i+K);
                int y2 = Math.min(col-1,j+K);
                ans[i][j] = preSum[x2][y2];
                if(x1>0) ans[i][j] -= preSum[x1-1][y2];
                if(y1>0) ans[i][j] -= preSum[x2][y1-1];
                if(x1>0 && y1>0) ans[i][j] += preSum[x1-1][y1-1];
            }
        }
        return ans;
    }

}
