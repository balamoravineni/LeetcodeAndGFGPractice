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
    public boolean isValidBST(TreeNode root) {
    //    return usingInorder(root);
        return recursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean recursive(TreeNode root, long min, long max) {
        if(root==null) return true;
        if(root.val>min && root.val<max) {
            boolean left = recursive(root.left, min, root.val);
            boolean right = recursive(root.right, root.val, max);
            return left && right;
        }
        return false;
    }

    boolean usingInorder(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        for(int i=1;i<ans.size();i++) {
            if(ans.get(i)<=ans.get(i-1)) return false;
        }
        return true;
    }

    void inorder(TreeNode root, List<Integer> ans) {
        if(root==null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}