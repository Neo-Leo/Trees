/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */ 
 
/* 
public class FindLeaves {

    public TreeNode traverseTree(TreeNode root, List<Integer> list){
        if(root == null)
            return null; 
        if(isLeaf(root)) {
            list.add(root.val);
            return null; 
        }
        root.left = traverseTree(root.left, list);
        root.right = traverseTree(root.right, list);
        return root; 
    }

    public boolean isLeaf(TreeNode root){
        if(root == null)
            return false; 
        if(root.left == null && root.right == null)
            return true; 
        return false; 
    }
    
    public void findLeavesWrapper(TreeNode root, List<List<Integer>> lists){
        while(!isLeaf(root)) {
            List<Integer> list = new LinkedList<Integer>(); 
            traverseTree(root, list);
            lists.add(list);
        }
        List<Integer> list = new LinkedList<Integer>();
        list.add(root.val);
        lists.add(list);
        
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>(); 
        if(root == null)
            return lists; 
        findLeavesWrapper(root, lists);
        return lists;
    }
}
*/ 

// O(n)

public class FindLeaves {
    int height(TreeNode root){
        if(root == null) return 0; 
        return 1 + Math.max(height(root.left),height(root.right)); 
    }
    
    public int traverse(TreeNode root, List<List<Integer>> lists){
        if(root == null) return -1; 
        int left = traverse(root.left, lists);
        int right = traverse(root.right, lists);
        int index = 1 + Math.max(left, right);
        lists.get(index).add(root.val);
        return index; 
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(root == null) return lists; 
        int h = height(root);
        for(int i=0; i<h; i++) {
            lists.add(new LinkedList<Integer>());
        }
        traverse(root,lists);
        return lists; 
    }
}