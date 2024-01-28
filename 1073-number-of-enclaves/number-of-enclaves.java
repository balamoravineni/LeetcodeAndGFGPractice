
class Pair {
    int x, y;
    Pair(int a, int b) {
        x = a;
        y = b;
    }
}

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
                // if(grid[i][j]==1) count++;
            }
        }

        // while(!q.isEmpty()) {
        //     Pair curr = q.remove();
        //     if(grid[curr.x][curr.y]==1) {
        //         grid[curr.x][curr.y] = 0;
        //         count--;
        //     }
        //     for(int d=0;d<4;d++) {
        //         int nextX = curr.x + x[d];
        //         int nextY = curr.y + y[d];
        //         if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && grid[nextX][nextY]==1) {
        //             q.add(new Pair(nextX, nextY));
        //         }
        //     }
        // }

        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) ans++;
            }
        }
        return ans;
        // return count;
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