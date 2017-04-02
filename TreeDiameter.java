/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */ 

public class TreeDiameter {
    public int wrapper(TreeNode root, int[] arr){
        if(root == null) return 0; 
        int left = wrapper(root.left, arr);
        int right = wrapper(root.right, arr);
        arr[0] = Math.max(arr[0], 1+left+right);
        return 1 + Math.max(left,right); 
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1]; 
        wrapper(root, arr);
        return arr[0]  == 0 ? arr[0] : arr[0]-1; 
    }
}