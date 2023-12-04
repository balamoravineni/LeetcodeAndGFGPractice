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
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        // if(preorder.length==0) return null;
        // int current = preorder[0];
        // TreeNode root = new TreeNode(current);
        // if(preorder.length==1) return root;
        // int currentInorderIndex = findIndex(current, inorder);
        // root.left = buildTree(Arrays.copyOfRange(preorder, 1, currentInorderIndex+1), Arrays.copyOfRange(inorder, 0, currentInorderIndex));
        // root.right = buildTree(Arrays.copyOfRange(preorder, currentInorderIndex+1, preorder.length), Arrays.copyOfRange(inorder, currentInorderIndex+1, inorder.length));
        // return root;
    }

    TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart>preEnd) return null;
        int current = preorder[preStart];
        TreeNode root = new TreeNode(current);
        if(preEnd==preStart) return root;
        int currentInorderIndex = findIndexHelper(current, inorder, inStart, inEnd);
        int lenLeftTree = currentInorderIndex-inStart;
        root.left = buildTreeHelper(preorder, inorder, preStart+1, preStart+lenLeftTree, inStart, currentInorderIndex-1);
        root.right = buildTreeHelper(preorder, inorder, preStart+lenLeftTree+1, preEnd, currentInorderIndex+1, inEnd);
        return root;
    }

    int findIndexHelper(int current, int[] inorder, int inStart, int inEnd) {
        for(int i=inStart;i<=inEnd; i++) {
            if(inorder[i]==current) return i;
        }
        return -1;
    }
    
    int findIndex(int current, int[] inorder) {
        for(int i=0;i< inorder.length; i++) {
            if(inorder[i]==current) return i;
        }
        return -1;
    }
}