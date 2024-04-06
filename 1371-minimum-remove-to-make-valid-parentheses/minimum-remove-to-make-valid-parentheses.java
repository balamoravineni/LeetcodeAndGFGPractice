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
        Set<Integer> indexes = new HashSet<>();
        while(!stack.isEmpty()) indexes.add(stack.pop());
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(!indexes.contains(i)) ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}