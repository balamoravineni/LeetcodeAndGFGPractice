class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursive(0, n, dp);
    }

    int recursive(int i, int n,int[] dp) {
        if(i>n) return 0;
        else if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        return dp[i] = recursive(i+1, n, dp) + recursive(i+2, n, dp);
    }
}