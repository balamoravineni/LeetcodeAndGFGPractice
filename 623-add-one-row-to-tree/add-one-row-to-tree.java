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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return recursive(root, val, depth, -1);
    }

    TreeNode recursive(TreeNode root, int val, int depth, int leftOrRight) {
        if(depth==1) {
            TreeNode newNode = new TreeNode(val);
            if(leftOrRight==-1) newNode.left = root;
            else newNode.right = root;
            return newNode;
        }
        if(root!=null) {
            root.left = recursive(root.left, val, depth-1, -1);
            root.right = recursive(root.right, val, depth-1, 1);
        }
        return root;
    }
}