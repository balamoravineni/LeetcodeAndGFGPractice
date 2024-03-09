/*
  Problem Link: https://www.codingninjas.com/studio/problems/minimal-cost_8180930
  
  Description: 
  There is an array of heights corresponding to 'n' stones. You have to reach from stone 1 to stone ‘n’. 
  From stone 'i', it is possible to reach stones 'i'+1, ‘i’+2… ‘i’+'k' , and the cost incurred will be | Height[i]-Height[j] |, where 'j' is the landing stone.
  Return the minimum possible total cost incurred in reaching the stone ‘n’.
*/

public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        // Integer[] dp = new Integer[n];
        // return recursive(n,k,height,0, dp);
        return iterative(n,k,height);
    }

    static int iterative(int n, int k, int []height) {
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int index=n-2;index>=0;index--) {
            int ans = Integer.MAX_VALUE;
            for(int i=index+1;i<=index+k && i<n;i++) {
                int current = Math.abs(height[i]-height[index]);
                ans = Math.min(ans, current + dp[i]);
            }
            dp[index] = ans;
        }
        return dp[0];
    }

    static int recursive(int n, int k, int []height, int index, Integer[] dp) {
        if(index>=n-1) return 0;
        if(dp[index]!=null) return dp[index];
        int ans = Integer.MAX_VALUE;
        for(int i=index+1;i<=index+k && i<n;i++) {
            int current = Math.abs(height[i]-height[index]);
            ans = Math.min(ans,current + recursive(n,k,height,i, dp));
        }
        return dp[index] = ans;
    }
}
