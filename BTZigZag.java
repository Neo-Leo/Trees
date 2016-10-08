/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */ 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode a) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if(a == null){
	        return res;
	    }
	    LinkedList<TreeNode> traversalList = new LinkedList<TreeNode>();
	    ArrayList<Integer> tempList = new ArrayList<Integer>();
	    TreeNode curr=a, marker = new TreeNode(-1);
	    boolean flag = true;
	    traversalList.add(curr);
	    traversalList.add(marker);
	    while(traversalList.size()>0){
	        curr = traversalList.remove(0);
	        if(curr == marker){
	           if(flag == false){
	               Collections.reverse(tempList);
	           }
	           res.add(tempList); 
	           if(traversalList.size()==0){
	               break;
	           } 
	           tempList = new ArrayList<Integer>();
	           flag = !flag;
	           traversalList.add(marker);
	        } else {
	           tempList.add(curr.val);
	           if(curr.left != null){
	               traversalList.add(curr.left);
	           }
	           if(curr.right != null){
	               traversalList.add(curr.right);
	           }
	       }
	    }
	    return res;
    }
}