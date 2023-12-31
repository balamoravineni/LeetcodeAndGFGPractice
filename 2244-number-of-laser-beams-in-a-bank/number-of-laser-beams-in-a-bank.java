class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int ans = 0;
        int num = countDevices(bank[0]);
        for(int i=1;i<m;i++) {
            int temp = countDevices(bank[i]);
            ans += num*temp;
            if(temp!=0) num = temp;
        }
        return ans;
    }

    int countDevices(String str) {
        int ans = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='1') ans++;
        }
        return ans;
    }
}