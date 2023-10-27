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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Integer temp = null;
            while(size-->0) {
                TreeNode current = queue.remove();
                if(temp==null) temp = current.val;
                if(current.right!=null) queue.add(current.right);
                if(current.left!=null) queue.add(current.left);
            }
            ans.add(temp);
        }
        return ans;
    }
}