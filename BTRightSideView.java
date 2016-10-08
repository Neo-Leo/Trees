/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */ 

public class BTRightSideView {
    public void wrapper(TreeNode root, List<Integer> list, int curr, int[] maxLevel){
        if(root == null) return; 
        if(curr > maxLevel[0]) {
            list.add(root.val);
            maxLevel[0]++; 
        }
        wrapper(root.right, list, curr+1, maxLevel);
        wrapper(root.left, list, curr+1, maxLevel);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>(); 
        int[] maxLevel = new int[1];
        maxLevel[0] = 0; 
        wrapper(root, list, 1, maxLevel); 
        return list; 
    }
}