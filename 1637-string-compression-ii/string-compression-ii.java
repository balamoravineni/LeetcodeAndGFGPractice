class Solution {
    int n;
    char[] arr;
    int[][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
        arr = s.toCharArray();
        dp = new int[n][k+1];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        return recursive(0,k);
    }

    int recursive(int index, int k) {
        if(k<0) return n;
        if(k>=n-index) return 0;
        if(dp[index][k]!=-1) return dp[index][k];
        // delete current char
        int ans = recursive(index+1, k-1);
        // don't delete current char
        int len=0, same=0, diff=0;
        for(int j=index;j<n && diff<=k;j++) {
            if (arr[j]==arr[index]) {
                same++;
                if(same <= 2 || same == 10 || same == 100) len++;
            } 
            else {
                diff++;
            }
            ans = Math.min(ans, len + recursive(j + 1, k - diff));
        }
        return dp[index][k] = ans;
    }
}