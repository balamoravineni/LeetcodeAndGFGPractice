
/*
Problem Link: https://www.codingninjas.com/studio/problems/time-to-burn-tree_630563

*/

/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
import java.util.*;
public class Solution
{

  public static BinaryTreeNode<Integer> startNode;
  public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
  		Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentsMap = new HashMap<>();
  		traverse(root, null, start, parentsMap);
  		Map<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();
  		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
  		queue.add(startNode);
  		visited.put(startNode, true);
  		int time = -1;
  		while(!queue.isEmpty()) {
  			int len = queue.size();
  			time++;
  			while(len-->0) {
  				BinaryTreeNode<Integer> current = queue.remove();
  				if(current.left!=null && visited.get(current.left)==null) {
  					queue.add(current.left);
  					visited.put(current.left, true);
  				}
  				if(current.right!=null && visited.get(current.right)==null) {
  					queue.add(current.right);
  					visited.put(current.right, true);
  				}
  				if(parentsMap.get(current)!=null && visited.get(parentsMap.get(current))==null) {
  					queue.add(parentsMap.get(current));
  					visited.put(parentsMap.get(current), true);
  				}
  			}
  		}
  		return time;
    }

  public static void traverse(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> parent, int start, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentsMap) {
  	if(root==null) return;
  	if(root.data==start) startNode = root;
  	parentsMap.put(root, parent);
  	traverse(root.left, root,  start, parentsMap);
  	traverse(root.right, root,  start, parentsMap);
  }
}

