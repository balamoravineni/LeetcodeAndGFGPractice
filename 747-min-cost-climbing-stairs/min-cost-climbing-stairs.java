class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return recursive(-1, cost, dp);
    }

    int recursive(int step, int[] cost, int[] dp) {
        if(step>=cost.length) return 0;
        if(dp[step+1]!=-1) return dp[step+1];
        int current = step==-1?0:cost[step];
        int oneStep = recursive(step+1, cost, dp);
        int twoSteps = recursive(step+2, cost, dp);
        return dp[step+1] = current + Math.min(oneStep, twoSteps);
    }
}