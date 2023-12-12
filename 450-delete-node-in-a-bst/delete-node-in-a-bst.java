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
    TreeNode newRoot;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        deleteNodeHelper(root, null, key);
        return newRoot;
    }

    boolean deleteNodeHelper(TreeNode root, TreeNode parent, int key) {
        if(root==null) return false;
        if(root.val==key) {
            TreeNode temp;
            if(root.right==null) {
                temp = root.left;
            }
            else {
                if(root.right.left==null) {
                    temp = root.right;
                    temp.left = root.left;
                }
                else {
                    temp = findMinimum(root.right);
                    temp.left = root.left;
                    temp.right = root.right;
                }
            }
            if(parent!=null) {
                if(parent.left==root) parent.left = temp;
                else parent.right = temp;
            }
            else {
                newRoot = temp;
            }
            return true;
        }
        if(parent==null) newRoot = root;
        if(deleteNodeHelper(root.left, root, key)) return true;
        else if(deleteNodeHelper(root.right, root, key)) return true;
        return false;
    }

    TreeNode findMinimum(TreeNode current) {
        TreeNode parent = null;
        while(current.left!=null) {
            parent=current;
            current=current.left;
        }
        parent.left = current.right;
        current.right = null;
        return current;

    }

    
}