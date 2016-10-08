/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-upside-down/
 */ 

public class BTUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return null; 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        while(root!=null){
            s.push(root);
            root = root.left; 
        }
        
        TreeNode newRoot = s.pop();
        TreeNode parent = newRoot; 
        TreeNode curr; 
        
        while(!s.isEmpty()){
            curr = s.pop();
            parent.right = curr; 
            parent.left = curr.right;
            curr.right = null;
            curr.left = null;
            parent = curr; 
        }
        
        return newRoot; 
    }
}