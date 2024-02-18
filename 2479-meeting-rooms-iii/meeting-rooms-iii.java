class Pair {
    int room;
    int endTime;
    Pair(int a, int b) {
        room = a;
        endTime = b;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meets = new int[n];
        PriorityQueue<Integer> roomsPQ = new PriorityQueue<>((r1, r2) -> r1-r2);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if(p1.endTime==p2.endTime) return p1.room-p2.room;
            return p1.endTime-p2.endTime;
        });
        for(int i=0;i<n;i++) roomsPQ.add(i);
        Arrays.sort(meetings, (a1, a2) -> a1[0]-a2[0]); // unique start Times always
        // for(int[] temp: meetings)  System.out.print(temp[0] + "," + temp[1] + " - ");
        System.out.println();
        for(int[] temp: meetings) {
            int start = temp[0];
            int end = temp[1];
            while(!pq.isEmpty() && pq.peek().endTime<=start) {
                roomsPQ.add(pq.peek().room);
                pq.poll();
            }
            if(!roomsPQ.isEmpty()) {
                int room = roomsPQ.poll();
                meets[room]++;
                pq.add(new Pair(room, end));
            }
            else {
                Pair polled = pq.poll();
                meets[polled.room]++;
                int newEnd = polled.endTime + end - start;
                pq.add(new Pair(polled.room, newEnd));
            }
            // System.out.println("After meeting: ");
            // for(Pair t: pq) {
            //     System.out.println(t.room + ": " + t.endTime);
            // }
        }

        // for(int temp: meets)  System.out.print(temp + " ");
        int ans = 0;
        int maxMeets = meets[0];
        for(int i=1;i<n;i++) {
            if(meets[i]>maxMeets) {
                ans = i;
                maxMeets = meets[i];
            }
        }
        return ans;
    }
}