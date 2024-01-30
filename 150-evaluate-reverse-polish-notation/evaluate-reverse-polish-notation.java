class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++) {
            switch(tokens[i]) {
                case "+": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int res = num1 + num2;
                    stack.push(res);
                    break;
                }
                case "-": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int res = num1 - num2;
                    stack.push(res);
                    break;
                }
                case "*": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int res = num1 * num2;
                    stack.push(res);
                    break;
                }
                case "/": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int res = num1 / num2;
                    stack.push(res);
                    break;
                }
                default: {
                    stack.push(new Integer(tokens[i]));
                    break;
                }
            }
        }
        return stack.pop();
    }
}