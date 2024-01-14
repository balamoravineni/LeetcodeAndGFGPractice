class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int i = 0;
        int ans = 1;
        int n = s.length();
        while(i<n) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), i);
            int j = i+1;
            while(j<n && !map.containsKey(s.charAt(j)))  {
                map.put(s.charAt(j), j);
                j++;
            }
            ans = Math.max(ans, j-i);
            if(j<n) i = map.get(s.charAt(j))+1;
            else break;
        }
        return ans;
    }
}