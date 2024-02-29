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
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        return dfs(root, 0, map);
    }

    boolean dfs(TreeNode root, int level, Map<Integer,Integer> map) {
        if(root==null) return true;
        if(level%2==0 && (root.val%2==0 || root.val<=map.getOrDefault(level, 0))) {
            // System.out.println(level + "-> " + root.val + "-> " + map);
            return false;
        }
        if(level%2==1 && (root.val%2==1 || root.val>=map.getOrDefault(level, Integer.MAX_VALUE))) {
            // System.out.println(level + "-> " + root.val + "-> " + map);
            return false;
        }
        map.put(level, root.val);
        boolean left = dfs(root.left, level+1, map);
        boolean right = dfs(root.right, level+1, map);
        return left && right;
    }
} 