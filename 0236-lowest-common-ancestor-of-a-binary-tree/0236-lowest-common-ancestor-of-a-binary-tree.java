/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Node {
    int val;
    Node left;
    Node right;
    Node parent;
    Node(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // // --> brute force
        // return traverse(root, p, q);
        
        // // --> constructing new tree - O(N) time, extra space
        // Node newRoot = createNewTree(root, null, p, q); // newP, newQ will exist
        // Set<Integer> pathP = new HashSet<>();
        // pathToRoot(newP, pathP);
        // Integer intersectionVal = pathToRootQ(newQ, pathP);
        // return getTreeNode(root, intersectionVal);

        // --> finding Ancestor through Paths
        // return findLCA(root, p, q);

        // recursive simple approach based on intuition
        if(root==null || root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null) {
            return right;
        }
        else if (right==null) {
            return left;
        }
        else {
            return root;
        }

    }

    // finding Ancestor through Paths
    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        if(pathP.contains(q)) return q;
        if(pathQ.contains(p)) return p;
        int size = Math.min(pathP.size(), pathQ.size());
        TreeNode ancestor = null;
        // pathP.forEach( i -> System.out.print(i.val + " "));
        // System.out.println();
        // pathQ.forEach( i -> System.out.print(i.val + " "));
        for(int i=0;i<size;i++) {
            if(pathP.get(i)==pathQ.get(i)) ancestor = pathP.get(i);
            else break;
        }
        return ancestor;
    }
    boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root==null) return false;
        if(root==target) return true;
        path.add(root);
        if(findPath(root.left, target, path)) return true;
        if(findPath(root.right, target, path)) return true;
        path.remove(path.size()-1);
        return false;
    }

    // constructing new tree - O(N) time, extra space
    Node newP, newQ;

    Node createNewTree(TreeNode root, Node parent, TreeNode p, TreeNode q) {
        if(root==null) return null;
        Node newRoot = new Node(root.val);
        newRoot.left = createNewTree(root.left, newRoot, p, q);
        newRoot.right = createNewTree(root.right, newRoot, p, q);
        newRoot.parent = parent;
        if(root.val==p.val) newP = newRoot;
        if(root.val==q.val) newQ = newRoot;
        return newRoot;
    }

    void pathToRoot(Node current, Set<Integer> path) {
        if(current==null) return;
        path.add(current.val);
        pathToRoot(current.parent, path);
    }

    Integer pathToRootQ(Node current, Set<Integer> path) {
        if(current==null) return null;
        if(path.contains(current.val)) return current.val;
        return pathToRootQ(current.parent, path);
    }

    TreeNode getTreeNode(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val) return root;
        TreeNode left = getTreeNode(root.left, val);
        if(left!=null) return left;
        return getTreeNode(root.right, val);
    }


    // brute force
    TreeNode traverse(TreeNode root, TreeNode p, TreeNode q) {
        if(isAncestor(root.left, p, q)) {
            return traverse(root.left, p, q);
        }
        else if(isAncestor(root.right, p, q)) {
            return traverse(root.right, p, q);
        }
        else return root;
    }

    boolean isAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> inorderSet = new HashSet<>();
        inorder(root, inorderSet);
        if(inorderSet.contains(p.val) && inorderSet.contains(q.val)) return true;
        return false;
    }

    void inorder(TreeNode root, Set<Integer> inorderSet) {
        if(root==null) return;
        inorderSet.add(root.val);
        inorder(root.left, inorderSet);
        inorder(root.right, inorderSet);
    }
    
}