public class Leetcode107 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root==null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> tmpL = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();
                    tmpL.add(node.val);
                    if(node.left!=null) q.add(node.left);                                                         if(node.right!=null) q.add(node.right);
                }
                ans.add(tmpL);
            }
            Collections.reverse(ans);
            return ans;
        }

    }
}
