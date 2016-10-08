/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */ 

public class ReconstructBTInorderPostorder {
    int search(int[] inorder, int key, int start, int end) {
        for(int i=start; i<=end;i++){
            if(inorder[i] == key)
                return i;
        }
        return -1;
    }
    
    public TreeNode buildTreeWrapper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
            if(inStart>inEnd) return null;
            TreeNode root = new TreeNode(postorder[postEnd]);
            int pos;
            if(inStart == inEnd) return root;
            pos = search(inorder, postorder[postEnd], inStart, inEnd);
            root.left = buildTreeWrapper(inorder, postorder, inStart, pos-1, postStart, postStart+pos-1-inStart);
            root.right = buildTreeWrapper(inorder, postorder, pos+1, inEnd, postEnd-(inEnd-pos) , postEnd-1);
            return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        return buildTreeWrapper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
}