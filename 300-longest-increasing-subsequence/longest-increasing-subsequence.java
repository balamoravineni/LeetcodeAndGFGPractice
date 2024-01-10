class Solution {
    public int lengthOfLIS(int[] nums) {
        // return usingDP(nums);
        return usingBinarySearch(nums);
    }

    int usingBinarySearch(int[] nums) {
        int ans = 0;
        int[] reqSeq = new int[nums.length];
        for(int temp: nums) {
            int index = Arrays.binarySearch(reqSeq, 0, ans, temp);
            // if index is negative, the abs value-1 is the actual index where the temp can be inserted to maintain sorted arr
            if(index<0) {
                reqSeq[-(index+1)] = temp;
                if(ans==-(index+1)) ans++;
            }
        }
        return ans;
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