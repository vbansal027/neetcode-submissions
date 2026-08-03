class Solution {

    private boolean isOpen(char c) {
        return (c == '(' || c == '[' || c == '{');
    }

    private boolean isMatch(char c, char top) {
        switch (c) {
            case ')':
                return top == '(';
            case ']':
                return top == '[';
            case '}':
                return top == '{';
            default:
                return false;
        }
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {

            if (isOpen(c)) {
                stack.push(c);
            } else if (stack.empty()) {
                return false;
            } else {
                if (isMatch(c, stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();        
    }
}
