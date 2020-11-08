package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94BinaryTreeInorderTraversal {
//    List<Integer> ans = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        helper(root);
//        return ans;
//    }
//    private void helper(TreeNode root){
//        if(root==null) return;
//        inorderTraversal(root.left);
//        ans.add(root.val);
//        inorderTraversal(root.right);
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
