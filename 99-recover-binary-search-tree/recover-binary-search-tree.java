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
    List<Integer> ans = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);
        // System.out.println(ans);
        Collections.sort(ans);
        // System.out.println(r1 + " " + r2);
        inorderReplace(root,new int[1]);
    }
    void inorderReplace(TreeNode root, int[] i) {
        if(root==null) return;
        inorderReplace(root.left, i);
        if(root.val!=ans.get(i[0])) root.val = ans.get(i[0]);
        i[0]++;
        inorderReplace(root.right, i);
    }

    void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}