class Solution {
    public int maxSubArray(int[] nums) {
        // return bruteForce(nums);

        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if(sum<0) sum=0;
        }
        return maxSum;
    }

    int bruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum+= nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}