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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int current = preorder[0];
        TreeNode root = new TreeNode(current);
        if(preorder.length==1) return root;
        int currentInorderIndex = findIndex(current, inorder);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, currentInorderIndex+1), Arrays.copyOfRange(inorder, 0, currentInorderIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, currentInorderIndex+1, preorder.length), Arrays.copyOfRange(inorder, currentInorderIndex+1, inorder.length));
        return root;
    }
    
    int findIndex(int current, int[] inorder) {
        for(int i=0;i< inorder.length; i++) {
            if(inorder[i]==current) return i;
        }
        return -1;
    }
}