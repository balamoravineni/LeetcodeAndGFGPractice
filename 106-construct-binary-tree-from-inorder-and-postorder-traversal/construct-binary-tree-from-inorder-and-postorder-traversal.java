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
    Map<Integer,Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++) inorderMap.put(inorder[i], i);
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(postStart>postEnd) return null;
        int current = postorder[postEnd];
        TreeNode root = new TreeNode(current);
        // if(postStart==postEnd) return root;
        int currentInorderIndex = inorderMap.get(current);
        int leftTreeLen = currentInorderIndex-inStart;
        root.left = buildTreeHelper(inorder, postorder, inStart, currentInorderIndex-1, postStart, postStart+leftTreeLen-1);
        root.right = buildTreeHelper(inorder,postorder,currentInorderIndex+1, inEnd,postStart+leftTreeLen, postEnd-1);
        return root;
    }
}