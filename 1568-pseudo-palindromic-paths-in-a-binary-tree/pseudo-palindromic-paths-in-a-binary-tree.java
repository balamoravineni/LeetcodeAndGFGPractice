/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] digits = new int[10];
        return helper(root, digits);
    }

    int helper(TreeNode root, int[] digits) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) {
            digits[root.val]++;
            int evenF = 0, oddF = 0, size = 0;
            for(int i=1;i<10;i++) {
                size += digits[i];
                if(digits[i]%2==0) evenF++;
                else oddF++;
            }
            digits[root.val]--;
            if(size%2==0) return oddF==0?1:0;
            return oddF==1?1:0;
        }
        digits[root.val]++;
        int left = helper(root.left, digits);
        int right = helper(root.right, digits);
        digits[root.val]--;
        return left+right;
    }
}