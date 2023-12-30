class Solution {
    public boolean makeEqual(String[] words) {
        if(words.length<=1) return true;
        int[] charFreq = new int[26];
        for(String word: words) {
            for(char ch: word.toCharArray()) {
                charFreq[ch-'a']+=1;
            }
        }
        // for(int temp: charFreq) System.out.print(temp + " ");
        for(int temp: charFreq) if(temp%words.length!=0) return false;
        return true;
    }
}