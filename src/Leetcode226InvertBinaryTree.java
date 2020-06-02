public class Leetcode226InvertBinaryTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null) return root;
            TreeNode originalL = root.left;
            TreeNode originalR = root.right;
            root.left = invertTree(originalR);
            root.right = invertTree(originalL);

            return root;
        }
    }
}

  /*  Since each node in the tree is visited only once, the time complexity is O(n)O(n), where nn is the number of nodes in the tree. We cannot do better than that, since at the very least we have to visit each node to invert it.

        Because of recursion, O(h)O(h) function calls will be placed on the stack in the worst case, where hh is the height of the tree. Because h\in O(n)h∈O(n), the space complexity is O(n)O(n).*/