class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int[] meeting: meetings) {
            adjList.get(meeting[0]).add(new int[]{meeting[1], meeting[2]});
            adjList.get(meeting[1]).add(new int[]{meeting[0], meeting[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1]-e2[1]);
        pq.add(new int[]{0, 0});
        pq.add(new int[]{firstPerson,0});
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            if(!visited[current[0]]) {
                ans.add(current[0]);
                visited[current[0]] = true;     
            }
            for(int[] temp: adjList.get(current[0])) {
                if(!visited[temp[0]] && temp[1]>=current[1]) {
                    pq.add(new int[]{temp[0], temp[1]});
                }
            }
        }
        return ans;
    }
}