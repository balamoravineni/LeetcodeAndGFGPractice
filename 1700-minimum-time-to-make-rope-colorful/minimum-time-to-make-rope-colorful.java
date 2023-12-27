class Solution {
    public int minCost(String colors, int[] neededTime) {
        // initially thought it was a DP problem, since given two options in every iteration & time complexity grows.
        // return recursiveHelper(colors.toCharArray(), neededTime, 0, -1);

        // But to convert above recursive problem into DP, requires 2D array (with lot of empty space too) & its giving time limit exceeded
        // int[][] dp = new int[colors.length()+1][colors.length()+1];
        // for(int[] temp: dp) Arrays.fill(temp, -1);
        // return recursiveHelperWith2D_DP(colors.toCharArray(), neededTime, 0, -1, dp);

        // But later if you think about it, it is a greedy problem. think in terms of color groups instead of single iteration. In any given color group of x balloons, we need to remove x-1 balloons having taking minimum time to remove, which means you need to add all the times to remove ballonons in a color group & remove the one taking maxTime
        return greedySlidingWindow(colors, neededTime);

    }

    int greedySlidingWindow(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans = 0;
        int i=0;
        while(i<n) {
            int j=i+1;
            int removeAll=neededTime[i];
            int maxTime=neededTime[i];
            while(j<n && colors.charAt(i)==colors.charAt(j)) {
                removeAll+=neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            ans += removeAll-maxTime;
            i=j;
        }
        return ans;
    }

    int recursiveHelperWith2D_DP(char[] colors, int[] neededTime, int index, int prevIndex, int[][] dp) {
        if(index==colors.length) return 0;
        if(dp[index][prevIndex+1]!=-1) return dp[index][prevIndex+1];
        if(prevIndex>=0 && colors[prevIndex]==colors[index]) {
            // remove prevColor
            int removePrev = neededTime[prevIndex] + recursiveHelperWith2D_DP(colors, neededTime, index+1, index, dp);
            // OR remove currentColor
            int removeCurrent = neededTime[index] + recursiveHelperWith2D_DP(colors, neededTime, index+1, prevIndex, dp);
            return dp[index][prevIndex+1] = Math.min(removePrev, removeCurrent);
        }
        return dp[index][prevIndex+1] = recursiveHelperWith2D_DP(colors, neededTime, index+1, index, dp);
    }

    int recursiveHelper(char[] colors, int[] neededTime, int index, int prevIndex) {
        if(index==colors.length) return 0;
        // int removePrev, removeCurrent;
        if(prevIndex>=0 && colors[prevIndex]==colors[index]) {
            // remove prevColor
            int removePrev = neededTime[prevIndex] + recursiveHelper(colors, neededTime, index+1, index);
            // OR remove currentColor
            int removeCurrent = neededTime[index] + recursiveHelper(colors, neededTime, index+1, prevIndex);
            return Math.min(removePrev, removeCurrent);
        }
        return recursiveHelper(colors, neededTime, index+1, index);
    }
}