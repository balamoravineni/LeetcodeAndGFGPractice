class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int res = -1;
        for(int i=0;i<s.length();i++) {
            if(arr[s.charAt(i)-'a']!=-1) {
                res = Math.max(res, i-arr[s.charAt(i)-'a']-1);
            }
            else arr[s.charAt(i)-'a'] = i;
        }
        return res;
    }
}