/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/count-univalue-subtrees/
 */ 

public class UnivalueSubtreeCount {
    public boolean wrapper(TreeNode root, int[] count){
        if(root == null) {return true;}
        boolean l = wrapper(root.left,count);
        boolean r = wrapper(root.right,count);
        if(l && r){
            if((root.left == null && root.right != null) && (root.val != root.right.val)){return false;}
            else if((root.right == null && root.left != null) && (root.val != root.left.val)){return false;}
            else if ((root.left != null && root.right!= null) && ((root.val != root.left.val) || (root.val != root.right.val))){return false;}
            count[0]++; 
            return true;
        }
        
        return false;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] count = new int[1];
        wrapper(root, count);
        return count[0];
    }
}