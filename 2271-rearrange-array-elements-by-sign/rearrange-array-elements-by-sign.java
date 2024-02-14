class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l=0, r=n/2;
        for(int temp: nums) {
            if(temp>0) ans[l++] = temp;
            else ans[r++] = temp;
        }
        l=0; r=n/2;
        for(int i=0;i<n;) {
            nums[i++] = ans[l++];
            nums[i++] = ans[r++];
        }
        return nums;
    }
}