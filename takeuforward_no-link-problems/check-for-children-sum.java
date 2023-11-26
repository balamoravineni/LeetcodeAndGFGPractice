/*package whatever //do not write package name here */

/*
Problem Link: https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/
Write a program that converts any binary tree to one that follows the children sum property.
The children sum property is defined as, For every node of the tree, the value of a node is equal to the sum of values of its children(left child and right child).
*/

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
    void childrenSum(TreeNode root) {
        // while(incrementSum(root));
        if(root==null) return;
        int sum = 0;
        if(root.left!=null) sum += root.left.val;
        if(root.right!=null) sum += root.right.val;
        if(root.val<sum) root.val = sum;
        if(root.val>sum) {
            if(root.left!=null) root.left.val = root.val;
            if(root.right!=null) root.right.val = root.val;
        }
        childrenSum(root.left);
        childrenSum(root.right);
        sum = 0;
        if(root.left!=null) sum += root.left.val;
        if(root.right!=null) sum += root.right.val;
        if(root.val<sum) root.val = sum;
    }
}

class GFG {
	public static void main (String[] args) {
		System.out.println("childrenSum of a Binary Tree");
		TreeNode root = new TreeNode(2);
        root.left = new TreeNode(35);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);

        System.out.print("Original Preorder: ");
        preorder(root);
        System.out.println();
        
        new Solution().childrenSum(root);
        
        System.out.print("Modified Preorder: ");
        preorder(root);
        System.out.println();
        
	}
	
	
    static void preorder(TreeNode root) {
        if(root==null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

}
