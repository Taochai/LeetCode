public class leetcode438 {
    public static void main(String[] args) {
        System.out.println("hello 438");
    }
}

// 1st time
// 记录每一行，每一列，对角线和反对角线的和， 判断和==n
class TicTacToe {
    int[] rows;
    int[] cols;
    int diag;
    int Rdiag;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.Rdiag = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int N = this.rows.length;
        int chess = player == 1 ? 1 : -1;
        this.rows[row] += chess;
        this.cols[col] += chess;
        if(row==col) this.diag += chess;
        if(row==N-1-col) this.Rdiag += chess;
        if(Math.abs(this.rows[row])==N || Math.abs(this.cols[col])==N || Math.abs(this.diag)==N || Math.abs(this.Rdiag)==N){
            return player;

        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

