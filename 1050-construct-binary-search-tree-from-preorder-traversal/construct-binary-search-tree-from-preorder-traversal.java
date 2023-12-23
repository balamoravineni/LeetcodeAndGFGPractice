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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

    TreeNode helper(int[] preorder, int start, int end) {
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int mid = end+1;
        for(int i=start+1;i<=end;i++) {
            if(preorder[i]>preorder[start]) {
                mid = i;
                break;
            }
        }
        root.left = helper(preorder,start+1, mid-1);
        root.right = helper(preorder, mid, end);
        return root;
    }
}