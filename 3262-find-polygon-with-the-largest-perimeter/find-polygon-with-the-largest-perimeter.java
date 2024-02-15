class Solution {
    public long largestPerimeter(int[] nums) {
        // return usingDP(nums);
        return optimised(nums);
    }

    long optimised(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int sides = nums.length;
        for(int temp: nums) sum += temp;
        for(int i=nums.length-1;i>=0;i--) {
            long otherSum = sum - nums[i];
            if(otherSum<=nums[i]) {
                sum -= nums[i];
                sides--;
            }
            else {
                return sum;
            }
        }
        if(sides<3) return -1;
        return sum;
    }

    long usingDP(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        String key = "0$";
        return recursive(nums, 0, new ArrayList<>(), dp, key);
    }

    int recursive(int[] nums, int index, List<Integer> subset, Map<String, Integer> dp, String key) {
        if(index>=nums.length) {
            if(subset.size()<3) return -1;
            int sum = 0;
            for(int temp:subset) sum+=temp;
            for(int temp:subset) {
                int otherSides = sum - temp;
                if(otherSides<=temp) return -1;
            }
            return sum;
        }
        if(dp.containsKey(key)) return dp.get(key);
        int notConsider = recursive(nums, index+1, subset, dp, key);
        subset.add(nums[index]);
        key += index + "$";
        int consider = recursive(nums, index+1, subset, dp, key);
        subset.remove(subset.size()-1);
        int ans = Math.max(notConsider, consider);
        dp.put(key, ans);
        return ans;
    }
}