package imcOA;

public class Artifacts {
    public static void main(String[] args) {
        int N = 4;
//        String s1 ="1B 2C,2D 4D";
//        String s2 ="2B 2D 3D 4D 4A";
        String s1 ="1A 1B,2C 2C";
        String s2 ="1B";
        System.out.println(solution(N,s1,s2)[0]);
        System.out.println(solution(N,s1,s2)[1]);
    }

    public static int[] solution(int N, String artifacts, String searched){
        int[] ans = new int[2];
        //corner case
        if(artifacts.length()==0 || searched.length()==0) return ans;
        int[][] grid = createGrid(N,searched);
        String[] ss = artifacts.split(",");
        //        s是一个小的范围
        for(String s : ss){
            String[] pos = s.split(" ");
            int[] leftTop = new int[2];
            leftTop[0] = Integer.parseInt(pos[0].substring(0,pos[0].length()-1)) - 1;
            leftTop[1] =pos[0].charAt(pos[0].length()-1)-'A';
            int[] rightBot = new int[2];
            rightBot[0] = Integer.parseInt(pos[1].substring(0,pos[1].length()-1)) - 1;
            rightBot[1] =pos[1].charAt(pos[1].length()-1)-'A';
            int count = 0;
            int size = (rightBot[1]-leftTop[1]+1)*(rightBot[0]-leftTop[0]+1);
            for(int i=leftTop[0];i<=rightBot[0];i++){
                for (int j=leftTop[1];j<=rightBot[1];j++){
                    if(grid[i][j]==1){
                        count++;
                    }
                }
            }
            if(count==size) ans[0]++;
            if(count>0 && count<size) ans[1]++;
        }
        return ans;
    }

    private static int[][] createGrid(int N, String searched){
        String[] searchedPosition = searched.split(" ");
        int[][] grid = new int[N][N];
        for(String s : searchedPosition){
            int row = Integer.parseInt(s.substring(0,s.length()-1)) - 1;
            int col = s.charAt(s.length()-1)-'A';
            grid[row][col] = 1;
        }
        return grid;
    }

}
