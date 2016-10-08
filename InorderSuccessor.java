/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */ 


public class InorderSuccessor {
    
    public TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        TreeNode succ = null;
        
        if(p.right != null) {
            return findMin(p.right);
        } else {
            while(root!=p) {
                if(root.val > p.val){
                    succ = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }    
        }
        return succ;
    }
}