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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            ans.add(current.val);
            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);
        }
        return ans;
    }
}