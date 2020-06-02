import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1110DeleteNodesAndReturnForest {
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> del = new HashSet<>();
        for(int i : to_delete) del.add(i);
        root = helper(del,root);
        if(root!=null) ans.add(root);
        return ans;
    }
    private TreeNode helper(Set<Integer> del, TreeNode node){
        if(node==null) return null;
        node.right = helper(del,node.right);
        node.left = helper(del,node.left);
        if(!del.contains(node.val)) return node;
        if(node.left!=null) ans.add(node.left);
        if(node.right!=null) ans.add(node.right);
        return null;
    }
}
// 时间：0（n）
// 空间：O（h）