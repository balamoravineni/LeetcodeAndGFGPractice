class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                if(count!=0) ans.append('(');
                count++;
            }
            else {
                if(count!=1) ans.append(')');
                count--;
            }
        }
        return ans.toString();
    }
}