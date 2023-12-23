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
    public TreeNode bstFromPreorder(int[] preorder) {
        // return recursiveHelper(preorder, 0, preorder.length-1);
        // return iterative(preorder);
        return recursiveOptimised(preorder, Integer.MAX_VALUE, new int[1]);
    }

    TreeNode recursiveOptimised(int[] preorder, int bound, int[] start) {
        if(start[0]>=preorder.length || preorder[start[0]]>bound) return null;
        TreeNode root = new TreeNode(preorder[start[0]++]);
        root.left = recursiveOptimised(preorder, root.val, start);
        root.right = recursiveOptimised(preorder, bound, start);
        return root;
    }

    TreeNode iterative(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, Integer.MAX_VALUE));
        int i=1;
        while(i<preorder.length) {
            if(preorder[i]>stack.peek().getValue()) {
                stack.pop();
                continue;
            }
            if(preorder[i]<stack.peek().getKey().val) {
                TreeNode temp = new TreeNode(preorder[i++]);
                stack.peek().getKey().left = temp;
                stack.push(new Pair(temp, stack.peek().getKey().val));
            }
            else {
                TreeNode temp = new TreeNode(preorder[i++]);
                stack.peek().getKey().right = temp;
                stack.push(new Pair(temp, stack.peek().getValue()));
            }
        }
        return root;
    }

    TreeNode recursiveHelper(int[] preorder, int start, int end) {
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int mid = end+1;
        for(int i=start+1;i<=end;i++) {
            if(preorder[i]>preorder[start]) {
                mid = i;
                break;
            }
        }
        root.left = recursiveHelper(preorder,start+1, mid-1);
        root.right = recursiveHelper(preorder, mid, end);
        return root;
    }
}