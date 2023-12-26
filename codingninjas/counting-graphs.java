/*
  Problem link: https://www.codingninjas.com/studio/problems/counting-graphs_8357237
  Statement: Return the number of undirected graphs that can be formed using  vertices, 
  allowing for disconnected components within the graph. Self-edges and multiple edges  are not allowed.
*/

public class Solution {
    public static int countingGraphs(int N) {
        // Write your code here.
        int n = ((N)*(N-1))/2;
        double ans = 0;
        for(int i=0;i<=n;i++) {
            ans += C(n,i); // nCi
        }
        return (int)ans;
    }

    static double C(int n, int i) {
        if(i==0||i==n) return 1;
        if(i>n/2) return C(n, n-i);
        return helper(n,i)/helper(i,i);
    }

    static double helper(int n, int i) {
        double ans = 1.0;
        while(i-->0) {
            ans*=n--;
        }
        return ans;
    }
}
