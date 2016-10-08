/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 */ 

public class VerifyPreorderSequenceBST {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> s = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for(int curr : preorder){
            if(curr < low) return false;
            while(!s.isEmpty() && curr > s.peek()) low=s.pop(); 
            s.push(curr);
        }
        return true;
    }
}