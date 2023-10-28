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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return recursive(root.left, root.right);
    } 

    boolean recursive(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        else if(left==null || right==null) return false;
        else if(left.val!=right.val) return false;
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}