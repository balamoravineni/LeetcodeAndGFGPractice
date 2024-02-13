class Solution {
    public String firstPalindrome(String[] words) {
        for(String temp: words) if(isPalindrome(temp)) return temp;
        return "";
    }

    boolean isPalindrome(String str) {
        for(int i=0,j=str.length()-1; i<j;i++,j--) {
            if(str.charAt(i)!=str.charAt(j)) return false;
        }
        return true;
    }
}