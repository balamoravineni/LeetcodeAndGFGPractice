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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeHeight(root);
        return maxDiameter;
    }

    int treeHeight(TreeNode root) {
        if(root==null) return 0;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if(left+right>maxDiameter) maxDiameter = left+right;
        return 1+ Math.max(left, right);
    }
}