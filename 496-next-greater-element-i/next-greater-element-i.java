class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> ansMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<nums2.length;i++) {
            while(!stack.isEmpty() && stack.peek()<nums2[i]) {
                ansMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) ansMap.put(stack.pop(), -1);
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) ans[i] = ansMap.get(nums1[i]);
        return ans;
    }
}