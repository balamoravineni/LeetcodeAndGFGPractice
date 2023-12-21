class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Point> pointList = new ArrayList<>();
        for(int[] arr: points) {
            pointList.add(new Point(arr[0], arr[1]));
        }
        Collections.sort(pointList, (p1, p2) -> p1.x-p2.x);
        int ans = 0;
        for(int i=1;i<pointList.size();i++) {
            ans = Math.max(ans, pointList.get(i).x - pointList.get(i-1).x);
        }
        return ans;
    }
}