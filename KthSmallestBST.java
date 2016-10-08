/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */ 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/* Recursive */
/*
public class KthSmallestBST {
    public TreeNode kthSmallestWrapper(TreeNode root, int[] arr){
        if(root == null) 
            return null; 
        TreeNode presentInLeft = kthSmallestWrapper(root.left, arr);
        if(presentInLeft != null) return presentInLeft; 
        if(arr[0] == 1){
            return root;
        } 
        arr[0]--;
        TreeNode presentInRight = kthSmallestWrapper(root.right, arr);
        return ( presentInLeft!=null ? presentInLeft : presentInRight);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1];
        arr[0] = k;
        TreeNode result = kthSmallestWrapper(root, arr);
        return result.val;
    }
}
*/

public class KthSmallestBST {
        
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        while(true){
            while(root != null){
                s.push(root);
                root=root.left; 
            }
            if(s.isEmpty()){
                break; 
            } else {
                root = s.pop();
                if(k==1)
                    return 
            }
            
        }
    }
}
