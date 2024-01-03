/*
  Problem link: https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph-_920545
  Description: 
  Given a directed graph, check whether the graph contains a cycle or not. 
  Your function should return true if the given graph contains at least one cycle, else return false.
*/


import java.util.*;

public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        // Write your code here.
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<v;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<e;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(!visited[i]) {
                if(dfs(adjList,i,visited, new boolean[v])) return true;
            }
        }
        return false;
	}

    static Boolean dfs(List<List<Integer>> adjList, int index, boolean[] visited, boolean[] pathVisited) {
        visited[index]=true;
        pathVisited[index]=true;
        for(int temp: adjList.get(index)) {
            if(pathVisited[temp]) return true;
            if(!pathVisited[temp]) {
                if(dfs(adjList,temp,visited, pathVisited)) return true;
            }
        }
        pathVisited[index] = false;
        return false;
    }


}
