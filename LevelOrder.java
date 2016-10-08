/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */ 

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null) return lists; 
        LinkedList<TreeNode> traversalList = new LinkedList<TreeNode>();
        traversalList.add(root);
        traversalList.add(null);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while(traversalList.size() > 0){
            TreeNode curr = traversalList.remove(0);
            if(curr == null){
                lists.add(new ArrayList<Integer>(tempList));
                tempList.clear();
                if(traversalList.size() == 0){ //All Levels are done
                    break; 
                } else {
                    traversalList.add(null); //More Levels remaining
                }
            } else {
                tempList.add(curr.val);
                if(curr.left != null)
                    traversalList.add(curr.left);
                if(curr.right != null)
                    traversalList.add(curr.right);    
            }
        }
        return lists;
    }
}