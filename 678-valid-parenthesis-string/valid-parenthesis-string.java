class Solution {
    public boolean checkValidString(String s) {
        int leftOrStar = 0;
        int right = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='*') {
                leftOrStar++;
            }
            else {
                right++;
            }
            if(right>leftOrStar) return false;
        }

        int left = 0;
        int rightOrStar = 0;
        for(int i=s.length()-1;i>=0;i--) {
            char ch = s.charAt(i);
            if(ch==')' || ch=='*') {
                rightOrStar++;
            }
            else {
                left++;
            }
            if(left>rightOrStar) return false;
        }

        return true;
    }
}