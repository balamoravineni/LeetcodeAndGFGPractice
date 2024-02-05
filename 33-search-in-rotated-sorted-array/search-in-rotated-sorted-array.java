class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1) {
            return nums[0]==target?0:-1;
        }
        int pivot = pivotPoint(nums, 0, nums.length-1);
        // System.out.println("pivot: " + pivot);
        int ans = -1;
        if(pivot==-1) {
            ans = Arrays.binarySearch(nums, target);
        }
        else if(target<=nums[pivot] && target>=nums[0]) {
            ans = Arrays.binarySearch(nums, 0, pivot+1, target);
        }
        else {
            ans = Arrays.binarySearch(nums, pivot+1, nums.length, target);
        }
        return ans<0?-1:ans;
    }

    int pivotPoint(int[] nums, int lo, int hi) {
        if(lo>=hi || nums[lo]<nums[hi]) {
            // System.out.println(lo + " " + hi + ": -1");
            return -1;
        }
        int mid = lo + (hi-lo)/2;
        int left = pivotPoint(nums, lo, mid);
        int right = pivotPoint(nums, mid+1, hi);
        // System.out.println(lo + " " + hi + ": " + left + " -> " + right);
        if(left==-1 && right==-1) return mid;
        else if(left==-1) return right;
        return left;
    }
}