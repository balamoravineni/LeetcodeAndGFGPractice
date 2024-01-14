class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l=0, r=0, n=s.length();
        Set<Character> set = new HashSet<>();
        while(l<n && r< n) {
            if(!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            else {
                set.remove(s.charAt(l));
                l++;
            }
            ans = Math.max(ans, r-l);
        }
        return ans;
    }
}