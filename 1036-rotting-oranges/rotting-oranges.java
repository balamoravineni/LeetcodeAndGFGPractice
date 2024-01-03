class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair<Integer,Integer>> init = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==2) init.add(new Pair(i,j));
                else if(grid[i][j]==1) count++;
            }
        }
        return bfs(grid,n,m,init,count);
    }

    int[] x = {0, 1, 0, -1};
    int[] y = {1, 0, -1, 0};

    int bfs(int[][] grid, int n, int m, Queue<Pair<Integer,Integer>> queue, int count) {
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                Pair<Integer,Integer> curr = queue.remove();
                for(int d=0;d<4;d++) {
                    int nextX = curr.getKey() + x[d];
                    int nextY = curr.getValue() + y[d];
                    if(nextX>=0 && nextX<n && nextY>=0 && nextY<m &&
                        grid[nextX][nextY]==1) {
                        grid[nextX][nextY] = 2;
                        count--;
                        queue.add(new Pair(nextX, nextY));
                    }
                }
            }
            level++;
        }
        return count!=0?-1:level==-1?0:level;
    }
}