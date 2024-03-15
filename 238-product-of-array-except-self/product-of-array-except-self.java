class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            ans[i] = ans[i-1]*nums[i];
        }
        int prev = nums[nums.length-1];
        ans[nums.length-1] = ans[nums.length-2];
        for(int i=nums.length-2;i>=0;i--) {
            if(i!=0) ans[i] = ans[i-1]*prev;
            else ans[i] = prev;
            prev = prev*nums[i];
        }
        return ans;
    }
}