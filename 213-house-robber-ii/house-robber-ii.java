class Solution {
    public int rob(int[] nums) {
        Integer[][] dp = new Integer[nums.length][2];
        return helper(nums, 0, 0, dp); // firstRobbed has to be 0 to handle [1] test case
    }

    int helper(int[] nums, int index, int firstRobbed, Integer[][] dp) {
        if(index>=nums.length) return 0;
        if(index==nums.length-1 && firstRobbed==0) return nums[index];
        if(index==nums.length-1 && firstRobbed==1) return 0;
        if(dp[index][firstRobbed]!=null) return dp[index][firstRobbed];
        int rob = nums[index] + helper(nums, index+2, index==0?1:firstRobbed, dp);
        int notRob = helper(nums, index+1, index==0?0:firstRobbed, dp);
        return dp[index][firstRobbed] = Math.max(rob, notRob);
    }
}