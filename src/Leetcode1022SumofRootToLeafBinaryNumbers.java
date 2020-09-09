public class Leetcode1022SumofRootToLeafBinaryNumbers {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(0,root);
        return ans;
    }
    private void helper(int sum, TreeNode root){
        int tmpSum = sum*2+root.val;
        if(root.left==null && root.right==null){
            ans+=tmpSum;
            return;
        }
        if(root.left!=null) helper(tmpSum,root.left);
        if(root.right!=null) helper(tmpSum,root.right);
    }
}
