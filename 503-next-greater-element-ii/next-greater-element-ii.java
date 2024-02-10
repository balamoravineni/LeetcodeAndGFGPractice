class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]) {
                ans[stack.pop()] = nums[i];
            }
        }
        while(!stack.isEmpty()) ans[stack.pop()] = -1;
        return ans;
    }
}