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
       
        List<Integer> ans = new ArrayList<>(); 
        // Node newRoot = createNewTree(root, null, target);
        // // preorder(newRoot);
        // recursiveDistance(targetNode, k, 0, ans);
        
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        preorder(root, null, parents);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        recursiveDistance(target, parents, visited, k, 0, ans);
        return ans;
    }

    void recursiveDistance(TreeNode root, Map<TreeNode, TreeNode> parents, Map<TreeNode, Boolean> visited, int k, int distance, List<Integer> ans)  {
        if(root==null || visited.get(root)!=null && visited.get(root)==true) return;
        visited.put(root, true);
        if(distance==k) {ans.add(root.val); return;}
        recursiveDistance(root.left, parents, visited, k, distance+1, ans);
        recursiveDistance(root.right, parents, visited, k, distance+1, ans);
        if(parents.get(root)!=null) recursiveDistance(parents.get(root), parents, visited, k, distance+1, ans);
    }

    void preorder(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if(root==null) return;
        parents.put(root, parent);
        preorder(root.left, root, parents);
        preorder(root.right, root, parents);
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