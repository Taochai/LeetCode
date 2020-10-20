package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode95UniqueBinarySearchTree2 {
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
        List<TreeNode> ans = new ArrayList<>();
        public List<TreeNode> generateTrees(int n) {
            if(n==0) return ans;
            return helper(1,n);
        }

        private List<TreeNode> helper(int start, int end){
            List<TreeNode> l = new ArrayList<>();
            if(start>end){
                l.add(null);
                return l;
            }
            if(start==end){
                l.add(new TreeNode(start));
                return l;
            }

            for(int i=start;i<=end;i++){
                List<TreeNode> Lnodes = helper(start,i-1);
                List<TreeNode> Rnodes = helper(i+1,end);
                for(TreeNode Lnode : Lnodes){
                    for(TreeNode Rnode : Rnodes){
                        TreeNode root = new TreeNode(i);
                        root.left = Lnode;
                        root.right = Rnode;
                        l.add(root);
                    }
                }
            }
            return l;
        }

    }
}
