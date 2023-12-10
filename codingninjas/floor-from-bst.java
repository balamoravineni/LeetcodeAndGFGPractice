/*
Problem Link: https://www.codingninjas.com/studio/problems/floor-from-bst_920457
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

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int ans = -1;
        while(root!=null) {
            if(root.data==X) {
                return X;
            }
            if(root.data>X) {
                root = root.left;
            }
            else {
                ans = root.data;
                root = root.right;
            }
        }
        return ans;
    }
}
