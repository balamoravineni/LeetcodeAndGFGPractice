class Solution {

    int[] x = { 1, 0, -1, 0};
    int[] y = { 0, 1, 0, -1};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j]==0) {
                    visited[i][j] = true;
                    queue.add(new Pair(i,j));
                }
            }
        }
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                Pair<Integer,Integer> curr = queue.remove();
                int i = curr.getKey();
                int j = curr.getValue();
                ans[i][j] = level;
                for(int d=0;d<4;d++) {
                    int newI = i + x[d];
                    int newJ = j + y[d];
                    if(newI>=0 && newI<n && newJ>=0 && newJ<m && !visited[newI][newJ]) {
                        visited[newI][newJ] = true;
                        queue.add(new Pair(newI, newJ));
                    }
                }
            }
            level++;
        }

        return ans;
    }
}