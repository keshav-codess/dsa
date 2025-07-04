class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int i = 0, j = 0;

        while (j < arr.length) {
            // If current element is negative, add to deque
            if (arr[j] < 0) {
                dq.addLast(j);
            }

            // If window size is less than k, just move j
            if (j - i + 1 < k) {
                j++;
            }
            // When window size hits k
            else if (j - i + 1 == k) {
                // If deque is not empty, front has first negative
                if (!dq.isEmpty()) {
                    result.add(arr[dq.peekFirst()]);
                } else {
                    result.add(0);
                }

                // Remove elements out of window from deque
                if (!dq.isEmpty() && dq.peekFirst() == i) {
                    dq.removeFirst();
                }

                // Slide the window
                i++;
                j++;
            }
        }

        return result;
    }
}
