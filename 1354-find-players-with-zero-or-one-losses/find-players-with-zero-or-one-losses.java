class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> losers = new HashMap<>();
        for(int[] temp: matches) {
            if(losers.containsKey(temp[1])) losers.put(temp[1], losers.get(temp[1])+1);
            else losers.put(temp[1],1);
        }
        Set<Integer> ans0 = new HashSet<>();
        Set<Integer> ans1 = new HashSet<>();
        for(int[] temp: matches) {
            if(!losers.containsKey(temp[0])) ans0.add(temp[0]);
            if(losers.get(temp[1])==1) ans1.add(temp[1]); 
        }
        List<Integer> a0 = new ArrayList<>(ans0);
        List<Integer> a1 = new ArrayList<>(ans1);
        Collections.sort(a0);
        Collections.sort(a1);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(a0);
        ans.add(a1);
        return ans;
    }
}