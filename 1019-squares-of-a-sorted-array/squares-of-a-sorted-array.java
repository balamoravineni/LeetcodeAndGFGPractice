class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int k = nums.length-1;
        while(i<=j) {
            int iSquare = nums[i]*nums[i];
            int jSquare = nums[j]*nums[j];
            if(iSquare>=jSquare) {
                ans[k--] = iSquare;
                i++;
            }
            else {
                ans[k--] = jSquare;
                j--;
            }
        }
        return ans;
    }
}