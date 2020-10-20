package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105BuildBinaryTreeWithInorderAndPreorder {
    // preorder的第一个总是root，并且后面的组成是left value 和 right value，都是新的preorder顺序。
    // inorder的root index的左边都是 left value， index的右边都是right value
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //corner case
            if(preorder.length==0 || inorder.length==0) return null;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i],i);
            } //map 存了inorder的value和index
            return build(preorder,0,inorder,0,inorder.length-1,map);
        }
        private TreeNode build(int[] preorder,int preStart, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
            // end condition
            if(inStart>inEnd) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRootIndex = map.get(root.val);
            root.left = build(preorder,preStart+1, inorder, inStart, inRootIndex-1,map);
            root.right = build(preorder,preStart+inRootIndex-inStart+1,inorder,inRootIndex+1,inEnd,map);
            return root;
        }

}
