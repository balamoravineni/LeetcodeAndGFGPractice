class Solution {
    public int maxScore(String s) {
        // return twoPass(s);
        return onePass(s);
    }

    int onePass(String s) {
        // score = ZeroL + oneR = oneT + (ZeroL - oneL) -> maximize
        int max = Integer.MIN_VALUE;
        int oneT=0, zeroL=0, oneL=0;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)=='1') {
                oneT++;
                oneL++;
            }
            else {
                zeroL++;
            }
            max = Math.max(max, zeroL-oneL);
        }
        if(s.charAt(s.length()-1)=='1') {
            oneT++;
        }
        return oneT + max;
    }

    int twoPass(String s) {
        int num0 = 0;
        int num1 = countChar(s, '1');
        int ans = 0;
        // System.out.println(num0 + " " + num1);
        for(int i=0;i<s.length()-1;i++) {
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