public class Leetcode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0 || board[0].length==0) return board;
        int m=board.length, n=board[0].length, r = click[0], c = click[1];
        int cnt = 0;
        int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        if(board[r][c]=='M'){
            board[r][c] = 'X';
        }
        else{
            for(int[] dir : dirs){
                int x = r + dir[0];
                int y = c + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                if(board[x][y]=='M') cnt++;
            }
            // judge cnt
            if(cnt>0){
                board[r][c] = (char)('0'+cnt);
            }else{
                board[r][c] = 'B';
                for(int[] dir : dirs){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if(board[x][y]=='E') updateBoard(board,new int[]{x,y});
                }
            }

        }
        return board;
    }
}
