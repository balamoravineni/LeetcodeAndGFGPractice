class Solution {
    public int maxProfit(int[] prices) {
        int ans = -1;
        int sum = 0;
        for(int i=1;i<prices.length;i++) {
            int diff = prices[i]-prices[i-1];
            if(sum<0 && diff>0) {
                sum = diff;
            }
            else {
                sum += diff;
            }
            ans = Math.max(ans, sum);
        }
        return ans<0?0:ans;
    }
}