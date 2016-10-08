/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */ 

public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        int closestNodeVal = Integer.MIN_VALUE; 
        double diff = Double.MAX_VALUE;
        /* Time Complexity - O(logn) */
        while(root!=null){
            if(Math.abs(root.val*1.0 - target) < diff){
                diff = Math.abs(root.val*1.0 - target);
                closestNodeVal = root.val;
            }
            if(diff == 0){
                break;
            }
            if(target < root.val*1.0){
                root=root.left;
            } else if(target > root.val*1.0) {
                root = root.right;
            }
        }
        
        return closestNodeVal;
    }
}