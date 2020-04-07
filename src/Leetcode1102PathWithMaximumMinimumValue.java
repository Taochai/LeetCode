import java.util.*;
public class Leetcode1102PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        int r = A.length, c = A[0].length;
        int min = Math.min(A[0][0],A[r-1][c-1]);
        PriorityQueue<Unit> pq = new PriorityQueue<>((x1,x2)-> x2.value-x1.value);
        int[][] visited = new int[r][c];
        int i=0,j=0;
        while(i!=r-1 || j!=c-1){
            visited[i][j]=1;
            if(i-1>=0 && visited[i-1][j]==0){
                visited[i-1][j]=1;
                pq.offer(new Unit(i-1,j,A[i-1][j]));
            }
            if(i+1<r && visited[i+1][j]==0){
                if(i+1==r && j==c) return min;
                visited[i+1][j]=1;
                pq.offer(new Unit(i+1,j,A[i+1][j]));
            }
            if(j-1>=0 && visited[i][j-1]==0){
                visited[i][j-1]=1;
                pq.offer(new Unit(i,j-1,A[i][j-1]));
            }
            if(j+1<c && visited[i][j+1]==0){
                if(i==r && j+1==c) return min;
                visited[i][j+1]=1;
                pq.offer(new Unit(i,j+1,A[i][j+1]));
            }
            Unit next = pq.poll();
            if(next.value<min) min = next.value;
            i=next.x;
            j=next.y;
        }
        return min;
    }
    class Unit{
        int x;
        int y;
        int value;
        public Unit(int _x, int _y, int _value){
            this.x=_x;
            this.y=_y;
            this.value=_value;
        }
    }
}
