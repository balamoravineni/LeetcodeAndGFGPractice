/* 
  Leetcode link: https://leetcode.com/problems/inorder-successor-in-bst/
  Youtube link: https://www.youtube.com/watch?v=SXKAD2svfmI
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
    TreeNode inorderSuccessor(TreeNode root, int target) {
        TreeNode ans = null;
        while(root!=null && root.val!=target) {
            if(root.val>target) {
                ans = root;
                root = root.left;
            }
            else root = root.right;
        }
        if(root.right!=null) return root.right;
        return ans;
    }
    
    TreeNode inorderPredecessor(TreeNode root, int target) {
        TreeNode ans = null;
        while(root!=null && root.val!=target) {
            if(root.val>target) root = root.left;
            else {
                ans = root;
                root = root.right;
            }
        }
        if(root.left!=null) return root.left;
        return ans;
    }
}

class GFG {
	public static void main (String[] args) {
		System.out.println("Binary Search Tree -> Inorder Successor/Predecessor");
		TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);

        System.out.print("Original inorder: ");
        inorder(root);
        System.out.println();
        
        TreeNode inorderSuccessor = new Solution().inorderSuccessor(root, 4);
        TreeNode inorderPredecessor = new Solution().inorderPredecessor(root, 4);
        
        System.out.print("Inorder Successor: ");
        if(inorderSuccessor!=null)  System.out.print(inorderSuccessor.val);
        else System.out.print("Not Present");
        System.out.println();
        
        System.out.print("Inorder Predecessor: ");
        if(inorderPredecessor!=null)  System.out.print(inorderPredecessor.val);
        else System.out.print("Not Present");
        System.out.println();
        
	}
    
    static void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

}
