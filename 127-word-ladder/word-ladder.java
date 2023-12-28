class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginWordIndex = -1;
        int endWordIndex = -1;
        for(int i=0;i<wordList.size();i++) {
            if(wordList.get(i).equals(beginWord)) beginWordIndex = i;
            if(wordList.get(i).equals(endWord)) endWordIndex = i;
        }
        if(endWordIndex==-1) return 0;
        if(beginWordIndex==-1) {
            wordList.add(beginWord);
            beginWordIndex = wordList.size()-1;
        }
        int n = wordList.size();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(isDiffOnlyOne(wordList.get(i), wordList.get(j))) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        // System.out.println(adjList);
        // System.out.println(endWordIndex);
        // System.out.println(beginWordIndex);
        return bfs(beginWordIndex, endWordIndex, adjList);
    }

    int bfs(int beginWordIndex, int endWordIndex, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(beginWordIndex);
        visited[beginWordIndex] = true;
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            // System.out.println("level: " + level + " - " + queue);
            int tempSize = queue.size();
            for(int z=0;z<tempSize;z++) {
                int curr = queue.remove();
                // visited[curr] = true;
                if(curr==endWordIndex) {
                    return level;
                }
                for(int t: adjList.get(curr)) {
                    if(!visited[t]) {
                        queue.add(t);
                        visited[t] = true;
                    }
                }
            }
        }
        return 0;
    }

    boolean isDiffOnlyOne(String s1, String s2) {
        int diff = 0;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
            if(diff>1) return false;
        }
        return true;
    }
}