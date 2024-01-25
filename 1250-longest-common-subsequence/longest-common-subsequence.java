class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        return helper(text1, text2, text1.length()-1, text2.length()-1, dp);
    }

    int helper(String text1, String text2, int i1, int i2, int[][] dp) {
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(text1.charAt(i1)==text2.charAt(i2)) return 1 + helper(text1, text2, i1-1, i2-1, dp);
        int poss1 = helper(text1, text2, i1-1, i2, dp);
        int poss2 = helper(text1, text2, i1, i2-1, dp);
        return dp[i1][i2] = Math.max(poss1, poss2);
    }

}