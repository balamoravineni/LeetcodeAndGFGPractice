class Solution {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int freq = len/4;
        int current = arr[0];
        int currentFreq = 1;
        for(int i=1;i<len;i++) {
            if(currentFreq>freq) break;
            if(arr[i]==current) currentFreq++;
            else {
                current = arr[i];
                currentFreq = 1;
            }
        }
        return current;
    }
}