class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String temp: strs) {
            char[] tempArr = temp.toCharArray();
            Arrays.sort(tempArr);
            String sorted = new String(tempArr);
            if(map.containsKey(sorted)) map.get(sorted).add(temp);
            else map.put(sorted, new ArrayList<>(Arrays.asList(temp)));
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key: map.keySet()) ans.add(map.get(key));
        return ans;
    }
}