class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                long diff = (long)nums[j]-(long)nums[i];
                Map<String, Integer> dp = new HashMap<>();
                ans += recursiveHelper(nums,j+1,diff,2,dp);
            }
        }
        return ans;
    }

    int recursiveHelper(int[] nums, int index, long diff, int count, Map<String, Integer> dp) {
        // if(index==nums.length && count>=3) return 1;
        // else if(index==nums.length) return 0;
        String current = index + "-" + diff;
        if(dp.containsKey(current)) return dp.get(current);
        int ans = 0;
        if(count>=3) ans++;
        for(int i=index;i<nums.length;i++) {
            if((long)nums[i]-(long)nums[index-1]==diff) ans += recursiveHelper(nums, i+1, diff, count+1, dp);
        }
        dp.put(current, ans);
        return ans;
    }


}