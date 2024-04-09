class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        boolean br = false;
        while(true) {
            for(int i=0;i<tickets.length;i++) {
                if(tickets[i]!=0) {
                    tickets[i]--;
                    ans++;
                }
                if(i==k && tickets[k]==0) {
                    br = true;
                    break;
                }
            }
            if(br) break;
        }
        return ans;
    }
}