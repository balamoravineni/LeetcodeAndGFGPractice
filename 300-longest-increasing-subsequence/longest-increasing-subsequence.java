class Solution {
    public int lengthOfLIS(int[] nums) {
        return usingDP(nums);
        // return usingBinarySearchAndDP(nums); // need to learn
    }
 
    int usingDP(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        int ans = recursiveHelper(nums,0,-1,dp);
        return ans;
    }

    int recursiveHelper(int[] nums, int index, int prevIndex, int[][] dp) {
        if(index==nums.length) return 0;
        if(dp[index][prevIndex+1]!=-1) return dp[index][prevIndex+1];
        int take = Integer.MIN_VALUE;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]) {
            take = 1 + recursiveHelper(nums, index+1, index, dp);
        }
        int notTake = 0 + recursiveHelper(nums, index+1, prevIndex, dp);
        return dp[index][prevIndex+1] = Math.max(take, notTake);
    }
}