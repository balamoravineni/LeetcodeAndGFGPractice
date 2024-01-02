class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // return sortingWay(nums);
        // return usingMap(nums);
        return usingArrayFreqCounterItself(nums);
    }   

    List<List<Integer>> usingArrayFreqCounterItself(int[] nums) {
        int[] freq = new int[nums.length+1];
        int highFreq = 1;
        for(int temp: nums) {
            freq[temp]++;
            highFreq = Math.max(highFreq, freq[temp]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<highFreq;i++) ans.add(new ArrayList<>());
        for(int key=0;key<freq.length;key++) {
            int f = freq[key];
            while(--f>=0) ans.get(f).add(key);
        }
        return ans;
    }

    List<List<Integer>> usingMap(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int highFreq = 1;
        for(int temp: nums) {
            if(map.get(temp)==null) map.put(temp,1);
            else {
                map.put(temp,map.get(temp)+1);
                highFreq = Math.max(highFreq, map.get(temp));
            }
        }
        // System.out.println(map + " " + highFreq);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<highFreq;i++) ans.add(new ArrayList<>());
        for(int key: map.keySet()) {
            int freq = map.get(key);
            while(--freq>=0) ans.get(freq).add(key);
        }
        return ans;
    }

    List<List<Integer>> sortingWay(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        for(int i=0;i<nums.length;) {
            if(ans.size()==index) {
                ans.add(new ArrayList<>());
            }
            if(ans.get(index).size()==0 || ans.get(index).get(ans.get(index).size()-1)!=nums[i]) {
                ans.get(index).add(nums[i++]);
            }
            if(i<=nums.length-1 && nums[i]==nums[i-1]) {
                index++;
            }
            else if(i<=nums.length-1 && nums[i]!=nums[i-1]) {
                index=0;
            }
        }
        return ans;
    }
}