class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        // limiting search to 1 till n-2, to avoid handling above edge cases
        int start = 1, end = n-2;
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) return nums[mid];
            if(mid%2==1) {
                if(nums[mid]==nums[mid-1]) start = mid+1;
                else end = mid-1;
            }
            else {
                if(nums[mid]==nums[mid-1]) end = mid-1;
                else start = mid+1;
            }
        }
        // return nums[start];
        return -1;
    }
}