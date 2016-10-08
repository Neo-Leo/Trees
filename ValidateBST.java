/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/validate-binary-search-tree/
 */ 

public class ValidateBST {
    public boolean wrapper(TreeNode root, int low, int high){
        if(root == null) return true; 
        if(root.val == Integer.MIN_VALUE && root.left != null) return false; 
        if(root.val == Integer.MAX_VALUE && root.right != null) return false;
        if(root.val < low || root.val > high) return false; 
        return wrapper(root.left, low, root.val-1) && wrapper(root.right, root.val+1, high);  
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true; 
        return wrapper(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
}