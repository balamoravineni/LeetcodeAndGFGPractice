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
    public void recoverTree(TreeNode root) {
        // usingExtraSpace(root);
        while(inorderSort(root, null, null));
    }

    boolean inorderSort(TreeNode root, TreeNode min, TreeNode max) {
        if(root==null) return false;
        if(root.left!=null && root.left.val>root.val) {
            swap(root, root.left);
            return true;
        }
        if(root.right!=null && root.right.val<root.val) {
            swap(root, root.right);
            return true;
        }
        if(min!=null && min.val>root.val) {
            swap(root, min);
            return true;
        }
        if(max!=null && max.val<root.val) {
            swap(root, max);
            return true;
        }
        boolean left = inorderSort(root.left, min, root);
        boolean right = inorderSort(root.right, root, max);
        return left || right;
    }

    void swap(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    List<Integer> ans = new ArrayList<>();
    void usingExtraSpace(TreeNode root) {
        inorder(root);
        System.out.println(ans);
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