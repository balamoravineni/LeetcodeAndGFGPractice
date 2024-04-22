class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int temp: nums) {
            if(temp<first) {
                first = temp;
            }
            else if(temp>first && temp<second) {
                second = temp;
            }
            else if(temp>second){
                // third value
                return true;
            }
        }
        return false;
    }
}