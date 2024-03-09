class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        return usingTwoPointers(nums1, nums2);
        // return usingBinarySearch(nums1, nums2);
    }

    int usingTwoPointers(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]==nums2[j]) return nums1[i];
            else if(nums1[i]<nums2[j]) i++;
            else j++;
        }
        return -1;
    }

    int usingBinarySearch(int[] nums1, int[] nums2) {
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