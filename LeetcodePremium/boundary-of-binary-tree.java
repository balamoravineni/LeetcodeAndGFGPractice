
/*
Problem Link: https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/
LeetCode Premium link: https://leetcode.com/problems/boundary-of-binary-tree/
*/
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Boundary Traversal (leetcode premium) :)");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        
        
        System.out.println("boundaryTraversal: "+ new Solution().boundaryTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
        
    }
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    
    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        // left boundary
        TreeNode current = root;
        while(true) {
            if(current.left==null && current.right==null) break;
            ans.add(current.val);
            if(current.left!=null) current = current.left;
            else current = current.right;
        }
        
        // leaf nodes 
        collectLeaves(root, ans);
        
        //right boundary
        current = root.right;
        if(current==null) return ans;
        Deque<Integer> tempStack = new ArrayDeque<>();
        while(true) {
            if(current.right==null && current.left==null) break;
            tempStack.push(current.val);
            if(current.right!=null) current = current.right;
            else current = current.left;
        }
        while(!tempStack.isEmpty()) {
            ans.add(tempStack.pop());
        }
        return ans;
    }
    
    public void collectLeaves(TreeNode root, List<Integer> ans) {
        if(root.left==null && root.right==null) {
            ans.add(root.val);
            return;
        }
        if(root.left!=null) collectLeaves(root.left, ans);
        if(root.right!=null) collectLeaves(root.right, ans);
    } 
}
