class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // return usingMap(nums1,nums2);
        return usingSorting(nums1, nums2);
    }

    int[] usingSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> ans = new ArrayList<>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]==nums2[j]) ans.add(nums1[i]);
            else if(nums1[i]<nums2[j]) {
                i++;
                continue;
            }
            else {
                j++;
                continue;
            }
            while(i+1<nums1.length && nums1[i+1]==nums1[i]) i++;
            i++;
            while(j+1<nums2.length && nums2[j+1]==nums2[j]) j++;
            j++;
        }
        int[] res = new int[ans.size()];
        int size = 0;
        for(int temp: ans) res[size++] = temp;
        return res;
    }

    int[] usingMap(int[] nums1, int[] nums2) {
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