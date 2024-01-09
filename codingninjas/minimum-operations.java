/*
  Problem link: https://www.codingninjas.com/studio/problems/minimum-operations_8360665
  Description:
  You are given an array 'A' of length 'N' and integers 'start' and 'end'. 
  In one operation, you can multiply 'start' by any element of 'A' and take modulo with ‘mod’. In this problem, 'mod' is 10^3.
  Return the minimum number of operations required to make 'start' equal to 'end'. If it is not possible, then return -1.
*/

import java.util.*;
import javafx.util.Pair;
public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here
        // we can't solve it with DP because this problem forms a infinite tree after mod value, and tree might repeat itself for some testcases
        // and if we get stuck in some branch which doesn't have 'end', we get stackOverflow error
        if(start==end) return 0;
        int[] dist = new int[1000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            for(int i=0;i<n;i++) {
                int next = (curr*a[i])%1000;
                if(dist[next]>dist[curr]+1) {
                    if(next==end) return dist[curr]+1;
                    dist[next] = dist[curr]+1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
