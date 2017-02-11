/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */ 

public class MostFrequentSubtreeSum {
    HashMap<Integer,Integer> hm; 
    int maxCount; 
    
    MostFrequentSubtreeSum () {
        hm = new HashMap<Integer,Integer>();
        maxCount = 1;
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0; 
        int l = helper(root.left);
        int r = helper(root.right);
        int sum = l + root.val + r; 
        if(!hm.containsKey(sum)) {
            hm.put(sum,1);
        } else {
            int count = hm.get(sum); 
            maxCount = Math.max(maxCount,count+1);
            hm.put(sum,count+1);
        }
        return sum; 
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0]; 
        helper(root);
        List<Integer> list = new ArrayList<Integer>(); 
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            int value = entry.getValue();
            if(value == maxCount){
                list.add(entry.getKey());
            }
        }
        int[] arr = new int[list.size()];
        int i=0;
        for(Integer elem : list){
            arr[i++] = elem;
        }
        return arr; 
    }
}