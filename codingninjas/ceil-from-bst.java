/*
Problem Link: https://www.codingninjas.com/studio/problems/ceil-from-bst_920464


*/

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        int ans = -1;
        while(node!=null) { 
            if(node.data>=x) {
                ans = node.data;
            }
            if(node.data==x) break;
            else if(node.data>x) node = node.left;
            else node = node.right;
        }
        return ans;
    }
}
