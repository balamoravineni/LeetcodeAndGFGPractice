class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topoSortDFS(numCourses, prerequisites);
    }
    int[] topoSortDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        int[] ans = new int[numCourses];
        int[] ansIndex = new int[1];
        // Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(visited[i]==0) {
                if(isCyclicDFS(adjList,i,visited, ans, ansIndex)) return new int[0];
            }
        }
        // while(!stack.isEmpty()) ans[i++] = stack.pop();
        return ans;
    }

    boolean isCyclicDFS(List<List<Integer>> adjList, int index, int[] visited, int[] ans, int[] ansIndex) {
        visited[index]=2;
        for(int temp: adjList.get(index)) {
            if(visited[temp]==2) return true;
            if(visited[temp]==0) {
                if(isCyclicDFS(adjList,temp,visited, ans, ansIndex)) return true;
            }
        }
        ans[ansIndex[0]++]=index;
        visited[index]=1;
        return false;
    }

}