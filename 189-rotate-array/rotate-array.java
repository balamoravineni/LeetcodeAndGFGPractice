class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = usingExtraSpace(nums, k);
        for(int i=0;i<nums.length;i++) {
            nums[i] = ans[i];
        }
        return;
    }

    int[] usingExtraSpace(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            ans[(i+k)%n] = nums[i];
        }
        return ans;
    }
}