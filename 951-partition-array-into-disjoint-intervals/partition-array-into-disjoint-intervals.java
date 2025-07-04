class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];
        
        // fill rightMin from right to left
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }

        // scan from left, track max of left part
        int maxLeft = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft = Math.max(maxLeft, nums[i - 1]);
            if (maxLeft <= rightMin[i]) {
                return i;
            }
        }
        
        return -1;
    }
}
