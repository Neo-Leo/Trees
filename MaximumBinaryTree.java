class MaximumBinaryTree {
    private int maxIndex(int[] nums, int low, int high) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1; 
        for(int i=low; i<=high; i++){
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i; 
            }
        }
        return maxIndex; 
    }
    
    public TreeNode wrapper(int[] nums, int low, int high){
        if(low > high) return null; 
        int maxIdx = maxIndex(nums,low,high);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = wrapper(nums,low,maxIdx-1);
        root.right = wrapper(nums,maxIdx+1,high);
        return root; 
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return wrapper(nums,0,nums.length-1);
    }
}
