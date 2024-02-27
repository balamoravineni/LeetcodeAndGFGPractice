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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int height = recursiveHeight(root);
        // System.out.println(height);
        return ans;
    }

    int recursiveHeight(TreeNode root) {
        if(root==null) return 0;
        int left = recursiveHeight(root.left);
        int right = recursiveHeight(root.right);
        ans = Math.max(ans, left+right);
        return 1 + Math.max(left, right);
    }
}