public class SerializeAndDeserializeBST {
    
    public void serializeWrapper(TreeNode root, StringBuilder sb){
        if(root == null) return; 
        sb.append(root.val);
        sb.append(","); 
        serializeWrapper(root.left,sb);
        serializeWrapper(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return ""; 
        }
        StringBuilder sb = new StringBuilder(); 
        serializeWrapper(root,sb); 
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null; 
        String[] arr = data.split(",");
        Stack<TreeNode> st = new Stack<TreeNode>(); 
        TreeNode root = null; 
        for(String s : arr){
            int elem = Integer.valueOf(s); 
            TreeNode curr = new TreeNode(elem);
            curr.left = curr.right = null; 
            if(st.isEmpty()) {
                root = curr; 
                st.push(curr); 
                continue; 
            }
            
            if(st.peek().val > elem) {
                st.peek().left = curr;  
                st.push(curr); 
            } else {
                TreeNode top = null; 
                while(!st.isEmpty() && st.peek().val < elem){
                    top = st.pop(); 
                }
                top.right = curr; 
                st.push(curr); 
            }
        }
        return root; 
    }
}