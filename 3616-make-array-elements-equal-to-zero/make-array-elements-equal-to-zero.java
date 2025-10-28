class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (canMakeZero(nums.clone(), i, 1)) result++;
                if (canMakeZero(nums.clone(), i, -1)) result++;
            }
        }

        return result;
    }

    private boolean canMakeZero(int[] nums, int curr, int dir) {
        int n = nums.length;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += dir;
            } else {
                nums[curr]--;
                dir = -dir; // reverse direction
                curr += dir;
            }
        }

        for (int num : nums) {
            if (num != 0) return false;
        }

        return true;
    }
}
