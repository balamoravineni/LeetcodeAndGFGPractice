class Solution {
    public int firstMissingPositive(int[] nums) {
        // return usingSorting(nums);
        return optimised(nums);
    }

    int optimised(int[] nums) {
        int[] arr = new int[nums.length];
        for(int temp: nums) {
            if(temp>0) {
                if(temp>nums.length) continue;
                else arr[temp-1] = temp;
            } 
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=i+1) return i+1;
        }
        return arr.length+1;
    }

    int usingSorting(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length && nums[i]<=0) i++;
        int current=1;
        for(;i<nums.length;) {
            if(current==nums[i]) while(i<nums.length && current==nums[i]) i++;
            else return current;
            current++;
        }
        // System.out.println("here");
        return nums[nums.length-1]>0?nums[nums.length-1]+1:1;
    }
}