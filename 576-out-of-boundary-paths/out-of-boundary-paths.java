class Solution {

    int[] x = {1, 0, -1, 0};
    int[] y = {0, 1, 0, -1};
    int M = (int)1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return dfs(m,n,maxMove,startRow, startColumn, dp);
    }

    int dfs(int m, int n, int maxMove, int i, int j, Integer[][][] dp) {
        if(maxMove==0) return 0;
        if(dp[i][j][maxMove]!=null) return dp[i][j][maxMove];
        int ans = 0;
        for(int d=0;d<4;d++) {
            int nextI = i + x[d];
            int nextJ = j + y[d];
            if(nextI>=0 && nextI<m && nextJ>=0 && nextJ<n) {
                ans = ans%M + dfs(m,n,maxMove-1,nextI, nextJ, dp)%M;
            }
            else {
                ans = ans%M + 1;
            }
        }
        return dp[i][j][maxMove] = ans%M;
    }
}