class Solution {
    public int minOperations(int[] nums) {
        // return sortingAndIteration(nums);
        return usingMapAndCounting(nums);
    }

    int usingMapAndCounting(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int temp: nums) {
            if(freq.get(temp)==null) freq.put(temp, 1);
            else freq.put(temp, freq.get(temp)+1);
        }
        int ans = 0;
        for(int key: freq.keySet()) {
            if(freq.get(key)==1) return -1;
            else {
                // System.out.println(key + " " + freq.get(key) + "; " + Math.ceil((double)freq.get(key)/3));
                ans += Math.ceil((double)freq.get(key)/3);
            }
        }
        return ans;
    }

    int sortingAndIteration(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int ans = 0;
        while(i+1<nums.length) {
            if(nums[i]!=nums[i+1]) return -1;
            int endI = i+1;
            while(endI+1<nums.length && nums[endI]==nums[endI+1]) endI++;
            int target = (endI-i+1);
            boolean found = false;
            for(int j=0;j*2<=target;j++) {
                if((target-j*2)%3==0) {
                    ans += j;
                    ans += (target-j*2)/3;
                    found = true;
                    break;
                }
            }
            if(found) i = endI+1;
            else return -1;
        }
        if(i==nums.length) return ans;
        return -1;
    }
}