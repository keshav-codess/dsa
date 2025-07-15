class Solution {
    public int[] leftSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }
}
