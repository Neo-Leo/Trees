/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/invert-binary-tree/
 */ 

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right); 
        
        TreeNode temp = root.left;
        root.left = root.right; 
        root.right = temp;
        
        return root; 
    }
}