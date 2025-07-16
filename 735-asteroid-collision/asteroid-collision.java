import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int top = stack.peek();
                
                if (Math.abs(a) > top) {
                    // top asteroid explodes
                    stack.pop();
                    // Continue checking
                } else if (Math.abs(a) == top) {
                    // both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                   // left-moving asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
