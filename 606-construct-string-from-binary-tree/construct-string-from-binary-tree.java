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
    public String tree2str(TreeNode root) {
        if(root==null) return null;
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        StringBuilder ans = new StringBuilder(Integer.toString(root.val));
        if(left!=null && right!=null) {
            ans.append("(").append(left).append(")");
            ans.append("(").append(right).append(")");
        } 
        else if(left==null && right!=null) {
            ans.append("()");
            ans.append("(").append(right).append(")");
        }
        else if(left!=null && right==null) {
            ans.append("(").append(left).append(")");
        }
        return  ans.toString();
    } 
}