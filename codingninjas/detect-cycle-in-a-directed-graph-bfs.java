/*
  Problem link: https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph_1062626
  Description: 
    You are given a directed graph having ‘N’ nodes. 
    A matrix ‘EDGES’ of size M x 2 is given which represents the ‘M’ edges such that there is an edge directed from node EDGES[i][0] to node EDGES[i][1].
    Find whether the graph contains a cycle or not, return true if a cycle is present in the given directed graph else return false.
*/

import java.util.*;
public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
      // Write your code here.
      List<List<Integer>> adjList = new ArrayList<>();
      for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
      int[] inDegree = new int[n];
      for(int i=0;i<edges.size();i++) {
        adjList.get(edges.get(i).get(0)-1).add(edges.get(i).get(1)-1);
        inDegree[edges.get(i).get(1)-1]++;
      }
      return usingBFS(adjList, n, inDegree);
    }

    static boolean usingBFS(List<List<Integer>> adjList, int n, int[] inDegree) {
        // List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) queue.add(i);
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            // ans.add(curr);
            for(int temp: adjList.get(curr)) {
                inDegree[temp]--;
                if(inDegree[temp]==0) queue.add(temp);
            }
        }
        for(int d: inDegree) if(d!=0) return true;
        return false;
    }
}
