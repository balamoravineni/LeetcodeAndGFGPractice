class Pair {
    int node;
    int weight;
    Pair(int a, int b) {
        node = a;
        weight = b;
    }
}

class Tuple {
    int node;
    int stops;
    int dist;
    Tuple(int a, int b, int c) {
        node = a;
        stops = b;
        dist = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int[] flight: flights) adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
        int[] dist = new int[n];
        int[] stops = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> {
            if(t1.stops!=t2.stops) return t1.stops-t2.stops;
            return t1.dist-t2.dist;
        });
        pq.add(new Tuple(src, 0, 0));
        while(!pq.isEmpty()) {
            Tuple current = pq.poll();
            for(Pair next: adjList.get(current.node)) {
                if(current.stops<=k && current.dist+next.weight<dist[next.node]) {
                    dist[next.node] = current.dist+next.weight;
                    pq.offer(new Tuple(next.node, current.stops+1, current.dist+next.weight));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}