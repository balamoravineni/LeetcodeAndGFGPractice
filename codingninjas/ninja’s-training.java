/*
  Problem Link: https://www.codingninjas.com/studio/problems/ninja%E2%80%99s-training_3621003
  Description:
  Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). 
  Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. 
  Can you help Ninja find out the maximum merit points Ninja can earn?You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. 
  Your task is to calculate the maximum number of merit points that Ninja can earn.
*/


import java.util.*;

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..

        // int[][] dp = new int[n][4];
        // for(int[] temp: dp) Arrays.fill(temp, -1);
        // return recursive(n, points, 0, -1, dp);

        // return iterative(n, points);

        return optimised(n,points);
    }

    static int optimised(int n, int points[][]) {
        int[] prev = new int[3];
        prev[0] = points[0][0];
        prev[1] = points[0][1];
        prev[2] = points[0][2];
        for(int i=1;i<n;i++) {
            int[] curr = new int[3];
            for(int j=0;j<3;j++) {
                int ans = -1;
                for(int k=0;k<3;k++) {
                    if(j!=k) {
                        ans = Math.max(ans,  prev[k]);
                    }
                }
                curr[j] = points[i][j] + ans;
            }
            prev = curr;
        }
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }

    static int iterative(int n, int points[][]) { 
        int[][] dp = new int[n][3];
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];
        for(int i=1;i<n;i++) {
            for(int j=0;j<3;j++) {
                int ans = -1;
                for(int k=0;k<3;k++) {
                    if(j!=k) {
                        ans = Math.max(ans, points[i][j] + dp[i-1][k]);
                    }
                }
                dp[i][j] = ans;
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }

    static int recursive(int n, int points[][], int i, int lastActivity, int[][] dp) {
        if(i==n) return 0;
        if(dp[i][lastActivity+1]!=-1) return dp[i][lastActivity+1];
        int ans = -1;
        for(int k=0;k<3;k++) {
            if(lastActivity!=k) {
                ans = Math.max(ans, points[i][k] + recursive(n, points,i+1, k, dp));
            }
        }
        return dp[i][lastActivity+1] = ans;
    }

}
