public class Leetcode110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-2;
    }
    public int helper(TreeNode node){
        if(node==null) return -1;
        int lh = helper(node.left);
        int rh = helper(node.right);
        if(lh==-2 || rh==-2 || Math.abs(lh-rh)>1) return -2;
        return Math.max(lh,rh)+1; //在这一步更新height的值，+1. 因为要提前判断之前的helper()会不会返回-2.如果返回-2，就直接返回-2。+1写在前面的话会导致-2变成-1

    }
}
   class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
