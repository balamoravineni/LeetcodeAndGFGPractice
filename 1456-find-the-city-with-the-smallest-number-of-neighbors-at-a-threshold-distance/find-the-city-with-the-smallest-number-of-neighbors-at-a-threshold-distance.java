class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // return usingDjikstra(n, edges, distanceThreshold);
        return usingFloydWarshall(n, edges, distanceThreshold);
    }

    int usingFloydWarshall(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] temp:dist) Arrays.fill(temp, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) dist[i][i] = 0;
        for(int[] edge: edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE && 
                        dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(dist[i][j]<=distanceThreshold) count++;
            }
            if(count<=min) {
                ans = i;
                min = count;
            }
        }
        return ans;
    }

    int usingDjikstra(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair<Integer,Integer>>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            List<Integer> tempAns = djikstra(adjList, n, distanceThreshold, i);
            if(tempAns.size()<=min) {
                min = tempAns.size();
                ans = i;
            }
        }
        return ans;
    }

    List<Integer> djikstra(List<List<Pair<Integer,Integer>>> adjList, int n, int distanceThreshold, int src) {

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.getValue()-p2.getValue());
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair<Integer,Integer> currPair = pq.remove();
            int currNode = currPair.getKey();
            int currWeight = currPair.getValue();
            for(Pair<Integer,Integer> nextPair: adjList.get(currNode)) {
                int nextNode = nextPair.getKey();
                int nextWeight = nextPair.getValue();
                if(dist[nextNode]> currWeight+nextWeight) {
                    dist[nextNode] = currWeight+nextWeight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(i!=src && dist[i]<=distanceThreshold) ans.add(i);
        }
        return ans;
    }
}