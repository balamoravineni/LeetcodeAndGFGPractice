class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long flowersReq = (long)m*k;
        // System.out.println(flowersReq + " " + bloomDay.length);
        if(flowersReq>bloomDay.length) return -1;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        for(int temp: bloomDay) {
            lo = Math.min(lo, temp);
            hi = Math.max(hi, temp);
        }
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            int tempM = m;
            for(int i=0;i<bloomDay.length;i++) {
                if(bloomDay[i]<=mid) {
                    int tempK = k-1;
                    while(tempK>0 && (i+1)<bloomDay.length && bloomDay[++i]<=mid) tempK--;
                    if(tempK==0) tempM--;
                }
            }
            if(tempM>0) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return lo;
    }
}