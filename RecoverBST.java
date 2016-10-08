/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/recover-binary-search-tree/
 */ 

public class RecoverBST {
    TreeNode first = null, second = null, prev = null;
    public void wrapper(TreeNode root){
        if(root == null) return; 
        wrapper(root.left); 
        
        if(prev == null) {
            prev = root; 
        } 
        
        if(prev.val > root.val){
            if(first == null) {
                first = prev;
                second = root; 
            } else {
                second = root;
                return; 
            }
        }
        prev = root;
        wrapper(root.right); 
    }
    
    public void swap(TreeNode x, TreeNode y){
        int temp = x.val; 
        x.val = y.val; 
        y.val = temp; 
    }
    
    public void recoverTree(TreeNode root) {
        wrapper(root);
        swap(first, second);
    }
}