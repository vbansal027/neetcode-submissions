class Solution {

    private Integer applyOperation(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return a / b;
        }
    }

    public int evalRPN(String[] tokens) {
        
        Set<String> operands = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack();

        for (String token : tokens) {
            if (operands.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperation(a, b, token.charAt(0)));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
