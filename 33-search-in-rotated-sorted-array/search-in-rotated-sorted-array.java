class Solution {
    public int search(int[] nums, int target) {
        // return usingPivotPoint(nums, target);
        return usingBSDirectly(nums, target, 0, nums.length-1);
    }

    int usingBSDirectly(int[] nums, int target, int lo, int hi) {
        if(lo>hi) return -1;
        int mid = (lo+hi)/2;
        if(nums[mid]==target) return mid;
        else if(nums[lo]<nums[hi]) {
            if(nums[mid]<target) {
                return usingBSDirectly(nums, target, mid+1, hi);
            }
            else {
                return usingBSDirectly(nums, target, lo, mid);
            }
        }
        else if(nums[lo]<=nums[mid]) {
            if(nums[lo]<=target && target<=nums[mid]) {
                return usingBSDirectly(nums, target, lo, mid);
            }
            else {
                return usingBSDirectly(nums, target, mid+1, hi);
            }
        }
        else if(nums[mid]<=nums[hi]) {
            if(nums[mid]<=target && target<=nums[hi]) {
                return usingBSDirectly(nums, target, mid, hi);
            }
            else {
                return usingBSDirectly(nums, target, lo, mid-1);
            }
        }
        return -1;
    }

    int usingPivotPoint(int[] nums, int target) {
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