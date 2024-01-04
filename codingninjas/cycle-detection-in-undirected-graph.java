/*
  Problem link: https://www.codingninjas.com/studio/problems/1062670
  Description:
  You have been given an undirected graph with 'N' vertices and 'M' edges. The vertices are labelled from 1 to 'N'.
  Your task is to find if the graph contains a cycle or not.
  A path that starts from a given vertex and ends at the same vertex traversing the edges only once is called a cycle.
*/

import java.util.*;
public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++) {
            adjList.get(edges[i][0]-1).add(edges[i][1]-1);
            adjList.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        int[] visited = new int[n];
        for(int i=0;i<n;i++) {
            if(visited[i]==0 && dfsIsCycle(adjList, visited, i, -1)) return "Yes";
        }
        return "No";
    }

    static boolean dfsIsCycle(List<List<Integer>> adjList, int[] visited, int index, int parent) {
        visited[index] = 1;
        for(int temp: adjList.get(index)) {
            if(temp!=parent && visited[temp]==1) return true;
            if(visited[temp]==0 && dfsIsCycle(adjList, visited, temp, index)) return true;
        }
        return false;
    }
    
}
