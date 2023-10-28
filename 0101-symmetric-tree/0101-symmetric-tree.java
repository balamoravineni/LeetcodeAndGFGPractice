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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        // return recursive(root.left, root.right);
        return iterative(root.left, root.right);
    } 

    boolean iterative(TreeNode left, TreeNode right) {
        Queue<TreeNode> qLeft = new LinkedList<>();
        Queue<TreeNode> qRight = new LinkedList<>();
        if(left!=null) qLeft.add(left);
        if(right!=null) qRight.add(right);
        while(!qLeft.isEmpty() || !qRight.isEmpty()) {
            int sizeLeft = qLeft.size();
            int sizeRight = qRight.size();
            if(sizeLeft!=sizeRight) return false;
            while(sizeLeft-->0) {
                TreeNode currLeft = qLeft.remove();
                TreeNode currRight = qRight.remove();
                if(currLeft.val!=currRight.val) return false;

                if((currLeft.left==null || currRight.right==null) && currLeft.left!=currRight.right) return false;
                if((currLeft.right==null || currRight.left==null) && currLeft.right!=currRight.left) return false;

                if(currLeft.left!=null) qLeft.add(currLeft.left);
                if(currLeft.right!=null) qLeft.add(currLeft.right);
                if(currRight.right!=null) qRight.add(currRight.right);
                if(currRight.left!=null) qRight.add(currRight.left);
            }
        }

        return true;
    }

    boolean recursive(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        else if(left==null || right==null) return false;
        else if(left.val!=right.val) return false;
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}