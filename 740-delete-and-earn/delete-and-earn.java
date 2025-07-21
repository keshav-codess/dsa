 // ---------- Approach 1 : Recursive --------

// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int max = 0;

//         for (int i : nums) {
//             max = Math.max(max, i);
//         }

//         int[] points = new int[max + 1];
//         for (int num : nums) {
//             points[num] += num;
//         }

//         return helper(points, max);
//     }

//     private int helper(int[] points, int i) {
//         if (i == 0) {
//             return points[0];
//         }
//         if (i == 1) {
//             return Math.max(points[0], points[1]);
//         }
//         return Math.max(helper(points, i - 1), helper(points, i - 2) + points[i]);
//     }
// }


 // ---------- Approach 2 : Memorization --------
 class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for (int i : nums) {
            max = Math.max(max, i);
        }

        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        Integer[] dp = new Integer[max + 1];

        return helper(points, max, dp);
    }

    private int helper(int[] points, int i, Integer[] dp) {
        if (i == 0) return points[0];
        if (i == 1) return Math.max(points[0], points[1]);

        if (dp[i] != null){
            return dp[i];
        } 

        dp[i] = Math.max(helper(points, i - 1, dp), helper(points, i - 2, dp) + points[i]);
        return dp[i];
    }
}



