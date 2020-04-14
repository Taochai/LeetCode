public class Leetcode116PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        // corner case
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            Node prev = null;
            for(int i=0;i<n;i++){
                Node curr = q.poll();
                if(curr.left!=null && curr.right!=null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
                if(prev==null){
                    prev = curr;
                }else{
                    prev.next = curr;
                    prev = curr;
                }
            }
        }
        return root;

    }
}
