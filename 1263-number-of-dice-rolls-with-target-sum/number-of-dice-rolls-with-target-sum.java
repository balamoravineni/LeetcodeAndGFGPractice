class Solution {
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        return helper(n,k,target,dp);
    }

    int helper(int n, int k, int target, int[][] dp) {
        if(n==0 && target==0) return 1;
        else if(n==0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        long ans = 0;
        for(int i=1;i<=k;i++) {
            if(target-i>=0) ans += helper(n-1,k,target-i,dp);
        }
        return dp[n][target] = (int)(ans%(Math.pow(10,9) + 7l));
    }
}