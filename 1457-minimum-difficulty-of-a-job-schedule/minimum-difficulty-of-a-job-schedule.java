class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int[][] dp = new int[d+1][jobDifficulty.length];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        int ans = recursiveHelper(jobDifficulty, d, 0, dp);
        return ans!=Integer.MAX_VALUE?ans:-1;
    }

    int recursiveHelper(int[] jobDifficulty, int d, int index, int[][] dp) {
        if(index==jobDifficulty.length && d==0) return 0;
        else if(index==jobDifficulty.length || d==0) return Integer.MAX_VALUE;
        if(dp[d][index]!=-1) return dp[d][index];
        int hDiff = -1;
        int ans = Integer.MAX_VALUE;
        for(int j=index;j<jobDifficulty.length;j++) {
            hDiff = Math.max(hDiff, jobDifficulty[j]);
            int next = recursiveHelper(jobDifficulty, d-1, j+1, dp);
            if(next!=Integer.MAX_VALUE) ans = Math.min(ans, hDiff + next);
        }
        return dp[d][index] = ans;
    }
}