class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(visited[i]==0 && dfsIsCycle(adjList, visited, i)) return false;
        }
        return true;
    }

    boolean dfsIsCycle(List<List<Integer>> adjList, int[] visited, int index) {
        visited[index] = 2;
        for(int temp: adjList.get(index)) {
            if(visited[temp]==2) return true;
            if(visited[temp]==0 && dfsIsCycle(adjList, visited, temp)) return true;
        }
        visited[index] = 1;
        return false;
    }
}