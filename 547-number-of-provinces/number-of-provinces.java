class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(visited[i]!=1) {
                ans++;
                dfs(i,isConnected,n,visited);
            }
        }
        return ans;
    }

    void dfs(int index, int[][] adj, int n, int[] visited) {
        visited[index] = 1;
        for(int i=0;i<n;i++) {
            if(i!=n && visited[i]!=1 && adj[index][i]==1) {
                dfs(i,adj,n,visited);
            }
        }
    }
}