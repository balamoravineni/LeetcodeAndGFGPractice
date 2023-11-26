/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Node targetNode = null;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Node newRoot = createNewTree(root, null, target);
        // preorder(newRoot);
        List<Integer> ans = new ArrayList<>();
        recursiveDistance(targetNode, k, 0, ans);
        return ans;
    }

    void recursiveDistance(Node root, int k, int distance, List<Integer> ans)  {
        if(root==null || root.visited) return;
        root.visited = true;
        if(distance==k) {
            ans.add(root.node.val);
            return;
        }
        recursiveDistance(root.left, k, distance+1, ans);
        recursiveDistance(root.right, k, distance+1, ans);
        if(root.parent!=null) recursiveDistance(root.parent, k, distance+1, ans);
    }

    Node createNewTree(TreeNode root, Node parent, TreeNode target) {
        if(root==null) return null;
        Node current = new Node(root, parent);
        current.left = createNewTree(root.left, current, target);
        current.right = createNewTree(root.right, current, target);
        if(root==target) targetNode = current;
        return current;
    }

    void preorder(Node root) {
        if(root==null) return;
        System.out.print(root.node.val + " ");
        preorder(root.left);
        preorder(root.right); 
    }
    
}

class Node {
    TreeNode node;
    Node parent;
    Node left;
    Node right;
    boolean visited = false;
    Node(TreeNode node, Node parent) {
        this.node = node;
        this.parent = parent;
    }
}