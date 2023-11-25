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
    Integer index;
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Integer ans = 0;

        Queue<Pair> queue = new LinkedList<>();
        if(root!=null) queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {
            int len = queue.size();
            int offset = queue.peek().index;
            int first = 0,last = 0;
            for(int i=0;i<len;i++) {
                Pair current = queue.remove();
                TreeNode node = current.node;
                int index = current.index-offset;
                if(i==0) first = index;
                if(i==len-1) last = index;
                if(node.left!=null) queue.add(new Pair(node.left, index*2));
                if(node.right!=null) queue.add(new Pair(node.right, (index*2)+1));
                ans = Math.max(ans, last-first+1);
            }
        }
        return ans;
    }
}