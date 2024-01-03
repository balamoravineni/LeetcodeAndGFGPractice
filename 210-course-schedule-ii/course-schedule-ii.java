class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return usingAdjList(numCourses, prerequisites);
    }
    int[] usingAdjList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(visited[i]==0) {
                if(dfs(adjList,i,visited, stack)) return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        int i=0;
        while(!stack.isEmpty()) ans[i++] = stack.pop();
        return ans;
    }

    boolean dfs(List<List<Integer>> adjList, int index, int[] visited, Deque<Integer> stack) {
        visited[index]=2;
        for(int temp: adjList.get(index)) {
            if(visited[temp]==2) return true;
            if(visited[temp]==0) {
                if(dfs(adjList,temp,visited, stack)) return true;
            }
        }
        stack.add(index);
        visited[index]=1;
        return false;
    }

}