/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/symmetric-tree/
 */ 

public class SymmetricTree {
    public boolean wrapper(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true; 
        if(r1 == null || r2 == null) return false; 
        if(r1.val != r2.val) return false; 
        return (wrapper(r1.left,r2.right) && wrapper(r1.right,r2.left));
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true; 
        return (wrapper(root.left,root.right));
    }
}