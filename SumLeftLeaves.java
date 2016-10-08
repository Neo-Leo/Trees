/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/sum-of-left-leaves/
 */ 

public class SumLeftLeaves {
    int sum=0; 
    
    public boolean isLeaf(TreeNode root){
        if(root == null) return false; 
        if(root.left == null && root.right == null) return true; 
        return false;     
    }
    
    public void wrapper(TreeNode root){
        if(root == null) return; 
        if(isLeaf(root.left)){
            sum = sum + root.left.val; 
        }
        wrapper(root.left); 
        wrapper(root.right); 
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        wrapper(root);
        return sum; 
    }
}