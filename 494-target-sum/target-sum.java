class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> dp = new HashMap<>();
        return recursive(nums,target,0,dp);
    }

    int recursive(int[] nums, int target, int i,Map<String,Integer> dp) {
        if(i==nums.length) {
            if(target==0) return 1;
            return 0;
        }
        String str = i + "$" + target;
        if(dp.containsKey(str)) return dp.get(str);
        int plus = recursive(nums, target-nums[i], i+1, dp);
        int minus = recursive(nums, target+nums[i], i+1, dp);
        dp.put(str, plus+minus);
        return plus+minus;
    }
}