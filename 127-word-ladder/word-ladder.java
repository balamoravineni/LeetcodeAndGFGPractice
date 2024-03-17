class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Integer> map = new HashMap<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<wordList.size();i++) {
            map.put(wordList.get(i), i);
            adjList.add(new ArrayList<>());
        }
        int endIndex = -1;
        if(!map.containsKey(endWord)) return 0;
        else endIndex = map.get(endWord);
        int beginIndex = -1;
        if(!map.containsKey(beginWord)) {
            map.put(beginWord, adjList.size());
            beginIndex = adjList.size();
            wordList.add(beginWord);
            adjList.add(new ArrayList<>());
        }
        else {
            beginIndex = map.get(beginWord);
        }
        // System.out.println(beginIndex + " " + endIndex + ": " + wordList.size());
        
        for(String word: wordList) {
            int currIndex = map.get(word);
            char[] wordArr = word.toCharArray();
            for(int i=0;i<wordArr.length;i++) {
                char original = wordArr[i];
                for(int temp=0;temp<26;temp++) {
                    wordArr[i] = (char)((int)'a'+temp);
                    String str = new String(wordArr);
                    // System.out.println(str);
                    if(map.containsKey(str)) {
                        int strIndex = map.get(str);
                        if(strIndex!=currIndex) {
                            adjList.get(currIndex).add(strIndex);
                            // adjList.get(strIndex).add(currIndex);
                        }
                    }
                }
                wordArr[i] = original;
            }
        }
        // System.out.println(adjList);

        // BFS to get shortest path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        queue.add(beginIndex);
        visited[beginIndex] = true;
        int ans = 1;
        while(!queue.isEmpty()) {
            // System.out.println(ans + " -> " + queue);
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int curr = queue.remove();
                if(curr==endIndex) return ans;
                for(int temp: adjList.get(curr)) {
                    if(!visited[temp]) {
                        queue.add(temp);
                        visited[temp] = true;
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}