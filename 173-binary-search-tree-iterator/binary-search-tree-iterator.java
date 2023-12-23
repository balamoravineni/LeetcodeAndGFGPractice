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
class BSTIterator {

    Deque<TreeNode> stack;
    TreeNode root;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        this.root = root;
    }
    
    public int next() {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode current = stack.pop();
        root = current.right;
        return current.val;
    }
    
    public boolean hasNext() {
        return root!=null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */