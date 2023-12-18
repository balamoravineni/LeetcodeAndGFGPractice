class Solution {
    public int maxProductDifference(int[] nums) {
        // Arrays.sort(nums);
        // return (nums[nums.length-1]*nums[nums.length-2]) - (nums[0]*nums[1]);
        int largest = Integer.MIN_VALUE;
        int lI = -1;
        int smallest = Integer.MAX_VALUE;
        int sI = -1;
        for(int i=0; i<nums.length; i++) {
            if(largest<nums[i]) {
                largest = nums[i];
                lI = i;
            }
            if(smallest>nums[i]) {
                smallest = nums[i];
                sI = i;
            }
        }
        int second_largest = Integer.MIN_VALUE;
        int second_smallest = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(i!=lI && second_largest<=nums[i]) {
                second_largest = nums[i];
            }
            if(i!=sI && second_smallest>=nums[i]) {
                second_smallest = nums[i];
            }
        }
        System.out.println(largest + " " + second_largest + " " + smallest + " " + second_smallest);
        return (largest*second_largest) - (smallest*second_smallest);
    }
}