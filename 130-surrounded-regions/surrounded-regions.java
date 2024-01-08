class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0|| i==n-1 || j==0 || j==m-1) {
                    if(board[i][j]=='O') dfs(n,m,board,i,j,visited);
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]=='O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    int[] x = {1, 0, -1, 0};
    int[] y = {0, 1, 0, -1};

    void dfs(int n, int m, char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for(int d=0;d<4;d++) {
            int newI = i+x[d];
            int newJ = j+y[d];
            if(newI>=0 && newI<n && newJ>=0 && newJ<m && board[i][j]=='O' && !visited[newI][newJ]) {
                dfs(n,m,board, newI, newJ, visited);
            }
        }
    } 
}