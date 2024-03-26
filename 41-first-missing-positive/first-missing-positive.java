class Solution {
    public int firstMissingPositive(int[] nums) {
        return usingSorting(nums);
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