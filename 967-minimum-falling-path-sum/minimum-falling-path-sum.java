class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];
        // return pathSumIterative(matrix, n, dp);
        // for(int[] temp:dp) Arrays.fill(temp, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) {
            ans = Math.min(ans, pathSum(matrix, n, 0, i, dp));
        }
        return ans;
    }

    int pathSum(int[][] matrix, int n, int row, int col, Integer[][] dp) {
        if(row==n-1) return matrix[row][col];
        if(dp[row][col]!=null) return dp[row][col];
        int ans = matrix[row][col] + pathSum(matrix,n,row+1, col, dp);
        if(col-1>=0) ans = Math.min(ans, matrix[row][col] + pathSum(matrix,n,row+1, col-1, dp));
        if(col+1<n) ans = Math.min(ans, matrix[row][col] + pathSum(matrix,n,row+1, col+1, dp));
        return dp[row][col] = ans;
    }

    int pathSumIterative(int[][] matrix, int n, int[][] dp) {
        for(int i=0;i<n;i++) dp[0][i] = matrix[0][i];
        for(int i=1;i<n;i++) {
            for(int j=0;j<n;j++) {
                int ans = dp[i-1][j] + matrix[i][j];
                if(j-1>=0) ans = Math.min(ans, dp[i-1][j-1] + matrix[i][j]);
                if(j+1<n) ans = Math.min(ans, dp[i-1][j+1] + matrix[i][j]);
                dp[i][j] = ans;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) ans = Math.min(ans, dp[n-1][i]);
        return ans;
    }
}