class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        // return helper(text1, text2, text1.length()-1, text2.length()-1, dp);
        return iterative(text1, text2, dp);
    }

    int iterative(String text1, String text2, int[][] dp) {
        int n = text1.length();
        int m = text2.length();
        // for(int i=0;i<n;i++) dp[i][0] = 0;
        // for(int i=0;i<m;i++) dp[0][i] = 0;
        for(int[] temp: dp) Arrays.fill(temp, 0);
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    int poss1 = dp[i-1][j];
                    int poss2 = dp[i][j-1];
                    dp[i][j] = Math.max(poss1, poss2);
                }
            }
        }
        return dp[n][m];
    }

    int helper(String text1, String text2, int i1, int i2, int[][] dp) {
        if(i1<0 || i2<0) return 0;
        if(text1.charAt(i1)==text2.charAt(i2)) return 1 + helper(text1, text2, i1-1, i2-1, dp);
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int poss1 = helper(text1, text2, i1-1, i2, dp);
        int poss2 = helper(text1, text2, i1, i2-1, dp);
        return dp[i1][i2] = Math.max(poss1, poss2);
    }

}