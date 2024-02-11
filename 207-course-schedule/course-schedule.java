class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // return usingKahnsAlgo(numCourses, prerequisites);
        return usingDFS(numCourses, prerequisites);
    }

    boolean usingDFS(int numCourses, int[][] prerequisites) {
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

    boolean usingKahnsAlgo(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        // for(int temp: inDegree) System.out.print(temp + " ");
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(inDegree[i]==0) queue.add(i);
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            ans.add(curr);
            for(int temp: adjList.get(curr)) {
                inDegree[temp]--;
                if(inDegree[temp]==0) queue.add(temp);
            }
        }
        return ans.size()==numCourses;
    }
}