class Solution {
    public int maxScore(String s) {
        int ans = 0;
        for(int i=1;i<s.length();i++) {
            int num0 = countChar(s.substring(0,i), '0');
            int num1 = countChar(s.substring(i,s.length()), '1');
            ans = Math.max(ans, num0+num1);
        }
        return ans;
    }

    int countChar(String s, char ch) {
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==ch) count++;
        }
        return count;
    }
}