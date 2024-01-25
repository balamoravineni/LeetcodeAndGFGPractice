class Solution {
    public int rob(int[] nums) {
        // Integer[][] dp = new Integer[nums.length][2];
        // return helper(nums, 0, 0, dp); // firstRobbed has to be 0 to handle [1] test case

        int n = nums.length;
        if(n==1) return nums[0];
        Integer[] dp = new Integer[n];
        int ans = helper(nums, n-1, 0, dp); // leave last element
        dp = new Integer[n];
        ans = Math.max(ans, helper(nums, n, 1, dp)); // leave first element
        return ans;
        
    }

    int helper(int[] nums, int n, int index, Integer[] dp) {
        if(index>=n) return 0;
        if(dp[index]!=null) return dp[index];
        int rob = nums[index] + helper(nums, n, index+2, dp);
        int notRob = helper(nums, n, index+1, dp);
        return dp[index] = Math.max(rob, notRob);
    }

    // int helper(int[] nums, int index, int firstRobbed, Integer[][] dp) {
    //     if(index>=nums.length) return 0;
    //     if(index==nums.length-1 && firstRobbed==0) return nums[index];
    //     if(index==nums.length-1 && firstRobbed==1) return 0;
    //     if(dp[index][firstRobbed]!=null) return dp[index][firstRobbed];
    //     int rob = nums[index] + helper(nums, index+2, index==0?1:firstRobbed, dp);
    //     int notRob = helper(nums, index+1, index==0?0:firstRobbed, dp);
    //     return dp[index][firstRobbed] = Math.max(rob, notRob);
    // }
}