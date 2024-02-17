class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        for(int temp: nums) {
            lo = Math.min(lo, temp);
            hi = Math.max(hi, temp);
        }
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            int ans = 0;
            for(int temp: nums) {
                ans += Math.ceil((double)temp/mid);
            }
            if(ans>threshold) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return lo;
    }
}