class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return getCommon(nums2, nums1);
        }
        for (int num : nums1) {
            if (Arrays.binarySearch(nums2, num)>=0) {
                return num;
            }
        }
        return -1;
    }

}