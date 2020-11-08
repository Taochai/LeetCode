package leetcode;

public class Leetcode463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid == null || grid[0].length == 0)
            return 0;

        int result = 0;
        //iterate over the matrix
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //each time you find a 1, increase by 4
                if(grid[i][j] == 1){
                    result += 4;

                    //each time you find a 1 to left or top decrease 2
                    //can also search right or bottom.
                    // because left and right share one same edge.
                    //curr右边有1，右边的左边必定有1 --> curr
                    if(i > 0 && grid[i - 1][j] == 1)
                        result -= 2;
                    if(j > 0 && grid[i][j - 1] == 1)
                        result -= 2;
                }
            }
        }
        return result;
    }

}
