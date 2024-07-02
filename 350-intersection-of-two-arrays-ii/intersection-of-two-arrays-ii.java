class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int temp:nums1) {
            freq.put(temp, freq.getOrDefault(temp, 0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int temp:nums2) {
            if(freq.get(temp)!=null) {
                int newFreq = freq.get(temp);
                if(newFreq>0) {
                    ans.add(temp);
                    freq.put(temp, newFreq-1);
                }
            } 
        }
        int[] ansArr = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}