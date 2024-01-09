/*
  Problem link: https://www.codingninjas.com/studio/problems/single-source-shortest-path_8416371
  Description:
  You are given an undirected graph with 'N' nodes and 'M' edges. The weight of each edge in the graph is one unit.
  Given a source vertex 'src', you must return an array 'answer' of length 'N', where 'answer[i]' is the shortest path length between the source vertex 'src' and 'i'th vertex.
*/

import java.util.*;

public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                int curr = queue.remove();
                ans[curr] = level;
                for(int temp:adjList.get(curr)) {
                    if(!visited[temp]) {
                        queue.add(temp);
                        visited[temp] = true;
                    }
                }
            }
            level++;
        }
        return ans;
    }
}
