class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return recursive(n, dp);
        return iterative(n, dp);
    }

    int iterative(int n, int[] dp) {
        dp[0] = 0;
        for(int j=1;j<=n;j++) {
            int ans = Integer.MAX_VALUE;
            for(int i=1;i*i<=j;i++) {
                ans = Math.min(ans, 1 + dp[j-(i*i)]);
            }
            dp[j] = ans;
        }
        return dp[n];
    }

    int recursive(int n, int[] dp) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            ans = Math.min(ans, 1 + numSquares(n-(i*i)));
        }
        return dp[n]=ans;
    }
}