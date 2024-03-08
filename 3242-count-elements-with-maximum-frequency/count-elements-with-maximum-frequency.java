class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for(int temp:nums) {
            freq[temp]++;
            max = Math.max(max, freq[temp]);
        }
        int count = 0;
        for(int temp:freq) {
            if(temp==max) count++;
        }
        return count*max;
    }
}