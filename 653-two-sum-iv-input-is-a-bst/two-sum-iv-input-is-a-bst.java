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

    Deque<TreeNode> nextStack = new ArrayDeque<>();
    Deque<TreeNode> previousStack = new ArrayDeque<>();

    int next() {
        TreeNode current = nextStack.pop();
        pushAllLeft(current.right);
        return current.val;
    }

    int previous() {
        TreeNode current = previousStack.pop();
        pushAllRight(current.left);
        return current.val;
    }

    void pushAllLeft(TreeNode root) {
        while(root!=null) {
            nextStack.push(root);
            root = root.left;
        }
    }

    void pushAllRight(TreeNode root) {
        while(root!=null) {
            previousStack.push(root);
            root = root.right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        pushAllLeft(root);
        pushAllRight(root);

        int start = next();
        int end = previous();
        while(start+end!=k && start!=end) {
            if(start+end<k) start = next();
            else end = previous();
        }
        if(start==end) return false;
        return true;
    }
}