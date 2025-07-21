//----------- Approach 1 : Recursive --------------

// class Solution {
//     public boolean canJump(int[] nums) {
//         return canReach(nums, 0);
//     }

//     boolean canReach(int[] nums, int index) {
//         // base case
//         if(index >= nums.length - 1) {
//             return true;
//         }
//         int max = nums[index];
//         for(int step = 1; step <= max; step++) {
//             if(canReach(nums, index + step)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }


//----------- Approach 2 : Memoriazation --------------

// class Solution {
//     public boolean canJump(int[] nums) {
//         int[] memo = new int[nums.length];
//         // 0 = unknown, 1 = good, -1 = bad

//         return canReach(nums, 0, memo);
//     }

//     private boolean canReach(int[] nums, int index, int[] memo) {
//         if (index >= nums.length - 1) {
//             return true; 
//         }

//         if (memo[index] != 0) {
//             return memo[index] == 1; 
//         }

//         int maxJump = nums[index];
//         for (int jump = 1; jump <= maxJump; jump++) {
//             if (canReach(nums, index + jump, memo)) {
//                 memo[index] = 1; 
//                 return true;
//             }
//         }

//         memo[index] = -1; 
//         return false;
//     }
// }


//----------- Approach 3 : Greedy --------------

class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false; // can't move to index i
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }
}








