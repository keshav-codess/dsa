class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int start = 0, end = 0;
        int maxScore = 0, currSum = 0;

        while (end < nums.length) {
            if (!seen.contains(nums[end])) {
                seen.add(nums[end]);
                currSum += nums[end];
                maxScore = Math.max(maxScore, currSum);
                end++;
            } else {
                seen.remove(nums[start]);
                currSum -= nums[start];
                start++;
            }
        }

        return maxScore;
    }
}
