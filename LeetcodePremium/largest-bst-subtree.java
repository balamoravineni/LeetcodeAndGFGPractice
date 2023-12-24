/*
  Leetcode link: https://leetcode.com/problems/largest-bst-subtree/
  youtube link: https://www.youtube.com/watch?v=X0oXMdtUDwo
*/

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    
    TreeNode largestBSTinBT(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans; // or ansSize depending on the question
    }
    
    TreeNode ans;
    int ansSize = 0;
    int helper(TreeNode root, long min, long max) {
        if(root==null) return 0;
        int left = helper(root.left, min, root.val);
        int right = helper(root.right, root.val, max);
        if(left==-1 || right==-1) return -1;
        else if(root.val>min && root.val<max){
            int temp = 1+left+right;   
            if(temp>ansSize) {
                ans = root;
                ansSize = temp;
            }
            return temp;
        }
        return -1;
    }
}

class GFG {
	public static void main (String[] args) {
		System.out.println("Binary Search Tree -> Largest BST in BT");
		TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);
        root.right.right.right = new TreeNode(19);

        System.out.print("Original inorder: ");
        inorder(root);
        System.out.println();
        
        TreeNode largestBST = new Solution().largestBSTinBT(root);
        
        System.out.print("largest BST: ");
        inorder(largestBST);
        System.out.println();
        
	}
    
    static void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

}
