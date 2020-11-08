package leetcode;

public class Leetcode688 {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp0 = new double[N][N];
        dp0[r][c] = 1;
        int[][] dirs = new int[][]{{1,2},{-1,-2},{1,-2},{-1,2},
                {2,1},{-2,-1},{-2,1},{2,-1}};
        for(int k=0;k<K;k++){
            double[][] dp1 = new double[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x<0 || x>=N || y<0 || y>=N) continue;
                        dp1[x][y] += dp0[i][j];
                    }
                }
            }
            dp0 = dp1;
        }
        double sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum += dp0[i][j];
            }
        }
        return sum/Math.pow(8,K);
    }
}
