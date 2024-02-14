class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            parent[i] = i;
        }
        int max = 1;
        int last = 0;
        // tabulation of dp array
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]%nums[j]==0 && dp[j]>=dp[i]) {
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                }
            }
            if(dp[i]>max) {
                max = dp[i];
                last = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(parent[last]!=last) {
            ans.add(nums[last]);
            last = parent[last];
        }
        ans.add(nums[last]);
        return ans;

    }
}