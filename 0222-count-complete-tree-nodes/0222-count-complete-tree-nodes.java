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
    public int countNodes(TreeNode root) {
        int height = isFullBinaryTree(root);
        if(height!=-1) return (int)Math.pow(2, height)-1;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }
    
    int isFullBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftH = 0, rightH = 0;
        TreeNode current = root;
        while(current!=null) {
            leftH++;
            current = current.left;
        }
        current = root;
        while(current!=null) {
            rightH++;
            current = current.right;
        }
        if(leftH==rightH) return leftH;
        return -1;
    }
}