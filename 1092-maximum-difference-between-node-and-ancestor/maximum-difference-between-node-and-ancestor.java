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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    int helper(TreeNode root, int max, int min) {
        if(root==null) return -1;
        int diff1 = Math.abs(max-root.val);
        int diff2 = Math.abs(min-root.val);
        int ans = Math.max(diff1, diff2);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        ans = Math.max(ans, helper(root.left, max, min));
        ans = Math.max(ans, helper(root.right, max, min));
        return ans;
    }
}