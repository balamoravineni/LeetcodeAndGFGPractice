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
    public List<Integer> preorderTraversal(TreeNode root) {
        // return preorderUsingStack(root);
        return preorderMorris(root);
    }

    List<Integer> preorderMorris(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root;
        while(current!=null) {
            if(current.left==null) {
                ans.add(current.val);
                current = current.right;
                continue;
            }
            else {
                TreeNode temp = current.left;
                while(temp.right!=null && temp.right!=current) temp = temp.right;
                if(temp.right==null) {
                    ans.add(current.val);
                    temp.right = current;
                    current = current.left;
                }
                else {
                    temp.right = null;
                    current = current.right;
                }
            }
        }
        return ans;
    }

    boolean checkIfThreadExistsOrAdd(TreeNode current) {
        TreeNode temp = current.left;
        // System.out.println("Thread: " + temp.val);
        while(temp.right!=null) {
            if(temp.right==current) {
                temp.right = null;
                return true;
            }
            temp = temp.right;
        }
        temp.right = current;
        return false;
    }

    List<Integer> preorderUsingStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            ans.add(current.val);
            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);
        }
        return ans;
    }
}