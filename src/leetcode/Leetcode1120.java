package leetcode;

public class Leetcode1120 {
    double ans = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return ans;
    }

    private double[] helper(TreeNode root){
        if(root==null){
            return new double[]{0, 0.0}; //number，sum
        }
        double[] left = helper(root.left);
        double[] right = helper(root.right);
        double avg = (left[1]+right[1]+root.val)/(1+left[0]+right[0]);
        ans = Math.max(avg,ans);
        return new double[]{1+left[0]+right[0],left[1]+right[1]+root.val};
    }
}
