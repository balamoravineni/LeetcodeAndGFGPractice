/*
Problem link: https://www.codingninjas.com/studio/problems/floyd-warshall_2041979
Description:
You have been given a directed weighted graph of ‘N’ vertices labeled from 1 to 'N' and ‘M’ edges. 
Each edge connecting two nodes 'u' and 'v' has a weight 'w' denoting the distance between them.
Your task is to find the length of the shortest path between the ‘src’ and ‘dest’ vertex given to you in the graph using Flloyd warshall’s algorithm. 
The graph may contain negatively weighted edges.
*/

import java.util.*;

public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    // Write your code here.
    // To check if the graph contains negative cycle, after computing dist matrix, check for all i, dist[i][i], 
    // if any value is less than zero, then the graph contains negative cycle otherwise not.
    int[][] adjMatrix = new int[n+1][n+1];
    for(int temp[]: adjMatrix) Arrays.fill(temp, Integer.MAX_VALUE);
    for(int i=1;i<=n;i++) adjMatrix[i][i] = 0;
    for(ArrayList<Integer> edge: edges) adjMatrix[edge.get(0)][edge.get(1)] = edge.get(2);
    int[][] dist = new int[n+1][n+1];
    for(int i=1;i<=n;i++) for(int j=1;j<=n;j++) dist[i][j] = adjMatrix[i][j];
    for(int k=1;k<=n;k++) {
      for(int i=1;i<=n;i++) {
        for(int j=1;j<=n;j++) {
          if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE) 
            dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
        }
      }
    }
    return dist[src][dest]!=Integer.MAX_VALUE?dist[src][dest]:(int)1e9;
  }

}
