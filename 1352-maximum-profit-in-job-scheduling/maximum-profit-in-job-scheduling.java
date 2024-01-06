class Triplet {
    int startTime, endTime, profit;
    Triplet(int a, int b, int c) {
        startTime = a;
        endTime = b;
        profit = c;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Triplet> input = new ArrayList<>();
        for(int i=0;i<startTime.length;i++) input.add(new Triplet(startTime[i], endTime[i], profit[i]));
        Collections.sort(input, (t1, t2) -> t1.startTime==t2.startTime?t1.endTime-t2.endTime:t1.startTime-t2.startTime);
        int[] dp = new int[input.size()];
        Arrays.fill(dp, -1);
        return recursiveHelper(input, 0, dp);
    }

    int recursiveHelper(List<Triplet> input, int i, int[] dp) {
        if(i==input.size()) return 0;
        if(dp[i]!=-1) return dp[i];
        int notTakeJob = 0 + recursiveHelper(input, i+1, dp);
        int nextIndex = binarySearchStartTimeLowerBound(input, input.get(i).endTime, i+1);
        int takeJob = input.get(i).profit + recursiveHelper(input, nextIndex, dp);
        return dp[i] = Math.max(notTakeJob, takeJob);
    }

    int binarySearchStartTimeLowerBound(List<Triplet> input, int time, int start) {
        int end = input.size()-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(input.get(mid).startTime<time) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
}