package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean incomplete = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);

                if(node.left==null && node.right==null){
                    incomplete = true;
                }
                else if(node.left==null && node.right!=null){
                    return false;
                }
                else if(node.left!=null && node.right==null){
                    if(incomplete) return false;
                    incomplete = true;
                }else{
                    if(incomplete) return false;
                    incomplete = false;
                }
            }
        }
        return true;
    }
}
