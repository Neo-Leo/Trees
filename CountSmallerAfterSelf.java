class customNode {
    int selfCount; 
    int smallerCount; 
    int val; 
    customNode left, right; 
    customNode (int val) {
        this.val = val; 
        selfCount = 1; 
        smallerCount = 0; 
        left = null; 
        right = null; 
    }
}


public class CountSmallerAfterSelf {
    customNode root; 
    
    public Solution(){
        root = null; 
    }
    
    public void wrapper(List<Integer> list, int elem){
        
        if(root == null) {
            root = new customNode(elem);
            list.add(0); 
            return; 
        }
        
        customNode parent = null, curr = root;
        int count = 0; 
        while(curr != null) {
            if(curr.val < elem){
                count += (curr.smallerCount + curr.selfCount);
                parent = curr;     
                curr = curr.right; 
            } else if (curr.val > elem) {
                curr.smallerCount++; 
                parent = curr; 
                curr = curr.left; 
            } else { // equal 
                curr.selfCount++; 
                list.add(count + curr.smallerCount);
                return; 
            }
        }
        if(parent.val < elem){
            parent.right = new customNode(elem);     
        } else {
            parent.left = new customNode(elem);
        }
        list.add(count); 
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(); 
        if(nums == null) return list; 
        for(int i=nums.length-1; i>=0; i--) {
            wrapper(list,nums[i]);    
        }
        Collections.reverse(list); 
        return list;  
    }
}