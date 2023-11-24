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
    boolean incrementSum(TreeNode root) {
        if(root==null) return false;
        int leftVal = 0, rightVal = 0;
        boolean current = false;
        if(root.left!=null) leftVal = root.left.val;
        if(root.right!=null) rightVal = root.right.val;
        if(root.val<leftVal+rightVal) {
            root.val = leftVal+rightVal;
            current = true;
        }
        boolean left = incrementSum(root.left);
        boolean right = incrementSum(root.right);
        return current||left||right;
    }
    
    void recursive(TreeNode root) {
        while(incrementSum(root));
    }
}

class GFG {
	public static void main (String[] args) {
		System.out.println("childrenSum of a Binary Tree");
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        // root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        System.out.print("Original Preorder: ");
        preorder(root);
        System.out.println();
        
        new Solution().recursive(root);
        
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
