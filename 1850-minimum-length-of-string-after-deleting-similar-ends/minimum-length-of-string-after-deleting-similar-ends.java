class Solution {
    public int minimumLength(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            char current = s.charAt(i);
            if(current!=s.charAt(j)) break;
            while(i+1<j && s.charAt(i+1)==current) i++;
            while(j-1>i && s.charAt(j-1)==current) j--;
            i++;
            j--;
        }
        return j-i+1;
    }
}