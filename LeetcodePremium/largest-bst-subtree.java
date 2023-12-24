/*
  Leetcode link: https://leetcode.com/problems/largest-bst-subtree/
  GfG link: https://practice.geeksforgeeks.org/problems/largest-bst/1
  youtube link: https://www.youtube.com/watch?v=X0oXMdtUDwo
*/
//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Trio {
    long nodeMin, nodeMax;
    int maxSize;
    Trio(long a, long b, int c) {
        nodeMin = a;
        nodeMax = b;
        maxSize = c;
    }
}


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    
    static int largestBst(Node root)
    {
        // Write your code here
        Trio ans = helper(root);
        return ans.maxSize; // or ansSize depending on the question
    }
    
    static Trio helper(Node root) {
        if(root==null) return new Trio(Long.MAX_VALUE, Long.MIN_VALUE, 0);
        Trio left = helper(root.left);
        Trio right = helper(root.right);
        if(root.data<right.nodeMin && root.data>left.nodeMax) {
            return new Trio(
                Math.min(root.data, left.nodeMin),
                Math.max(root.data, right.nodeMax),
                1 + left.maxSize + right.maxSize
            );
        }
        return new Trio(
            Long.MIN_VALUE,
            Long.MAX_VALUE,
            Math.max(left.maxSize, right.maxSize)
        );
    }
    
}
