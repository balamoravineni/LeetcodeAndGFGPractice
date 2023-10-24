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
    public boolean isBalanced(TreeNode root) {
        int hd = heightDiff(root);
        return hd!=-1;
    }

    public int heightDiff(TreeNode root) {
        if(root==null) return 0;
        int left = heightDiff(root.left);
        int right = heightDiff(root.right);
        if(left==-1 || right==-1) return -1;
        else if(Math.abs(left-right)<2) return 1+Math.max(left,right);
        return -1;
    }

    
}