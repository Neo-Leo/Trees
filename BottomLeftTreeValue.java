/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/find-bottom-left-tree-value/?tab=Description
 */ 


public class BottomLeftTreeValue {
    public void wrapper(TreeNode root, int[] maxLevel, int[] leftVal, int level){
        if(root == null) return; 
        if(maxLevel[0] < level){
            maxLevel[0] = level; 
            leftVal[0] = root.val; 
        }
        wrapper(root.left,maxLevel,leftVal,level+1);
        wrapper(root.right,maxLevel,leftVal,level+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        int[] maxLevel = new int[1]; 
        int[] leftVal = new int[1]; 
        wrapper(root,maxLevel,leftVal,1);
        return leftVal[0];
    }
}