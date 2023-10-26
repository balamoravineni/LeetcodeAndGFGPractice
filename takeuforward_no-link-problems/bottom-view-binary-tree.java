/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		System.out.println("Bottom View of a Binary Tree");
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        // root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List<Integer> ans = new Solution().bottomViewBinaryTree(root);
        System.out.println("The Bottom View is : "+ ans);
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

class Pair {
    int row;
    // int num;
    List<Integer> nums;
    Pair(int row, int num) {
        this.row = row;
        // this.num = num;
        this.nums = new ArrayList<>();
        this.nums.add(num);
    }
}

class Tuple {
    TreeNode treeNode;
    int row;
    int col;
    Tuple(TreeNode treeNode, int row, int col) {
        this.treeNode = treeNode;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    int colMin = Integer.MAX_VALUE;
    int colMax = Integer.MIN_VALUE;
    
    public List<Integer> bottomViewBinaryTree(TreeNode root) {
        Map<Integer, Pair> hashMap = new HashMap<>();
        // traverse(root, 0, 0, hashMap);
        levelOrderTraverse(root, hashMap);
        List<Integer> ans = new ArrayList<>();
        for(int i=colMin; i<=colMax; i++) {
            // ans.add(hashMap.get(i).num);
            ans.addAll(hashMap.get(i).nums);
        }
        return ans;
    }
    
    public void levelOrderTraverse(TreeNode root, Map<Integer, Pair> hashMap) {
        Queue<Tuple> queue = new LinkedList<>();
        if(root!=null) queue.add(new Tuple(root, 0, 0));
        
        while(!queue.isEmpty()) {
            Tuple current = queue.remove();
            int col = current.col;
            colMin = Math.min(colMin, col);
            colMax = Math.max(colMax, col);
            
            Pair temp = hashMap.get(col);
            if(temp==null || temp.row<current.row) hashMap.put(col, new Pair(current.row, current.treeNode.val));
            else if(temp.row==current.row) hashMap.get(col).nums.add(current.treeNode.val);
            
            if(current.treeNode.left!=null) queue.add(new Tuple(current.treeNode.left, current.row+1, col-1));
            if(current.treeNode.right!=null) queue.add(new Tuple(current.treeNode.right, current.row+1, col+1));
            
        }
    }
    
    public void traverse(TreeNode root, int row, int col, Map<Integer, Pair> hashMap) {
        if(root==null) return;
        colMin = Math.min(colMin, col);
        colMax = Math.max(colMax, col);
        Pair current = hashMap.get(col);
        if(current==null || current.row<row) hashMap.put(col, new Pair(row, root.val));
        else if(current.row==row) hashMap.get(col).nums.add(root.val);
        
        traverse(root.left, row+1, col-1, hashMap);
        traverse(root.right, row+1, col+1, hashMap);
    }
    
    
}
