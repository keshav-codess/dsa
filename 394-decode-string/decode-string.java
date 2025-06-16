class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // Stack to store repeat counts
        Stack<StringBuilder> stringStack = new Stack<>(); // Stack to store previous strings
        StringBuilder currentString = new StringBuilder(); // Stores the current working string
        int num = 0; // Accumulates digits to form multi-digit numbers

        for (char singleChar : s.toCharArray()) {
            if (Character.isDigit(singleChar)) {
                // Convert character to digit and form the full number
                num = num * 10 + (singleChar - '0');
            } else if (singleChar == '[') {
                // Push the current repeat count and current string to stacks
                countStack.push(num);
                stringStack.push(currentString);
                // Reset for next segment
                num = 0;
                currentString = new StringBuilder();
            } else if (singleChar == ']') {
                // Pop count and previous string, then append current string 'count' times
                int repeat = countStack.pop();
                StringBuilder prevString = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prevString.append(currentString);
                }
                currentString = prevString;
            } else {
                // Append characters to current string
                currentString.append(singleChar);
            }
        }

        return currentString.toString();
    }
}
