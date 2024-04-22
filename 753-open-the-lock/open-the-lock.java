class Pair {
    String combo;
    int level;

    Pair(String str, int l) {
        combo = str;
        level = l;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        String init = "0000";

        Set<String> visitedSet = new HashSet<>();
        Set<String> deadendSet = new HashSet<>();
        for(String temp: deadends) deadendSet.add(temp);
        Queue<Pair> queue = new LinkedList<>();
        if(!deadendSet.contains(init)) queue.add(new Pair(init, 0));

        while(!queue.isEmpty()) {
            Pair curr = queue.remove();
            // System.out.println(curr.combo + ": " + curr.level);
            if(curr.combo.equals(target)) return curr.level;
            for(int i=0;i<4;i++) {
                char[] next1 = curr.combo.toCharArray();
                char[] next2 = curr.combo.toCharArray();
                if(next1[i]=='9') next1[i] = '0';
                else next1[i]++;
                if(next2[i]=='0') next2[i] = '9';
                else next2[i]--;

                String str1 = new String(next1);
                String str2 = new String(next2);
                if(!deadendSet.contains(str1) && !visitedSet.contains(str1)) {
                    queue.add(new Pair(str1, curr.level+1));
                    visitedSet.add(str1);
                }
                if(!deadendSet.contains(str2) && !visitedSet.contains(str2)) {
                    queue.add(new Pair(str2, curr.level+1));
                    visitedSet.add(str2);
                }
            }
        }

        return -1;
    }
}