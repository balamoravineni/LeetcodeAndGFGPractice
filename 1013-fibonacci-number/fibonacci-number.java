class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return recursive(n, dp);
    }

    int recursive(int n, int[] dp) {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = recursive(n-1, dp) + recursive(n-2, dp);
    }
}