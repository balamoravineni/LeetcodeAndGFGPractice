class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // return usingMapAndSet(arr);
        return usingArrays(arr);
    }

    boolean usingArrays(int[] arr) {
        int[] counter = new int[2001];
        boolean[] freq = new boolean[1001];
        for(int temp: arr) counter[temp+1000]++;
        for(int temp: counter) {
            if(temp==0) continue;
            if(freq[temp]) return false;
            else freq[temp] = true;
        }
        return true;
    }

    boolean usingMapAndSet(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int temp: arr) {
            if(map.containsKey(temp)) map.put(temp, map.get(temp)+1);
            else map.put(temp, 1);
        }
        Set<Integer> freq = new HashSet<>();
        for(int key: map.keySet()) {
            if(freq.contains(map.get(key))) return false;
            else freq.add(map.get(key));
        }
        return true;
    }
}