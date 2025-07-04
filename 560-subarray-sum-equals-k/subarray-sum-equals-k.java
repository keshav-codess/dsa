class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Step 1:calculating prefix sum
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Step 2: try all subarrays using prefix sums
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum;
                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
