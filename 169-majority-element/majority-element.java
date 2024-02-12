class Solution {
    public int majorityElement(int[] nums) {
        Integer ans = null;
        int count = 0;
        for(int temp: nums) {
            if(count==0) ans = temp;
            if(ans==temp) count++;
            else count--;
        }
        return ans;
    }
}