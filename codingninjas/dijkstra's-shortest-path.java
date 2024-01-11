/*
  Problem link: https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358
  Description:
  You have been given an undirected, connected graph of ‘V’ vertices (labelled from 0 to V-1) and ‘E’ edges. 
  Each edge connecting two nodes 'u' and 'v' has a weight denoting the distance between them.
  Your task is to find the shortest path distance from the source node 'S' to all the vertices. 
  You have to return a list of integers denoting the shortest distance between each vertex and source vertex 'S'.
*/

import java.util.*;
import javafx.util.Pair;
public class Solution {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // Write your code here.
        int n = vertices;
        int m = edges;
        List<List<Pair<Integer,Integer>>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++) {
            adjList.get(edge[i][0]).add(new Pair(edge[i][1], edge[i][2]));
            adjList.get(edge[i][1]).add(new Pair(edge[i][0], edge[i][2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1,p2) -> p1.getKey()-p2.getKey());
        pq.add(new Pair(0, source));
        dist[source] = 0;
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.remove();
            int currWeight = curr.getKey();
            int currNode = curr.getValue();
            for(Pair<Integer,Integer> temp: adjList.get(currNode)) {
                int nextNode = temp.getKey();
                int nextWeight = temp.getValue();
                if(dist[nextNode]>currWeight+nextWeight) {
                    dist[nextNode] = currWeight+nextWeight;
                    pq.add(new Pair(dist[nextNode], nextNode));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(dist[i]);
        return ans;
    }
}
