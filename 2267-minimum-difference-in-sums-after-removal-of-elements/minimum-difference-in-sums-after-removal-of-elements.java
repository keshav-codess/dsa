class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] prefixSum = new long[len];
        long[] suffixSum = new long[len];

        // max heap for left part 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sumLeft = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            sumLeft += nums[i];
            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                prefixSum[i] = sumLeft;
            } else {
                prefixSum[i] = Long.MAX_VALUE;
            }
        }

        // min heap for right part 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;
        for (int i = len - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            sumRight += nums[i];
            if (minHeap.size() > n) {
                sumRight -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                suffixSum[i] = sumRight;
            } else {
                suffixSum[i] = Long.MIN_VALUE;
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (prefixSum[i] != Long.MAX_VALUE && suffixSum[i + 1] != Long.MIN_VALUE) {
                result = Math.min(result, prefixSum[i] - suffixSum[i + 1]);
            }
        }

        return result;
    }
}
