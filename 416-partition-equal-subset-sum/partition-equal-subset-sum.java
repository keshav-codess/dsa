// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
        
//         //  sum of the array
//         for (int num : nums) {
//             sum += num;
//         }

//         // If sum is odd
//         if (sum % 2 != 0) {
//             return false;
//         }

//         int target = sum / 2;
        
//         return helper(nums, 0, target);
//     }

//     private boolean helper(int[] nums, int index, int target) {
//         // Base case
//         if (target == 0) {
//             return true;
//         }
//         if (target < 0 || index == nums.length) {
//             return false;
//         }

//         // Pick current number
//         boolean pickIt = helper(nums, index + 1, target - nums[index]);

//         // Skip current number
//         boolean notPick = helper(nums, index + 1, target);

//         return pickIt || notPick;
//     }
// }

// approach -2 : optimzed approach through memorization
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
        
//         //  sum of the array
//         for (int num : nums) {
//             sum += num;
//         }

//         // If sum is odd
//         if (sum % 2 != 0) {
//             return false;
//         }

//         int target = sum / 2;
//         // by default value filled with num using wrapper classes
//         Boolean cache[][] = new Boolean[nums.length][target + 1];
        
//         return helper(nums, 0, target, cache);
//     }

//     private boolean helper(int[] nums, int index, int target, Boolean[][] cache) {
//         // Base case
//         if (target == 0) {
//             return true;
//         }
//         if (target < 0 || index == nums.length) {
//             return false;
//         }

//         // pre check in cache
//         if (cache[index][target] != null) {
//             return cache[index][target];
//         }

//         // Pick current number
//         boolean pickIt = helper(nums, index + 1, target - nums[index], cache);

//         // Skip current number
//         boolean notPick = helper(nums, index + 1, target, cache);

//         cache[index][target] = pickIt || notPick;
//         return cache[index][target];
//     }
// }

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        // Calculate the sum of the array
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, partitioning is not possible
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // picking one by one ( 1, 5,5,11 )
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}
