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

class Pair {
    TreeNode node;
    Long index;
    Pair(TreeNode node, Long index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Long ans = 0l;

        Queue<Pair> queue = new LinkedList<>();
        if(root!=null) queue.add(new Pair(root, 0l));

        while(!queue.isEmpty()) {
            int len = queue.size();
            Long minIndex = Long.MAX_VALUE;
            Long maxIndex = Long.MIN_VALUE;
            while(len-->0) {
                Pair current = queue.remove();
                TreeNode node = current.node;
                Long index = current.index;
                minIndex = Math.min(minIndex, index);
                maxIndex = Math.max(minIndex, index);
                if(node.left!=null) queue.add(new Pair(node.left, index*2));
                if(node.right!=null) queue.add(new Pair(node.right, (index*2)+1));
                ans = Math.max(ans, maxIndex-minIndex+1);
            }
        }
        return ans.intValue();
    }
}