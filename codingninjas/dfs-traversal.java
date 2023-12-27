/*
  Problem link: https://www.codingninjas.com/studio/problems/dfs-traversal_630462
  Description: Given an undirected and disconnected graph G(V, E), containing 'V' vertices and 'E' edges, 
  the information about edges is given using 'GRAPH' matrix, where i-th edge is between GRAPH[i][0] and GRAPH[i][1]. 
  print its DFS traversal.
  V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
  E is the number of edges present in graph G
*/


import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<v;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<e;i++) {
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adjList.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(!visited[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfsHelper(v,adjList,temp,i,visited);
                ans.add(temp);
            }
            
        }
        // System.out.println(ans);
        return ans;
    }

    static void dfsHelper(int n, List<List<Integer>> adjList, ArrayList<Integer> ans, int index, boolean[] visited) {
        visited[index] = true;
        ans.add(index);
        for(int i=0;i<adjList.get(index).size();i++) {
            if(!visited[adjList.get(index).get(i)]) {
                dfsHelper(n,adjList,ans,adjList.get(index).get(i),visited);
            }
        }
    }
}
