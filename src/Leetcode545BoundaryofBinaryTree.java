import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode545BoundaryofBinaryTree {
      public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

//1st time: 把原问题分成三个子问题来做left，leaf，right。
//找leaf用BFS不对。
//time complexity: O(n).
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            //corner case:
            if(root==null) return new ArrayList<Integer>();
            List<Integer> ans = new ArrayList<>();
            if(!isLeaf(root)){
                ans.add(root.val);
            }
            //  part 1:
            TreeNode t = root.left;
            while(t!=null){
                if(!isLeaf(t)) ans.add(t.val);
                if(t.left!=null) t = t.left;
                else{
                    t = t.right;
                }
            }
            // part 2
            addLeaves(ans,root);
            // part 3
            Stack<Integer> s = new Stack<>();
            t = root.right;
            while(t!=null){
                if(!isLeaf(t)){
                    s.push(t.val);
                }
                if(t.right!=null) t = t.right;
                else{
                    t = t.left;
                }
            }
            while(!s.isEmpty()){
                ans.add(s.pop());
            }
            return ans;
        }
        public boolean isLeaf(TreeNode node){
            return node.left==null && node.right==null;
        }
        public void addLeaves(List<Integer> ans, TreeNode root){
            if(isLeaf(root)) ans.add(root.val);
            else{
                if(root.left!=null) addLeaves(ans,root.left);
                if(root.right!=null) addLeaves(ans,root.right);
            }
        }

}
