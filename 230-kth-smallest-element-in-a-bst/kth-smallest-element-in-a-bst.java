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
    int count = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        // return usingList(root, k);
        constantSpace(root,k);
        return ans;
    }

    void constantSpace(TreeNode root, int k) {
        if(root==null) return;
        constantSpace(root.left,k);
        if(++count==k) ans = root.val;
        constantSpace(root.right,k);
    }

    int usingList(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans.get(k-1);
    }

    void inorder(TreeNode root, List<Integer> ans) {
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}