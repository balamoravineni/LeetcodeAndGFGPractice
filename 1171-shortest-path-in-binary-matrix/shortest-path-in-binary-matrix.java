class Tuple {
    int x;
    int y;
    int len;
    Tuple(int a, int b, int c) {
        x = a;
        y = b;
        len = c;
    }
}

class Solution {

    int[] x = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] y = {0, -1, 0, 1, -1, 1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int[][] len = new int[n][n];
        for(int[] temp: len) Arrays.fill(temp, Integer.MAX_VALUE);
        Queue<Tuple> queue = new PriorityQueue<>((t1, t2) -> t1.len-t2.len);
        queue.offer(new Tuple(0,0,1));
        while(!queue.isEmpty()) {
            Tuple curr = queue.poll();
            if(curr.x==n-1 && curr.y==n-1) return curr.len;
            for(int d=0;d<8;d++) {
                int nextX = curr.x + x[d];
                int nextY = curr.y + y[d];
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<n && grid[nextX][nextY]==0 &&
                    curr.len+1<len[nextX][nextY]) {
                    queue.offer(new Tuple(nextX, nextY, curr.len+1));
                    len[nextX][nextY] = curr.len+1;
                }
            }
        }
        return -1;
    }
}