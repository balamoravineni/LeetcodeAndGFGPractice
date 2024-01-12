class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int i = 0;
        s = s.toLowerCase();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        while(i<s.length()) {
            // if(i>=s.length()/2 && (s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')) {
            //     count--;
            // }
            if(i>=s.length()/2 && set.contains(s.charAt(i))) {
                count--;
            }
            else if(i<s.length()/2 && set.contains(s.charAt(i))) {
                count++;
            }
            // else if(i<s.length()/2 && (s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')) {
            //     count++;
            // }
            i++;
        }
        return count==0;
    }
}