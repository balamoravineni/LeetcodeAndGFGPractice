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
        System.out.println(ans);
        List<Integer> copy = new ArrayList<>(ans);
        Collections.sort(copy);
        Integer r1 = 0, r2 = 0;
        for(int i=0;i<ans.size();i++) {
            if(ans.get(i)!=copy.get(i)) {
                r1 = ans.get(i);
                r2 = copy.get(i);
                break;
            }
        }
        System.out.println(r1 + " " + r2);
        preorderReplace(root,r1,r2);
    }
    void preorderReplace(TreeNode root, int r1, int r2) {
        if(root==null) return;
        if(root.val==r1) root.val = r2;
        else if(root.val==r2) root.val = r1;
        preorderReplace(root.left, r1, r2);
        preorderReplace(root.right, r1, r2);
    }

    void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}