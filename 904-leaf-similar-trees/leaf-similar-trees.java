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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> queue1 = new LinkedList<>();
        findLeaves(root1, queue1);
        List<Integer> queue2 = new LinkedList<>();
        findLeaves(root2, queue2);
        return queue1.equals(queue2);
    }

    void findLeaves(TreeNode root, List<Integer> queue) {
        if(root.left==null && root.right==null) {
            queue.add(root.val);
            return;
        }
        if(root.left!=null) findLeaves(root.left, queue);
        if(root.right!=null) findLeaves(root.right, queue);
    }
}