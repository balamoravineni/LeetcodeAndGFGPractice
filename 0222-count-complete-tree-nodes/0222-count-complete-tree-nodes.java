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
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            ans++;
            if(current.left!=null) queue.add(current.left);
            else break;
            if(current.right!=null) queue.add(current.right);
            else break;
        }
        return ans + queue.size();
    }
}