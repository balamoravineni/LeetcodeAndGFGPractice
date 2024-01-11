class Solution {
    public int search(int[] nums, int target) {
        // int ans = Arrays.binarySearch(nums, target);
        // return ans<0?-1:ans;
        // return iterative(nums, target);
        return recursive(nums, target, 0, nums.length-1);
    }

    int recursive(int[] nums, int target, int lo, int hi) {
        if(lo>hi) return -1;
        int mid = lo + (hi-lo)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return recursive(nums, target, lo, mid-1);
        return recursive(nums, target, mid+1, hi);
    }

    int iterative(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        return -1;
    }
}