class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int beginIndex=-1, endIndex=-1;
        for(int i=0;i<wordList.size();i++) {
            if(beginWord.equals(wordList.get(i))) beginIndex = i;
            if(endWord.equals(wordList.get(i))) endIndex = i;
        }
        if(endIndex==-1) return new ArrayList<>();
        if(beginIndex==-1) {
            wordList.add(beginWord);
            beginIndex = wordList.size()-1;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        int n = wordList.size();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(isDiffOnlyOne(wordList.get(i),wordList.get(j))) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        List<List<Integer>> parent = new ArrayList<>();
        for(int i=0;i<n;i++) parent.add(new ArrayList<>());
        bfs(beginIndex, adjList, parent);
        // System.out.println(parent);

        List<List<Integer>> paths = new ArrayList<>();
        findAllPaths(endIndex, paths, new ArrayList<>(), parent);

        List<List<String>> ans = new ArrayList<>();
        for(List<Integer> currPath: paths) {
            List<String> temp = new ArrayList<>();
            Collections.reverse(currPath);
            for(int t: currPath) {
                temp.add(wordList.get(t));
            }
            ans.add(temp);
        }
        return ans;
    }

    void findAllPaths(int end, List<List<Integer>> paths, List<Integer> path, List<List<Integer>> parent) {
        if(end==-1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int tempParent : parent.get(end)) {
            path.add(end);
            findAllPaths(tempParent, paths, path, parent);
            path.remove(path.size()-1);
        }
    }

    void bfs(int start, List<List<Integer>> adjList, List<List<Integer>> parent) {
        int[] dist = new int[adjList.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        parent.get(start).clear();
        parent.get(start).add(-1);
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int curr = queue.remove();
            for(int temp: adjList.get(curr)) {
                if (dist[temp] > dist[curr] + 1) {
                    dist[temp] = dist[curr] + 1;
                    queue.add(temp);
                    parent.get(temp).clear();
                    parent.get(temp).add(curr);
                }
                else if (dist[temp] == dist[curr] + 1) {
                    parent.get(temp).add(curr);
                }
            }
        }
    }

    boolean isDiffOnlyOne(String w1, String w2) {
        int diff = 0;
        for(int i=0;i<w1.length();i++) {
            if(w1.charAt(i)!=w2.charAt(i)) diff++;
            if(diff>1) return false;
        }
        return diff==1;
    }
}