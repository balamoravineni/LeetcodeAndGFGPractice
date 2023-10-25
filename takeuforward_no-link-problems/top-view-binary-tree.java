/*package whatever //do not write package name here */

/*
  Top View of a Binary Tree 
  Problem link: https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		System.out.println("Top View of a Binary Tree");
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List<Integer> ans = new Solution().topViewBinaryTree(root);
        System.out.println("The Top View is : "+ ans);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    
    int colMin = Integer.MAX_VALUE;
    int colMax = Integer.MIN_VALUE;
    
    public List<Integer> topViewBinaryTree(TreeNode root) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        traverse(root, 0, 0, hashMap);
        List<Integer> ans = new ArrayList<>();
        for(int i=colMin; i<=colMax; i++) ans.add(hashMap.get(i));
        return ans;
    }
    
    public void traverse(TreeNode root, int row, int col, Map<Integer, Integer> hashMap) {
        if(root==null) return;
        colMin = Math.min(colMin, col);
        colMax = Math.max(colMax, col);
        if(!hashMap.containsKey(col)) hashMap.put(col, root.val);
        traverse(root.left, row+1, col-1, hashMap);
        traverse(root.right, row+1, col+1, hashMap);
    }
    
    
}
