package leetcode;

/*
1st time: 0-->1 变成 2， 1-->0 变成3， 最后再把2和3处理回1和0，全程inorder操作。
 */
public class Leetcode289GameofLife {
    int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                update(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2) board[i][j] = 1;
                if(board[i][j]==3) board[i][j] = 0;
            }
        }
    }
    private void update(int[][] board, int row, int col){
        int nR = row, nC = col;
        int cnt = 0;
        for(int[] dir : dirs){
            nR = row + dir[0];
            nC = col + dir[1];
            if(nR<0 || nR>=board.length || nC<0 || nC>=board[0].length) continue;
            if(board[nR][nC]==1 || board[nR][nC]==3) cnt++;
        }
        if(board[row][col]==1){
            if(cnt<2) board[row][col] = 3;
            else if(cnt>3) board[row][col] = 3;
        }
        if(board[row][col]==0){
            if(cnt==3) board[row][col] = 2;
        }
    }
}
