/*
  Problem Link: https://www.codingninjas.com/studio/problems/creating-and-printing_1214551
  Description: You are given an undirected graph of 'N' nodes and 'M' edges. Your task is to create the graph and print the adjacency list of the graph. It is guaranteed that all the edges are unique, i.e., if there is an edge from 'X' to 'Y', then there is no edge present from 'Y' to 'X' and vice versa. Also, there are no self-loops present in the graph.
  In graph theory, an adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a vertex in the graph.
*/

import java.util.*;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Write your code here.
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i);
        }
        for(int i=0;i<m;i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int[][] ans = new int[n][];
        for(int i=0;i<n;i++) {
            ans[i] = new int[adjList.get(i).size()];
            for(int j=0;j<adjList.get(i).size();j++) {
                ans[i][j] = adjList.get(i).get(j);
            }
        }
        return ans;
    }
}
