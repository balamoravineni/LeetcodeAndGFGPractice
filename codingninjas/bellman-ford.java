/*
  Problem link: https://www.codingninjas.com/studio/problems/bellman-ford_2041977
  Description:
  You have been given a directed weighted graph of ‘N’ vertices labeled from 1 to 'N' and ‘M’ edges. 
  Each edge connecting two nodes 'u' and 'v' has a weight 'w' denoting the distance between them.
  Your task is to calculate the shortest distance of all vertices from the source vertex 'src'.
  If there is no path between 'src' and 'ith' vertex, the value at 'ith' index in the answer array will be 10^8.
*/
import java.util.*;
public class Solution {
    // To find if there is a negative cycle, iterate one more time (nth time) 
    //      & if dist array is still updated, then there is a negative cycle in the given graph otherwise not.
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.
        int dist[] = new int[n+1];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        for(int i=0;i<n-1;i++) {
            for(List<Integer> edge: edges) {
                int curr = edge.get(0);
                int next = edge.get(1);
                int weight = edge.get(2);
                if(dist[curr]!=Integer.MAX_VALUE && dist[curr]+weight<dist[next]) {
                    dist[next] = dist[curr]+weight;
                }
            }
        }
        return dist;
    }
}
