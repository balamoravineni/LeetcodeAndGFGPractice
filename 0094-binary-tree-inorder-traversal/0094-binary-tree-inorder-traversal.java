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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(stack.peek().left!=null) {
            stack.push(stack.peek().left);
        }
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            if(temp.right!=null) {
                stack.push(temp.right);
                while(stack.peek().left!=null) {
                    stack.push(stack.peek().left);
                }
            }
        }
        return ans;
    }
}