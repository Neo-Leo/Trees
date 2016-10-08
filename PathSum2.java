/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/path-sum-ii/
 */ 

public class PathSum2 {
    
    public void pathSumWrapper(TreeNode root, List<List<Integer>> resList, List<Integer> tempList, int sum){
        if(root == null)
            return;
        sum = sum - root.val;
        tempList.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            resList.add(new ArrayList(tempList));
        }
        pathSumWrapper(root.left, resList, tempList, sum);
        pathSumWrapper(root.right, resList, tempList, sum);
        tempList.remove(tempList.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if(root == null) 
            return resList;
        List<Integer> tempList = new ArrayList<Integer>();
        pathSumWrapper(root, resList, tempList, sum);
        return resList;
    }
}