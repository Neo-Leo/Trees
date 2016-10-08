/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */ 

public class BTLCS {
    public void longestConsecutiveWrapper(TreeNode root, int parentVal, int currLen, int[] max) {
            if(root == null){
                return;
            }
            if(root.val == parentVal + 1){
                currLen++;
            } else {
                currLen = 1;    
            }
            max[0]=Math.max(currLen,max[0]);
            longestConsecutiveWrapper(root.left, root.val, currLen, max);
            longestConsecutiveWrapper(root.right, root.val, currLen, max);
    }
    
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE; 
        longestConsecutiveWrapper(root, root.val-1, 0, max);
        return max[0];
    }
}