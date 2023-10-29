
/*
Problem Link (InterviewBit) - https://www.interviewbit.com/problems/path-to-given-node/

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.
*/






/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        // TODO
        ArrayList<Integer> ans = new ArrayList<>();
        recursive(A, B, ans);
        return ans;
    }
    
    boolean recursive(TreeNode root, int B, ArrayList<Integer> ans) {
        if(root==null) return false;
        if(root.val==B) {
            ans.add(B);
            return true;
        }
        ans.add(root.val);
        if(recursive(root.left, B, ans)) return true;
        if(recursive(root.right, B, ans)) return true;
        ans.remove(ans.size()-1);
        return false;
    }
}
