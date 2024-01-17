class Solution {
    public boolean uniqueOccurrences(int[] arr) {
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