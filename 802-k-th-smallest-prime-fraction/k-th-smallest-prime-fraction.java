import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]]));

        for (int j = 1; j < n; j++) {
            pq.offer(new int[] {0, j}); 
        }
        for (int count = 0; count < k - 1; count++) {
            int[] top = pq.poll();
            int i = top[0], j = top[1];
            if (i + 1 < j) {
                pq.offer(new int[] {i + 1, j});
            }
        }

        int[] result = pq.poll();
        return new int[] {arr[result[0]], arr[result[1]]};
    }
}
