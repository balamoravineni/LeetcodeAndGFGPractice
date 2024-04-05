class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(ans.length()==0) {
                ans.append(s.charAt(i));
                // System.out.println(i + ":" + ans.toString());
                continue;
            }
            char ch1 = ans.charAt(ans.length()-1);
            char ch2 = s.charAt(i);
            if((ch1>='a' && ch1<='z' && ch2>='A' && ch2<='Z' && ((ch1-'a')==(ch2-'A'))) || 
                (ch1>='A' && ch1<='Z' && ch2>='a' && ch2<='z' && ((ch1-'A')==(ch2-'a')))) {
                ans.deleteCharAt(ans.length()-1);
            }
            else {
                ans.append(ch2);
            }
            // System.out.println(i + ":" + ans.toString());
        }
        return ans.toString();
    }
}