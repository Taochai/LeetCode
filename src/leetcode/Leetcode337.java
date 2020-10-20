package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode337 {
    //     //递归函数返回的是到该节点为止的最大值
//     public int rob(TreeNode root) {
//         if(root==null) return 0;
//         int ll = root.left == null ? 0 : rob(root.left.left);
//         int lr = root.left == null ? 0 : rob(root.left.right);
//         int rl = root.right == null ? 0 : rob(root.right.left);
//         int rr = root.right == null ? 0 : rob(root.right.right);
//         return Math.max((root.val+ll+lr+rl+rr),rob(root.left)+rob(root.right));


//     }

    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int ll = root.left != null ? rob(root.left.left) : 0;
        int lr = root.left != null ? rob(root.left.right) : 0;
        int rr = root.right != null ? rob(root.right.right) : 0;
        int rl = root.right != null ? rob(root.right.left) : 0;
        int var = root.val + ll + lr + rr + rl;
        memo.put(root, Math.max((rob(root.left) + rob(root.right)), var));
        return memo.get(root);
    }
}
