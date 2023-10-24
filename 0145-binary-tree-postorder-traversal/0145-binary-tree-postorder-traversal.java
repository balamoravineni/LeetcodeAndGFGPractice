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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while(current!=null || !stack.isEmpty()) {
            if(current!=null) {
                stack.push(current);
                current = current.left;
            }
            else {
               if(!stack.isEmpty()) {
                    TreeNode temp = stack.peek().right;
                    if(temp==null) {
                        temp = stack.pop();
                        ans.add(temp.val);
                        while(!stack.isEmpty() && stack.peek().right==temp) {
                            temp = stack.pop();
                            ans.add(temp.val);
                        }
                    }
                    else {
                        current = temp;
                    }
               }
            }
        }
        
        return ans;

    }

}