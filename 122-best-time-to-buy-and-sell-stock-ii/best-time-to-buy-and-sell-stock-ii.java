class Solution {
    public int maxProfit(int[] prices) {
        // return usingMemoization(prices);
        // return usingIteration(prices);
        return spaceOptimization(prices);
    }

    int spaceOptimization(int[] prices) {
        int n = prices.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        // base case is 0 & init values in dp is 0
        for(int index=n-1;index>=0;index--) {
            for(int boughtIndex=index-1; boughtIndex>=-1; boughtIndex--) {
                if(boughtIndex==-1) {
                    int buy = next[index+1];
                    int dontBuy = next[0]; 
                    curr[boughtIndex+1] = Math.max(buy, dontBuy);
                }
                else {
                    int sell = prices[index]-prices[boughtIndex] + next[0];
                    int dontSell = next[boughtIndex+1];
                    curr[boughtIndex+1] = Math.max(sell, dontSell);
                }
            }
            next = curr;
        }
        return next[0];
    }

    int usingIteration(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][n+1];
        // base case is 0 & init values in dp is 0
        for(int index=n-1;index>=0;index--) {
            for(int boughtIndex=index-1; boughtIndex>=-1; boughtIndex--) {
                if(boughtIndex==-1) {
                    int buy = dp[index+1][index+1];
                    int dontBuy = dp[index+1][0]; 
                    dp[index][boughtIndex+1] = Math.max(buy, dontBuy);
                }
                else {
                    int sell = prices[index]-prices[boughtIndex] + dp[index+1][0];
                    int dontSell = dp[index+1][boughtIndex+1];
                    dp[index][boughtIndex+1] = Math.max(sell, dontSell);
                }
            }
        }
        return dp[0][0];
    }

    int usingMemoization(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        return recursive(prices, 0, -1, dp);
    }

    int recursive(int[] prices, int index, int boughtIndex, int[][] dp) {
        if(index==prices.length) return 0;
        if(dp[index][boughtIndex+1]!=-1) return dp[index][boughtIndex+1];
        if(boughtIndex==-1) {
            int buy = recursive(prices, index+1, index, dp);
            int dontBuy = recursive(prices, index+1, -1, dp);
            return dp[index][boughtIndex+1] = Math.max(buy, dontBuy);
        }
        int sell = prices[index]-prices[boughtIndex] + recursive(prices, index+1, -1, dp);
        int dontSell = recursive(prices, index+1, boughtIndex, dp);
        return dp[index][boughtIndex+1] = Math.max(sell, dontSell);
    }
}