class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp = new int[cost.length+1];
        // Arrays.fill(dp,-1);
        // return recursive(-1, cost, dp);

        // return iterative(cost);
        return spaceOptimized(cost);
    }

    int spaceOptimized(int[] cost) {
        int totalCost = 0;
        int twoSteps = cost[cost.length-1];
        int oneStep = cost[cost.length-2];
        for(int i=cost.length-2;i>=0;i--) {
            int current = i>=1?cost[i-1]:0;
            totalCost = current + Math.min(oneStep, twoSteps);
            twoSteps = oneStep;
            oneStep = totalCost;
        }
        return totalCost;
    }

    int iterative(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[cost.length] = cost[cost.length-1];
        dp[cost.length-1] = cost[cost.length-2];
        for(int i=cost.length-2;i>=0;i--) {
            int current = i>=1?cost[i-1]:0;
            int oneStep = dp[i+1];
            int twoSteps = dp[i+2];
            dp[i] = current + Math.min(oneStep, twoSteps);
        }
        return dp[0];
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