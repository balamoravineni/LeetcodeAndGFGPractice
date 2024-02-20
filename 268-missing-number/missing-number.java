class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            ans = ans^nums[i]^i;
        }
        ans = ans^nums.length;
        return ans;
    }
}