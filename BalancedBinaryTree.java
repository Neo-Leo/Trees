/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/balanced-binary-tree/
 */ 

public class BalancedBinaryTree {
    public int isBalancedWrapper(TreeNode root){
        if(root == null)
            return 0;
        /* Do a post order traversal - O(n) Time Complexity */    
        int l = isBalancedWrapper(root.left);
        if(l == Integer.MIN_VALUE) return l;
        int r = isBalancedWrapper(root.right);
        if(r == Integer.MIN_VALUE) return r;
        if(Math.abs(l-r) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return 1 + Math.max(l,r); 
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) 
            return true;
        int retVal = isBalancedWrapper(root);
        return (retVal != Integer.MIN_VALUE);
    }
}