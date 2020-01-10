import java.util.HashMap;
import java.util.Map;
//1st time
//时间复杂度分析。
//master theorem: a = 2, b = 2, f(n) = 1 = O(n^c) c<log(a)/log(b)
public class Leetcode106BuildBinaryTreeWithInorderAndPostorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //corner case:
        if(inorder.length==0 || postorder.length==0) return null;
        //inorder value---index
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,postorder.length-1,m);
    }
    public TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder, int postEnd, Map<Integer,Integer> m){
        if(inStart>inEnd) return null;
        int inRootIndex = m.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = build(inorder,inStart,inRootIndex-1,postorder,postEnd-(inEnd-inRootIndex)-1,m);
        root.right = build(inorder,inRootIndex+1,inEnd,postorder,postEnd-1,m);
        return root;
    }
}
