/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 */ 

public class ClosestBSTValue2 {
    Stack<Integer> s1,s2; 
    Solution() {
        s1 = new Stack<Integer>(); 
        s2 = new Stack<Integer>(); 
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorder(root, target); 
        reverseInorder(root, target);
        
        //Merge Sort Here
        
        List<Integer> list = new LinkedList<Integer>(); 
        while(!s1.isEmpty() && !s2.isEmpty() && (k-->0)) {
            if(target-s1.peek() < s2.peek()-target) list.add(s1.pop()); 
            else list.add(s2.pop()); 
        }
        
        while(!s1.isEmpty() && k-->0){
            list.add(s1.pop()); 
        }
        
        while(!s2.isEmpty() && k-->0){
            list.add(s2.pop()); 
        }
        return list; 
    }
    
    public void inorder(TreeNode root, double target){
        if(root == null) return;
        inorder(root.left, target);
        if((double)root.val > target) return;
        s1.push(root.val);
        inorder(root.right, target);
    }
    
    public void reverseInorder(TreeNode root, double target){
        if(root == null) return;
        reverseInorder(root.right, target);
        if((double)root.val <= target) return;
        s2.push(root.val);
        reverseInorder(root.left, target);
    }
}