class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for(int i=0;i<points.length;i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int ans = 0;
        for(int i=1;i<x.length;i++) {
            ans = Math.max(ans, x[i] - x[i-1]);
        }
        return ans;
    }
}