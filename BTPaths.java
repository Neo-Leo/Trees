/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-paths/
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
 
/* ITERATIVE */ 
/*
class State{
    TreeNode node;
    StringBuilder pathSoFar;
    State(TreeNode node, StringBuilder pathSoFar){
        this.node = node;
        this.pathSoFar = pathSoFar;
    }
}
 
public class BTPaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if(root == null) 
            return paths; 
        Stack<State> s = new Stack<State>();
        StringBuilder prev = new StringBuilder("");
        while(true){
            while(root != null) {
                if(root.left == null && root.right == null) { //is a Leaf Node
                    prev.append(root.val); 
                } else {
                    prev.append(root.val+"->");
                }
                s.push(new State(root, new StringBuilder(prev)));
                root=root.left;
            }
            if(s.isEmpty()) {
                break;
            } else {
                State currState = s.pop();
                root = currState.node;
                if(root.left == null && root.right == null) {
                    paths.add(new String(currState.pathSoFar));
                } else {
                    prev = currState.pathSoFar;
                }
                root=root.right;
            }
        }
        return paths;
    }
}
*/ 
   

/* RECURSIVE */

public class BTPaths {
    public void binaryTreePathsWrapper(TreeNode root, StringBuilder sb, List<String> paths){
        // Doing a preorder traversal
        if(root == null) return;
        int originalLength = sb.length();
        if(root.left == null && root.right == null) { 
            sb.append(root.val);
            paths.add(new String(sb));
            sb.delete(originalLength,sb.length());
            return;
        } 
        sb.append(root.val+"->");
        binaryTreePathsWrapper(root.left, sb, paths);
        binaryTreePathsWrapper(root.right, sb, paths);
        sb.delete(originalLength,sb.length());
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if(root == null) 
            return paths; 
        StringBuilder sb = new StringBuilder();
        binaryTreePathsWrapper(root,sb,paths);
        return paths;
    }
}
