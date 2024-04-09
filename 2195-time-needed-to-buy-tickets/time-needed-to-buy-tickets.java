class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // return bruteForce(tickets, k);
        return optimised(tickets, k);
    }

    int optimised(int[] tickets, int k) {
        int passes = tickets[k];
        int ans = 0;
        for(int i=0;i<tickets.length;i++) {
            if(i<=k) ans += Math.min(tickets[i], passes);
            else ans += Math.min(tickets[i], passes-1);
        }
        return ans;
    }

    int bruteForce(int[] tickets, int k) {
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