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

class Value {
    boolean foundStart;
    int time;
    int distance;
    Value(boolean a, int b, int c) {
        foundStart = a;
        time = b;
        distance = c;
    }
}
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Value val = helper(root, start);
        return val.time;
    }

    Value helper(TreeNode root, int start) {
        if(root==null) return new Value(false, 0, -1);
        Value left = helper(root.left, start);
        Value right = helper(root.right, start);
        if(root.val==start) {
            return new Value(true, Math.max(left.time, right.time), 1);
        }
        else if(right.foundStart) {
            int time = Math.max(right.distance, right.time);
            time = Math.max(time, right.distance+left.time);
            return new Value(true, time, right.distance+1);
        }
        else if(left.foundStart) {
            int time = Math.max(left.distance, left.time);
            time = Math.max(time, left.distance+right.time);
            return new Value(true, time, left.distance+1);
        }
        return new Value(false, 1+ Math.max(left.time, right.time), -1);
    }
}