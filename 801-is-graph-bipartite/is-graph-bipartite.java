class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(visited[i]==0) {
                // if(!bfs(graph, i, visited)) {
                //     return false;
                // }
                if(!dfs(graph, i, visited, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int[][] graph, int index, int[] visited, int currLevel) {
        visited[index] = currLevel;
        for(int i=0;i<graph[index].length;i++) {
            if(visited[graph[index][i]]==0) {
                if(!dfs(graph, graph[index][i], visited, currLevel==1?2:1)) return false;
            }
            else if(visited[graph[index][i]]==currLevel) {
                return false;
            }
        }
        return true;
    }

    boolean bfs(int[][] graph, int init, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[init] = 1;
        queue.add(init);
        int currLevel = 1;
        int nextLevel = 2;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // System.out.println(queue + "; " + currLevel + " " + nextLevel);
            while(size-->0) {
                int curr = queue.remove();
                for(int i=0;i<graph[curr].length;i++) {
                    if(visited[graph[curr][i]]==0) {
                        visited[graph[curr][i]] = nextLevel;
                        queue.add(graph[curr][i]);
                    }
                    else if(visited[graph[curr][i]]==currLevel) {
                        return false;
                    }
                }
            }
            currLevel = currLevel==1?2:1;
            nextLevel = nextLevel==1?2:1;
        }
        return true;
    }
}