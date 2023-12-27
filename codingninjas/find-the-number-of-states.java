/*
  Problem Link: https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943
  Description: You are given 'n' cities, some of which are connected by bidirectional roads. You are also given an ‘n x n’ matrix i.e. roads, where if city ‘i’ and ‘j’ are connected by a road then ‘roads[i][j]'= 1, otherwise ‘roads[i][j]' = 0.
  A province is a group of cities that are either directly or indirectly connected to each other through roads.
  The goal is to count and return the total number of such provinces in the given matrix.
*/


public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
        // Write your code here.
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(visited[i]==false) {
                ans++;
                visited[i] = true;
                dfsHelper(roads, n, i, visited);
            }
        }
        return ans;
    }

    static void dfsHelper(int[][] roads, int n, int city, boolean[] visited) {
        for(int i=0;i<n;i++) {
            if(i!=city && roads[city][i]==1 && !visited[i]) {
                visited[i] = true;
                dfsHelper(roads, n, i, visited);
            }
        }
    }
}
