package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1197MinimumKnightMoves {

    public Map<String,Integer> map = new HashMap<>();
    /*没啥好说的，看吧。真的是niubility！*/
    public int minKnightMoves(int x, int y){
        if(x<0) x=-x;
        if(y<0) y=-y;

        String pos = x+" "+y;
        if(map.containsKey(pos)) return map.get(pos);

        if(x+y==0 || x+y==2){
            return x+y;
        }

        int ans = Math.min(minKnightMoves(x-2, y-1), minKnightMoves(x-1, y-2)) + 1;
        map.putIfAbsent(pos,ans);
        return ans;
    }
///*
//* BFS遍历找最短路径问题
//* */
//    public int minKnightMoves(int x, int y) {
//        if (x < 0) x = -x;
//        if (y < 0) y = -y;
//        x = x + 1;
//        y = y + 1;
//        /*
//        * 这样操作是为了让原点变为（1，1）
//        * 边界条件容易操作：line24
//        * 因为如果原点是（0，0），就不好操作中间步骤为类似（-1，-1）这样的情况
//        * */
//        int[][] grid = new int[x + 4][y + 4];
//        int[][] steps = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2},
//                                    {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(new Node(x, y, 0));
//        while (!queue.isEmpty()) {
//            Node curr = queue.poll();
//            if (curr.x >= 0 && curr.y >= 0 && curr.x < grid.length && curr.y < grid[0].length) {
//                if (grid[curr.x][curr.y] != 0) continue;
//                grid[curr.x][curr.y] = -1;
//                int currStep = curr.dist;
//                if (curr.x == 1 && curr.y == 1) return currStep;
//                for (int[] step : steps) {
//                    int newX = curr.x + step[0];
//                    int newY = curr.y + step[1];
//                    queue.offer(new Node(newX, newY, currStep + 1));
//                }
//            }
//        }
//        return -1;
//    }
//
//    class Node {
//        int x;
//        int y;
//        int dist;
//        public Node(int _x, int _y, int _dist) {
//            x = _x;
//            y = _y;
//            dist = _dist;
//        }
//    }
}
