class Solution {
    int[] x = {1, 0, -1, 0};
    int[] y = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if(old==color) return image;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(sr,sc));
        while(!queue.isEmpty()) {
            Pair<Integer,Integer> curr = queue.remove();
            int currX = curr.getKey();
            int currY = curr.getValue();
            image[currX][currY] = color;
            for(int d=0;d<4;d++) {
                int nextX = currX + x[d];
                int nextY = currY + y[d];
                if(nextX>=0 && nextX<image.length && nextY>=0 && nextY<image[0].length && image[nextX][nextY]==old) {
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
        return image;
    }
}