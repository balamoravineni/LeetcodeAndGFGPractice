class Solution {
    public int maxScore(String s) {
        int num0 = countChar(s.substring(0,1), '0');
        int num1 = countChar(s.substring(1,s.length()), '1');
        int ans = num0 + num1;
        // System.out.println(num0 + " " + num1);
        for(int i=1;i<s.length()-1;i++) {
            if(s.charAt(i)=='0') {
                num0++;
            }
            else {
                num1--;
            }
            // System.out.println(s.charAt(i) + " " + num0 + " " + num1);
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