/*
  Problem link: https://www.codingninjas.com/studio/problems/bfs-in-graph_973002
  
  Description: Given an adjacency list representation of a directed graph with 'n' vertices and 'm' edges. 
  Your task is to return a list consisting of Breadth-First Traversal (BFS) starting from vertex 0.
  In this traversal, one can move from vertex 'u' to vertex 'v' only if there is an edge from 'u' to 'v'. 
  The BFS traversal should include all nodes directly or indirectly connected to vertex 0. 
  Note: The traversal should proceed from left to right according to the input adjacency list.
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        ans.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int current = queue.remove();
            for(Integer temp: adj.get(current)) {
                if(!visited[temp]) {
                    queue.add(temp);
                    ans.add(temp);
                    visited[temp] = true;
                }
            }
        }
        return ans;
    }
}

