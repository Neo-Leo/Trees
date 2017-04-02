/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */ 

public class BSTToGreaterTree {
    public void wrapper(TreeNode root, int[] sum) {
        if(root == null) return; 
        wrapper(root.right, sum);
        int tempVal = root.val; 
        root.val += sum[0];  
        sum[0] += tempVal; 
        wrapper(root.left, sum);
    }
    
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1]; 
        wrapper(root, sum);
        return root;
    }
}