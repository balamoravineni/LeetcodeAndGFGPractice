
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer, Integer>> pathSet = new HashSet<>();
        Pair<Integer, Integer> current = new Pair(0,0);
        pathSet.add(current);
        // System.out.println(pathSet);
        for(int i=0;i<path.length();i++) {
            Pair<Integer, Integer> next = null;
            switch(path.charAt(i)) {
                case 'N': {
                    next = new Pair(current.getKey(), current.getValue()+1);
                    break;
                }
                case 'S': {
                    next = new Pair(current.getKey(), current.getValue()-1);
                    break;
                }
                case 'E': {
                    next = new Pair(current.getKey()+1, current.getValue());
                    break;
                }
                case 'W': {
                    next = new Pair(current.getKey()-1, current.getValue());
                    break;
                }
            }
            if(pathSet.contains(next)) return true;
            pathSet.add(next);
            // System.out.println(pathSet);
            current = next;
        }
        return false;
    }
}