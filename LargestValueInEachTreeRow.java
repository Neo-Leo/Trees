/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/?tab=Description
 */ 

public class LargestValueInEachTreeRow {
    public void wrapper(TreeNode root, List<Integer> list, int[] maxLevel, int level) {
        if(root == null) return; 
        if(maxLevel[0]<level) {
            maxLevel[0] = level; 
            list.add(root.val); 
        } else {
            if(list.get(level-1) < root.val) {
                list.set(level-1,root.val); 
            }
        }
        wrapper(root.left, list, maxLevel, level+1);
        wrapper(root.right, list, maxLevel, level+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        int[] maxLevel = new int[1]; 
        wrapper(root,list,maxLevel,1);
        return list; 
    }
}