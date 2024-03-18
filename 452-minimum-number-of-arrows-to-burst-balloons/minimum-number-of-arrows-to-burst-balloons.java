class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1,p2) -> {
            if(p1[0]<p2[0]) return -1;
            else if(p1[0]>p2[0]) return 1;
            else {
                if(p1[1]<p2[1]) return -1;
                else if(p1[1]>p2[1]) return 1;
                return 0;
            }
        });
        // System.out.println(points[0][0]);
        // for(int i=0;i<points.length;i++) System.out.printf("[%d, %d],", points[i][0], points[i][1]);
        System.out.println();
        List<int[]> intersections = new ArrayList<>();
        intersections.add(points[0]);
        for(int i=1;i<points.length;i++) {
            int[] prev = intersections.get(intersections.size()-1);
            // System.out.println(prev[1] + " < " + points[i][0] + ": " + (prev[1]<points[i][0]));
            if(prev[1]<points[i][0]) {
                intersections.add(points[i]);
            }
            else {
                prev[0] = points[i][0];
                prev[1] = Math.min(prev[1],points[i][1]);
            }
        }
        return intersections.size();
    }
}