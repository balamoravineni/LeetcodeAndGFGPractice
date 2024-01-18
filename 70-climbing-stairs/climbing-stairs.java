class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return recursive(0,n,dp);
    }

    int recursive(int i, int n, int[] dp) {
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        int one = recursive(i+1,n, dp);
        int two = 0;
        if(i+2<=n) two = recursive(i+2,n, dp);
        return dp[i] = one+two;
    }
}