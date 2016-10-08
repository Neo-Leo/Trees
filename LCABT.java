/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */ 

public class LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        if(root == p || root == q)
            return root;
            
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
        
        if(leftSearch != null && rightSearch != null) return root;
        else if(leftSearch != null) return leftSearch; 
        else return rightSearch; 
    }
}
