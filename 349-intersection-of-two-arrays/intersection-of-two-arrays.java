class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int temp: nums1) {
            map.put(temp, false);
        }
        int size = 0;
        for(int temp: nums2) {
            if(map.containsKey(temp)) {
                if(!map.get(temp)) {
                    size++;
                    map.put(temp, true);
                }
            }
        }
        int[] ans = new int[size];
        size = 0;
        for(int key: map.keySet()) if(map.get(key)) ans[size++] = key;
        return ans;
    }
}