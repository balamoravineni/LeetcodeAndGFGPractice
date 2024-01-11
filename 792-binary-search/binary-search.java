class Solution {
    public int search(int[] nums, int target) {
        int ans = Arrays.binarySearch(nums, target);
        return ans<0?-1:ans;
    }
}