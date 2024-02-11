class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Integer[][][] dp = new Integer[rows][cols][cols];
        return recursive(rows, cols, grid, 0, 0, cols-1, dp);
    }

    int[] c = {-1, 0, 1};

    int recursive(int rows, int cols, int[][] grid, int r, int c1, int c2, Integer[][][] dp) {
        if(r==rows) return 0;
        if(dp[r][c1][c2]!=null) return dp[r][c1][c2];
        int ans = 0;
        if(c1==c2) ans += grid[r][c1];
        else ans += grid[r][c1] + grid[r][c2];
        int nextAns = 0;
        for(int i=0;i<3;i++) {
            int nextC1 = c1 + c[i];
            if(nextC1>=0 && nextC1<cols) {
                for(int j=0;j<3;j++) {
                    int nextC2 = c2 + c[j];
                    if(nextC2>=0 && nextC2<cols) {
                        nextAns = Math.max(nextAns, recursive(rows, cols, grid, r+1, nextC1, nextC2, dp));
                    }
                }
            }
        }
        return dp[r][c1][c2] = ans + nextAns;
    }
}