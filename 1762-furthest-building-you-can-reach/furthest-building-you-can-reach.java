class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1-i2);
        int i=0;
        for(;i<heights.length-1;i++) {
            int diff = heights[i+1]-heights[i];
            if(diff<=0) {
                continue;
            }
            else {
                if(ladders>0) {
                    ladders--;
                    pq.add(diff);
                    continue;
                }
                else if(!pq.isEmpty() && diff>pq.peek()) {
                    if(pq.peek()<=bricks) {
                        bricks -= pq.peek();
                        pq.poll();
                        pq.add(diff);
                    }
                    else {
                        break;
                    }
                }
                else {
                    if(diff<=bricks) {
                        bricks -= diff;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return i;
    }
}