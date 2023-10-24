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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSumRoot(root);
        return ans;
    }

    int pathSumRoot(TreeNode root) {
        if(root==null) return 0;
        int left = pathSumRoot(root.left);
        int right = pathSumRoot(root.right);
        if(left<0) left = 0;
        if(right<0) right = 0;
        int current = root.val + left + right;
        if(ans<current) ans = current;
        return root.val + Math.max(left, right);
    }
}