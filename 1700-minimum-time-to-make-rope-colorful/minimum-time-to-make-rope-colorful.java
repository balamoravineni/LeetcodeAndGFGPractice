class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans = 0;
        int i=0;
        while(i<n) {
            int j=i+1;
            int removeAll=neededTime[i];
            int maxTime=neededTime[i];
            while(j<n && colors.charAt(i)==colors.charAt(j)) {
                removeAll+=neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            ans += removeAll-maxTime;
            i=j;
        }
        return ans;
    }
}