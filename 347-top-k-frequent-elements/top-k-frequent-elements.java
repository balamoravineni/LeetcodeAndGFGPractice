class Pair {
    int num;
    int freq;
    Pair(int a, int b) {
        num = a;
        freq = b;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int temp: nums) freq.put(temp, freq.getOrDefault(temp, 0)+1);
        List<Pair> arr = new ArrayList<>();
        for(int key: freq.keySet()) {
            arr.add(new Pair(key, freq.get(key)));
        }
        Collections.sort(arr, (p1, p2) -> p2.freq - p1.freq);
        int[] ans = new int[k];
        for(int i=0;i<k;i++) {
            ans[i] = arr.get(i).num;
        }
        return ans;
    }
}