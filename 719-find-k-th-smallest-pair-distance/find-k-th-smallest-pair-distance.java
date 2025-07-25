class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);  

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = countPairs(nums, mid);

            if (count >= k) {
                right = mid;  
            } else {
                left = mid + 1;  // too small
            }
        }

        return left;
    }

    private int countPairs(int[] nums, int maxDiff) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDiff) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}