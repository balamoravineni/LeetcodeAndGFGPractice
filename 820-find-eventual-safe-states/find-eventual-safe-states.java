class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // reverse the edges & topo sort
        int[] inDegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<n;i++) {
            for(int temp: graph[i]) {
                adjList.get(temp).add(i);
                inDegree[i]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        // topo sort
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) queue.add(i);
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            ans.add(curr);
            for(int temp: adjList.get(curr)) {
                inDegree[temp]--;
                if(inDegree[temp]==0) queue.add(temp);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}