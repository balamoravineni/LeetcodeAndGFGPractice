class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int reqIndex = binarySearch(intervals, newInterval[0]);
        List<int[]> ans = new ArrayList<>();
        int i=0;
        for(;i<reqIndex;i++) ans.add(intervals[i]);

        if(reqIndex!=0) {
            if(ans.get(ans.size()-1)[1]<newInterval[0]) {
                ans.add(newInterval);
            }
            else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], newInterval[1]);
            }
        }
        else {
            ans.add(newInterval);
        }
        // System.out.println(reqIndex);

        for(;i<intervals.length;i++) {
            if(ans.get(ans.size()-1)[1]<intervals[i][0]) {
                ans.add(intervals[i]);
            }
            else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
        }

        int[][] result = new int[ans.size()][2];
        i=0;
        for(int[] temp: ans) result[i++] = temp;
        return result;
    }

    int binarySearch(int[][] intervals, int target) {
        int lo = 0;
        int hi = intervals.length-1;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(intervals[mid][0]<target){
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return lo;
    }
}