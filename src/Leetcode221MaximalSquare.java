public class Leetcode221MaximalSquare {
    /*https://www.youtube.com/watch?v=vkFUB--OYy0*/
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //sum[i][j] = sum(matrix[0][0]---->matrix[i][j]);
        int[][] sums = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sums[i][j] = matrix[i-1][j-1]-'0'
                        +sums[i-1][j]+sums[i][j-1] - sums[i-1][j-1];
            }
        }
        int ans = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                for(int k=Math.min(m-i+1,n-j+1);k>0;k--){
                    int sum = sums[i+k-1][j+k-1]
                            - sums[i+k-1][j-1]
                            - sums[i-1][j+k-1]
                            + sums[i-1][j-1];
                    if(sum==k*k){
                        ans = Math.max(ans,sum);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /*
    * Method:
    * 寻找所有的可能的正方形，求最大的面积。
    * 第一个循环 上边界，第二个循环 下边界， 第三个循环计算上下边界之间的sum，sum==上下边界之差，
    * helper()计算连续的多少个满足条件的情况。 多少个连着的sum==j-i+1
    * */
//    class Solution {
//        public int maximalSquare(char[][] matrix) {
//            if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
//            int ans = 0;
//            for(int i=0;i<matrix.length;i++){
//                int[] sum = new int[matrix[0].length];
//                for(int j=i;j<matrix.length;j++){
//                    for(int m=0;m<matrix[0].length;m++){
//                        if(matrix[j][m]=='1') sum[m]++;
//                    }
//                    ans = Math.max(ans,helper(sum,j-i+1));
//                }
//            }
//            return ans;
//        }
//        private int helper(int[] arr, int n){
//            if(n>arr.length) return 0;
//            int count = 0;
//            for(int i=0;i<arr.length;i++){
//                if(arr[i]==n){
//                    count++;
//                }else{
//                    count = 0;
//                }
//                if(count==n) return n*n;
//            }
//            return 0;
//
//        }
//    }



}
