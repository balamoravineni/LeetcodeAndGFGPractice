class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(visited[i]==false) {
                ans++;
                visited[i] = true;
                dfsHelper(isConnected, n, i, visited);
            }
        }
        return ans;
    }

    void dfsHelper(int[][] isConnected, int n, int city, boolean[] visited) {
        for(int i=0;i<n;i++) {
            if(i!=city && isConnected[city][i]==1 && !visited[i]) {
                visited[i] = true;
                dfsHelper(isConnected, n, i, visited);
            }
        }
    }
}