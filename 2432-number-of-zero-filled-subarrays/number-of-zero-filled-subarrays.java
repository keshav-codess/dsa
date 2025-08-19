class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, consecutive = 0;
        for (int num : nums) {
            if (num == 0) {
                consecutive++;
                count += consecutive;
            } else {
                consecutive = 0;
            }
        }
        return count;
    }
}
