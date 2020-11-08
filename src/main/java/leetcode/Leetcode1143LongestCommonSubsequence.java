package leetcode;

public class Leetcode1143LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length(), col = text2.length();
        int[][] lcs = new int[row+1][col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    lcs[i+1][j+1] = 1 + lcs[i][j];
                }else{
                    lcs[i+1][j+1] = Math.max( lcs[i][j+1], lcs[i+1][j] );
                }
            }
        }
        return lcs[row][col];
    }

}
