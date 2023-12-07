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
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left!=null) {
            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode current = root.left;
            while(current.right!=null) current = current.right;
            current.right = temp;
            root.left = null;
        }
        flatten(root.right);
    }
}