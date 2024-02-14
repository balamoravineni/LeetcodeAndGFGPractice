class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos=0, neg=1;
        for(int temp: nums) {
            if(temp>0) {
                ans[pos] = temp;
                pos += 2;
            }
            else {
                ans[neg] = temp;
                neg += 2;
            }
        }
        return ans;
    }
}