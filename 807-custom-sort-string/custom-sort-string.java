class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        for(int i=0;i<s.length();i++) map[s.charAt(i)-'a']++;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<order.length();i++) {
            while(map[order.charAt(i)-'a']-->0) {
                ans.append(order.charAt(i));
            }
        }
        for(int i=0;i<26;i++) {
            while(map[i]-->0) {
                ans.append((char)('a'+i));
            }
        }
        return ans.toString();
    }
}