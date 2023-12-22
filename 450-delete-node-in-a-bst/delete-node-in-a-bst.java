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
    public TreeNode deleteNode(TreeNode root, int key) {
        // return recursive(root, key);
        TreeNode parent = null;
        TreeNode current = root;
        while(current!=null && current.val!=key) {
            parent = current;
            if(current.val>key) current = current.left;
            else current = current.right;
        }
        if(current==null) return root;
        if(current.left==null) {
            if(parent!=null && parent.left==current) parent.left = current.right;
            else if(parent!=null && parent.right==current) parent.right = current.right;
            else root = current.right;
        }
        else if(current.right==null) {
            if(parent!=null && parent.left==current) parent.left = current.left;
            else if(parent!=null && parent.right==current) parent.right = current.left;
            else root = current.left;
        }
        else {
            //findMin of current.right
            TreeNode tempParent = current;
            TreeNode temp = current.right;
            while(temp.left!=null) {
                tempParent = temp;
                temp = temp.left;
            }
            if(tempParent!=current) {
                tempParent.left = temp.right;
                temp.right = current.right;
            }
            temp.left = current.left;
            if(parent!=null && parent.left==current) parent.left = temp;
            else if(parent!=null && parent.right==current) parent.right = temp;
            else root = temp;
        }
        return root;
    }

    TreeNode newRoot;
    TreeNode recursive(TreeNode root, int key) {
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