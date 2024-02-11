class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1;
        for(int temp: piles) hi = Math.max(hi, temp);
        int ans = 0;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            int timeTaken = timeToEatBananas(piles, mid);
            if(timeTaken>h) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return lo;
    }

    int timeToEatBananas(int[] piles, int speed) {
        int ans = 0;
        for(int i=0;i<piles.length;i++) {
            ans += Math.ceil((double)piles[i]/speed);
        }
        return ans;
    }
}