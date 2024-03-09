class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length) {
            System.out.println("searching for"+ nums1[i]);
            int index = Arrays.binarySearch(nums2, j, nums2.length, nums1[i++]);
            if(index>=0) return nums2[index];
            else {
                j = -(index+1);
                if(j==nums2.length || nums2[j]>nums1[nums1.length-1]) break;
            }
        }
        return -1;
    }

}