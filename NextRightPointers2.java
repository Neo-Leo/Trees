/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */ 

public class NextRightPointers2 {
    public void connect(TreeLinkNode root) {
        if(root == null) return; 
        List<TreeLinkNode> traversalList = new LinkedList<TreeLinkNode>();
        traversalList.add(root);
        TreeLinkNode marker = new TreeLinkNode(0);
        traversalList.add(marker);
        TreeLinkNode prev = null;
        root.next=null;
        while(traversalList.size()>0) {
            TreeLinkNode curr = traversalList.remove(0);
            if(curr == marker){
                if(traversalList.size() == 0){
                    break;
                } else {
                    traversalList.add(marker);
                    prev = null; // begining of a new level. 
                }
            } else {
                if(prev == null){
                    prev = curr;
                } else {
                    prev.next = curr;
                    prev=curr;
                }
            
                if(curr.left != null){
                    traversalList.add(curr.left);
                } 
                if(curr.right != null){
                    traversalList.add(curr.right);
                }
            }
        }
    }
}