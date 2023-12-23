/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return recursive(root,p,q);
        return iterative(root,p,q);
    }

    TreeNode iterative(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null) {
            if(root.val>p.val && root.val>q.val) root = root.left;
            else if(root.val<p.val && root.val<q.val) root = root.right;
            else break;
        }
        return root;
    }

    TreeNode recursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>p.val && root.val>q.val) return recursive(root.left,p,q);
        if(root.val<p.val && root.val<q.val) return recursive(root.right,p,q);
        // if((root.val>p.val && root.val<q.val) || (root.val>q.val && root.val<p.val)) return root;
        // if(root.val==p.val || root.val==q.val) return root;
        return root;
    }
}