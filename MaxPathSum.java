/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */ 

public class MaxPathSum {
    public int wrapper(TreeNode root, int[] maxSum){
        if(root == null) return 0; 
        int l = wrapper(root.left,maxSum); 
        int r = wrapper(root.right,maxSum);
        maxSum[0] = Math.max(maxSum[0], root.val + l + r);
        if ((root.val + Math.max(l,r)) < 0) return 0; 
        else return root.val + Math.max(l,r); 
    }
    
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0; 
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE; 
        wrapper(root,maxSum);
        return maxSum[0]; 
    }
}