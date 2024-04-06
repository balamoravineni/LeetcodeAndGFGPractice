class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                stack.push(i);
            }
            else if(s.charAt(i)==')') {
                if(!stack.isEmpty() && s.charAt(stack.peek())=='(') {
                    stack.pop();
                }
                else {
                    stack.push(i);
                }
            }
        }
        StringBuilder ans = new StringBuilder(s);
        while(!stack.isEmpty()) {
            ans.deleteCharAt(stack.pop());
        }
        return ans.toString();
    }
}