/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/boundary-of-binary-tree/
 */ 

public class BinaryTreeBoundary {
    
    public void leftBoundary(TreeNode root, List<Integer> list){
        if(root == null || (root.left == null && root.right == null)) return; 
        list.add(root.val);
        if(root.left != null) leftBoundary(root.left, list);
        else leftBoundary(root.right, list); 
    }
    
    public void rightBoundary(TreeNode root, List<Integer> list){
        if(root == null || (root.left == null && root.right == null)) return; 
        if(root.right != null) rightBoundary(root.right, list);
        else rightBoundary(root.left, list);
        list.add(root.val);
    }
    
    public void leaves(TreeNode root, List<Integer> list) {
        if(root == null) return; 
        if(root.left == null && root.right == null) list.add(root.val);
        leaves(root.left, list);
        leaves(root.right, list);
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list; 
        list.add(root.val); 
        leftBoundary(root.left, list);
        leaves(root.left, list);
        leaves(root.right, list);
        rightBoundary(root.right, list);
        return list; 
    }
}