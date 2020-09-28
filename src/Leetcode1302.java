public class Leetcode1302 {
    // BFS---------------------------------------
//    public int deepestLeavesSum(TreeNode root) {
//        if(root==null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        // int ans = 0;
//        queue.add(root);
//        int ans = 0;
//        boolean deepest = false;
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            ans = 0;
//            for(int i=0;i<size;i++){
//                TreeNode curr = queue.poll();
//                ans += curr.val;
//                if(curr.left!=null) queue.offer(curr.left);
//                if(curr.right!=null) queue.offer(curr.right);
//            }
//        }
//        return ans;
//    }
//    ------------------------------------------------
    int sum = 0;
    int maxlvl = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxlvl) {
            maxlvl = level;
            sum = 0;
        }
        if (level == maxlvl) {
            sum += root.val;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
