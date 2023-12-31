class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        int[] ans = new int[26];
        Arrays.fill(arr, -1);
        Arrays.fill(ans, -1);
        for(int i=0;i<s.length();i++) {
            if(arr[s.charAt(i)-'a']!=-1) {
                ans[s.charAt(i)-'a'] = Math.max(ans[s.charAt(i)-'a'], i-arr[s.charAt(i)-'a']-1);
            }
            else arr[s.charAt(i)-'a'] = i;
        }
        int res = -1;
        for(int temp: ans) res = Math.max(res,temp);
        return res;
    }
}