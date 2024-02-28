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

class Answer {
    int value;
    int height;
    Answer(int a, int b) {
        value = a;
        height = b;
    }
}
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Answer ans = recursive(root, 0);
        return ans.value;
    }

    Answer recursive(TreeNode root, int height) {
        if(root==null) return null;
        Answer left = recursive(root.left, height+1);
        Answer right = recursive(root.right, height+1);
        if(left==null && right==null) {
            return new Answer(root.val, height);
        }
        else if(left!=null && right!=null) {
            if(left.height>=right.height) return left;
            else return right;
        }
        else if(left==null) return right;
        return left;
    }
}