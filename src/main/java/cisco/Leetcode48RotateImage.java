package cisco;

public class Leetcode48RotateImage {
    // 对角线交换  ----->
    // 左右交换
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int row = 0; row < N - 1; row++) {
            for (int col = row + 1; col < N; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = tmp;
            }
        }
    }
}
