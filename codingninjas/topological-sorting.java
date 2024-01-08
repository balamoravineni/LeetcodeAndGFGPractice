/*
  Problem link: https://www.codingninjas.com/studio/problems/topological-sorting_973003
  Description: Given a DAG(direct acyclic graph), print Topological Sorting of a given graph
*/

import java.util.*;
public class Solution {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<v;i++) adjList.add(new ArrayList<>());
        int[] inDegree = new int[v];
        for(int i=0;i<e;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            inDegree[edges[i][1]]++;
        }
        // return usingDFS(adjList, v);
        return usingBFS(adjList, v, inDegree);
    }

    static List<Integer> usingBFS(List<List<Integer>> adjList, int n, int[] inDegree) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) queue.add(i);
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            ans.add(curr);
            for(int temp: adjList.get(curr)) {
                inDegree[temp]--;
                if(inDegree[temp]==0) queue.add(temp);
            }
        }
        return ans;
    }

    static List<Integer> usingDFS(List<List<Integer>> adjList, int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) dfs(adjList, visited, i, ans);
        }
        Collections.reverse(ans);
        return ans;
    }

    static void dfs(List<List<Integer>> adjList, boolean[] visited, int index, List<Integer> stack) {
        visited[index] = true;
        for(int temp: adjList.get(index)) {
            if(!visited[temp]) dfs(adjList, visited, temp, stack);
        }
        stack.add(index);
    }

}
