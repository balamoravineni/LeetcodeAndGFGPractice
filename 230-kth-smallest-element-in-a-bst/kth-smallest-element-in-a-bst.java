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
        // constantSpaceButRecursive(root,k);
        // return ans;
        return morrisInorder(root,k);
    }

    int morrisInorder(TreeNode root, int k) {
        while(root!=null) {
            if(root.left==null) {
                if(++count==k) return root.val;
                root = root.right;
            }
            else {
                TreeNode temp = root.left;
                while(temp.right!=null && temp.right!=root) temp = temp.right;
                if(temp.right==null) {
                    temp.right = root;
                    root = root.left;
                }
                else {
                    if(++count==k) return root.val;
                    temp.right = null;
                    root = root.right;
                }
            }
        }
        return -1;
    }

    void constantSpaceButRecursive(TreeNode root, int k) {
        if(root==null) return;
        constantSpaceButRecursive(root.left,k);
        if(++count==k) ans = root.val;
        constantSpaceButRecursive(root.right,k);
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