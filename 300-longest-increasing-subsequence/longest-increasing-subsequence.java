// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return helper(nums, 0, -1);
//     }

//     private int helper(int[] nums, int index, int prevIndex) {
//         // Base case: If we have processed all elements, return 0
//         if (index == nums.length) {
//             return 0;
//         }

//         // Option 1: Don't pick the current element
//         int notPickIt = helper(nums, index + 1, prevIndex);

//         // Option 2: Pick the current element if it's greater than the last picked element
//         int pickIt = 0;
//         if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
//             pickIt = 1 + helper(nums, index + 1, index);
//         }

//         // Return the maximum of both choices
//         return Math.max(pickIt, notPickIt);
//     }
// }


// approach -optimized 

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // Initialize memoization table with -1 (n+1 for prevIndex = -1 to n-1)
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(nums, 0, -1, dp);
    }

    private int helper(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        // If already computed
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        // Option 1: Not pick
        int notPick = helper(nums, index + 1, prevIndex, dp);

        // Option 2: Pick if valid
        int pick = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            pick = 1 + helper(nums, index + 1, index, dp);
        }

        // Store and return the result
        dp[index][prevIndex + 1] = Math.max(pick, notPick);
        return dp[index][prevIndex + 1];
    }
}

