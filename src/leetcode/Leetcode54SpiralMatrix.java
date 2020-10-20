package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix.length==0 || matrix[0].length==0) return new ArrayList<>();
            int l=0,bot=matrix.length-1,r=matrix[0].length-1,top=0;
            int judge = 0, row=0,col=0;
            List<Integer> ans = new ArrayList<>();
            while(l<=r && top<=bot ){
                if(judge==0){
                    for(col=l;col<=r;col++){
                        ans.add(matrix[row][col]);
                    }
                    col--;
                    judge=1;
                    top++;
                }
                else if(judge==1){
                    for(row=top;row<=bot;row++){

                        ans.add(matrix[row][col]);
                    }
                    row--;
                    judge=2;
                    r--;
                }
                else if(judge==2){
                    for(col=r;col>=l;col--){
                        ans.add(matrix[row][col]);
                    }
                    col++;
                    judge=3;
                    bot--;
                }
                else if(judge==3){
                    for(row=bot;row>=top;row--){
                        ans.add(matrix[row][col]);

                    }
                    row++;
                    judge=0;
                    l++;
                }
            }
            return ans;


        }
    }
// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         if(matrix.length==0 || matrix[0].length==0) return new ArrayList<>();
//         int l=0,bot=matrix.length-1,r=matrix[0].length-1,top=0;
//         int row=0,col=0;
//         List<Integer> ans = new ArrayList<>();
//         while(l<=r && top<=bot ){

//                 for(col=l;col<=r;col++){
//                     ans.add(matrix[row][col]);
//                 }
//                 col--;
//                 top++;

//                 for(row=top;row<=bot;row++){
//                     ans.add(matrix[row][col]);
//                 }
//                 row--;
//                  r--;

//             if(top<=bot){
//                 for(col=r;col>=l;col--){
//                     ans.add(matrix[row][col]);
//                 }
//                 col++;
//                 bot--;
//             }
//             if(l<=r){
//                 for(row=bot;row>=top;row--){
//                     ans.add(matrix[row][col]);

//                 }
//                 row++;
//                 l++;
//             }
//         }
//         return ans;


//     }
// }
}
