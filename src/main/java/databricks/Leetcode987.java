//package databricks;
//
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.TreeMap;
//
//public class Leetcode987 {
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        if(root==null) return new ArrayList<>();
//        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(root,0,0,map);
//        for(TreeMap<Integer,PriorityQueue<Integer>> y:map.values()){
//            res.add(new ArrayList<>());
//            for(PriorityQueue<Integer> nodes : y.values()){
//                while(!nodes.isEmpty()){
//                    res.get(res.size()-1).add(nodes.poll());
//                }
//            }
//        }
//        return res;
//    }
//    private void dfs(TreeNode root, int x, int y, TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map){
//        if(root==null) return;
//        // x --> column
//        if(!map.containsKey(x)){
//            map.put(x,new TreeMap<>());
//        }
//        // y --> row
//        if(!map.get(x).containsKey(y)){
//            map.get(x).put(y,new PriorityQueue<>());
//        }
//        map.get(x).get(y).offer(root.val);
//        dfs(root.left,x-1,y+1,map);
//        dfs(root.right,x+1,y+1,map);
//    }
//}
