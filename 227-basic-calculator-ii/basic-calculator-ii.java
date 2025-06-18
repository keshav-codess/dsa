class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build multi-digit numbers
            if (Character.isDigit(ch)) {
                operand = operand * 10 + (ch - '0');
            }

            // If operator or end of string
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (operator) {
                    case '+':
                        stack.push(operand);
                        break;
                    case '-':
                        stack.push(-operand);
                        break;
                    case '*':
                        stack.push(stack.pop() * operand);
                        break;
                    case '/':
                        stack.push(stack.pop() / operand);
                        break;
                }

                // Reset for next number and update operator
                operator = ch;
                operand = 0;
            }
        }

        // Sum up all values in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }
}
