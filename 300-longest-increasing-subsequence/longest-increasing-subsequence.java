class Solution {
    public int lengthOfLIS(int[] nums) {
        return usingDP(nums);
        // return usingSorting(nums); // giving result as wrong answer for now
    }
 
    int usingDP(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        int ans = recursiveHelper(nums,0,-1,dp);
        return ans;
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

        int usingSorting(int[] nums) {
        List<Pair<Integer,Integer>> input = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            input.add(new Pair(nums[i],i));
        }
        Collections.sort(input, (p1,p2) -> p1.getKey()==p2.getKey()?p1.getValue()-p2.getValue():p1.getKey()-p2.getKey());
        int prevKey = Integer.MIN_VALUE;
        int prevIndex = -1;
        int i=0, ans = 0;
        while(i<input.size()) {
            int tempKey = input.get(i).getKey();
            int tempIndex = -1;
            while(i<input.size() && input.get(i).getKey()==tempKey) {
                if(input.get(i).getValue()>prevIndex) {
                    tempIndex = input.get(i).getValue();
                    ans++;
                    break;
                }
                i++;
            }
            while(i<input.size() && input.get(i).getKey()==tempKey) i++;
            if(tempIndex!=-1) prevIndex = tempIndex;
            prevKey = tempKey;
        }
        return ans;
    }
}