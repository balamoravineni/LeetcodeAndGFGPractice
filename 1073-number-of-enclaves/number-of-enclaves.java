
class Solution {

    int[] x = {1, 0, -1, 0};
    int[] y = {0, 1, 0, -1};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 || i==m-1 || j==0 || j==n-1) {
                    if(grid[i][j]==1) dfs(m, n, grid, i, j);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) ans++;
            }
        }
        return ans;
    }

    void dfs(int m, int n, int[][] grid, int i, int j) {
        grid[i][j] = 0;
        for(int d=0;d<4;d++) {
            int nextX = i + x[d];
            int nextY = j + y[d];
            if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && grid[nextX][nextY]==1) {
                dfs(m, n, grid, nextX, nextY);
            }
        }
    }
}