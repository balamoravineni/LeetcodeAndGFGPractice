/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    int val;
    int row;
    Pair(int val, int row) {
        this.val = val;
        this.row = row;
    }
}

class Solution {
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> ansMap = new HashMap<>();
        traverse(root, 0, 0, ansMap);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=minCol;i<=maxCol;i++) {
            List<Pair> temp = ansMap.get(i);
            Collections.sort(temp, (p1, p2) -> p1.row-p2.row==0?p1.val-p2.val:p1.row-p2.row);
            List<Integer> tempArr = new ArrayList<>();
            temp.forEach(p -> tempArr.add(p.val));
            ans.add(tempArr);
        }
        return ans;
    }

    void traverse(TreeNode root, int row, int col, Map<Integer, List<Pair>> ansMap) {
        if(root==null) return;
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        if(!ansMap.containsKey(col)){
            ansMap.put(col, new ArrayList<>());
        }
        ansMap.get(col).add(new Pair(root.val, row));
        traverse(root.left, row+1, col-1, ansMap);
        traverse(root.right, row+1, col+1, ansMap);
    }
}