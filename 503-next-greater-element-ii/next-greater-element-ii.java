import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);

        // traverse the array twice 
        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < current) {
                result[stack.pop()] = current;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
