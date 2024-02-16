class Solution {
    public int maxProfit(int[] prices) {
        // return usingMemoization(prices);
        return usingIteration(prices);
        // return spaceOptimization(prices); 
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
        int[][] dp = new int[n+1][2];
        // base case is 0 & init values in dp is 0
        for(int index=n-1;index>=0;index--) {
            for(int bought=1; bought>=0; bought--) {
                if(bought==0) {
                    int buy = -prices[index] + dp[index+1][1];
                    int dontBuy = dp[index+1][0]; 
                    dp[index][bought] = Math.max(buy, dontBuy);
                }
                else {
                    int sell = prices[index] + dp[index+1][0];
                    int dontSell = dp[index+1][1];
                    dp[index][bought] = Math.max(sell, dontSell);
                }
            }
        }
        return dp[0][0];
    }

    int usingMemoization(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        return recursive(prices, 0, 0, dp);
    }

    int recursive(int[] prices, int index, int bought, int[][] dp) {
        if(index==prices.length) return 0;
        if(dp[index][bought]!=-1) return dp[index][bought];
        if(bought==0) {
            int buy = -prices[index] + recursive(prices, index+1, 1, dp);
            int dontBuy = recursive(prices, index+1, 0, dp);
            return dp[index][bought] = Math.max(buy, dontBuy);
        }
        int sell = prices[index] + recursive(prices, index+1, 0, dp);
        int dontSell = recursive(prices, index+1, 1, dp);
        return dp[index][bought] = Math.max(sell, dontSell);
    }
}