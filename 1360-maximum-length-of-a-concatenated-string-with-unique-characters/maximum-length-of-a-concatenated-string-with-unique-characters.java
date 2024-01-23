class Solution {
    public int maxLength(List<String> arr) {
        int[] freq = new int[26];
        return helper(arr,freq,0);
    }

    int helper(List<String> arr, int[] freq, int index) {
        if(index==arr.size()) return 0;
        int ans = 0;
        if(canConsider(freq, arr.get(index))) {
            String temp = arr.get(index);
            for(int i=0;i<temp.length();i++) freq[temp.charAt(i)-'a']++;
            ans = arr.get(index).length() + helper(arr, freq, index+1);
            for(int i=0;i<temp.length();i++) freq[temp.charAt(i)-'a']--;
        }
        // not consider
        ans = Math.max(ans,helper(arr, freq, index+1));
        return ans;
    }

    boolean canConsider(int[] freq, String input) {
        int[] temp = new int[26];
        for(int i=0;i<input.length();i++) {
            if(temp[input.charAt(i)-'a']>0) return false;
            else temp[input.charAt(i)-'a']++;
        }
        for(int i=0;i<input.length();i++) {
            if(freq[input.charAt(i)-'a']>0) return false;
        }
        return true;
    }
}