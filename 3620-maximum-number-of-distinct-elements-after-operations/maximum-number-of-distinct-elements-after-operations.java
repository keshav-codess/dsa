class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int nextFree = Integer.MIN_VALUE;
        for (int num : nums) {
            int place = Math.max(num - k, nextFree);
            if (place <= num + k) {
                result++;
                nextFree = place + 1;
            }
        }
        return result;
    }
}