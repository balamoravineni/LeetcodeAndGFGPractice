class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int n = word1.length();
        for(int i=0;i<n;i++) {
            count1[word1.charAt(i)-'a']++;
            count2[word2.charAt(i)-'a']++;
        }
        boolean sameChars = true;
        for(int i=0;i<26;i++) {
            if(count1[i]!=count2[i]) sameChars = false;
            if((count1[i]!=0 && count2[i]==0) || (count1[i]==0 && count2[i]!=0)) return false;
        }
        if(sameChars) return true;
        Arrays.sort(count1);
        Arrays.sort(count2);
        for(int i=0;i<26;i++) {
            if(count1[i]!=count2[i]) return false;
        }
        // int[] freq = new int[n+1];
        // for(int temp: count1) if(temp!=0) freq[temp]++;
        // for(int temp: count2) if(temp!=0) freq[temp]--;
        // for(int temp: freq) if(temp!=0) return false;
        return true;
    }
}