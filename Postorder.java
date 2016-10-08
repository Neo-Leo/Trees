/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */ 

public class Postorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<Integer>();
        if(root == null){
            return resList;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        TreeNode temp;
        
        while(!s1.isEmpty()){
            temp = s1.pop();
            s2.push(temp);
            if(temp.left != null){
                s1.push(temp.left);
            }
            if(temp.right != null){
                s1.push(temp.right);
            }
        }
        while(!s2.isEmpty()){
            resList.add(s2.pop().val);
        }
        return resList;
    }
}