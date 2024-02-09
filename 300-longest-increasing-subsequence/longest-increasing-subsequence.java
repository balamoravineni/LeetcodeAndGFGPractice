class Solution {
    public int lengthOfLIS(int[] nums) {
        return usingDP(nums);
        // return usingBinarySearch(nums);
    }

    int usingBinarySearch(int[] nums) {
        int ans = 0;
        int[] reqSeq = new int[nums.length];
        for(int temp: nums) {
            int index = Arrays.binarySearch(reqSeq, 0, ans, temp);
            // if index is negative, the abs value-1 is the actual index where the temp can be inserted to maintain sorted arr
            if(index<0) {
                reqSeq[-(index+1)] = temp;
                if(ans==-(index+1)) ans++;
            }
        }
        return ans;
    }
 
    int usingDP(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length];
        // for(int[] temp: dp) Arrays.fill(temp, -1);
        // int ans = recursiveHelper(nums,0,-1,dp);

        // int ans = iterativeHelper(nums);
        // int ans = spaceOptimised(nums);
        // int ans = tabulation(nums);
        int ans = tabulationPrintLIS(nums);
        return ans;
    }

    int tabulationPrintLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        int lastIndex = 0;
        for(int i=0;i<n;i++) parent[i] = i;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    if(dp[j]+1>dp[i]) {
                        dp[i] = dp[j]+1;
                        parent[i] = j;
                    }
                }
            }
            if(dp[i]>ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> seq = new LinkedList<>();
        while(true) {
            seq.add(0, nums[lastIndex]);
            if(dp[lastIndex]==1) break;
            else lastIndex = parent[lastIndex];
        }
        System.out.println(seq);
        return ans;
    }

    int tabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int ans = 1;
        for(int temp: dp) ans = Math.max(ans, temp);
        return ans;
    }

    int spaceOptimised(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        // base case -> 0 ; not required to write specifically
        for(int i=n-1;i>=0;i--) {
            for(int j=i-1;j>=-1;j--) {
                int take = Integer.MIN_VALUE;
                if(j==-1 || nums[i]>nums[j]) {
                    take = 1 + next[i+1];
                }
                int notTake = next[j+1];
                curr[j+1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }

    int iterativeHelper(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        // base case -> 0 ; not required to write specifically
        for(int i=n-1;i>=0;i--) {
            for(int j=i-1;j>=-1;j--) {
                int take = Integer.MIN_VALUE;
                if(j==-1 || nums[i]>nums[j]) {
                    take = 1 + dp[i+1][i+1];
                }
                int notTake = dp[i+1][j+1];
                dp[i][j+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    int recursiveHelper(int[] nums, int index, int prevIndex, int[][] dp) {
        if(index==nums.length) return 0;
        if(dp[index][prevIndex+1]!=-1) return dp[index][prevIndex+1];
        int take = Integer.MIN_VALUE;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]) {
            take = 1 + recursiveHelper(nums, index+1, index, dp);
        }
        int notTake = 0 + recursiveHelper(nums, index+1, prevIndex, dp);
        return dp[index][prevIndex+1] = Math.max(take, notTake);
    }
}