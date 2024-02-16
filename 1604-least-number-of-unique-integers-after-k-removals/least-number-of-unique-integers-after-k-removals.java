class Pair {
    int num;
    int count;
    Pair(int a, int b) {
        num = a;
        count = b;
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int temp: arr) {
            if(freq.containsKey(temp)) freq.put(temp, freq.get(temp)+1);
            else freq.put(temp, 1);
        }
        List<Pair> list = new ArrayList<>();
        for(int key: freq.keySet()) list.add(new Pair(key, freq.get(key)));
        Collections.sort(list, (p1, p2) -> p1.count-p2.count);
        int ans = list.size();
        for(Pair temp: list) {
            k-=temp.count;
            if(k>=0) ans--;
            if(k<=0) break;
        }
        return ans;
    }
}