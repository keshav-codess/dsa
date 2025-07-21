// ---------- Approach 1 : Memorization ----------

// class Solution {
//     public int helper(int[] cost, int i, Integer[] cache) {
//         if(i == 0 || i == 1){
//             return cost[i];
//         }
//         if(cache[i] != null){
//             return cache[i];
//         }
//         cache[i] = cost[i] + Math.min(helper(cost, i-1, cache), helper(cost, i-2, cache));
//         return cache[i];
//     }

//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         Integer cache[] = new Integer[n]; // fill with null
//         return Math.min(helper(cost, n-1, cache), helper(cost, n-2, cache));
//     }
// }


// ---------- Approach 2 : Tabulation ----------

// class Solution{
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int dp[] = new int[n];

//         dp[0] = cost[0];
//         dp[1] = cost[1];
//         for(int i = 2; i < n; i++){
//             dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
//         }
//         return Math.min(dp[n-1], dp[n-2]);
//     }
// }



// ---------- Approach 3 : Tabulation With Space Optimization ----------

class Solution{
public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;

    int prev1 = cost[1]; // Cost to reach step 1
    int prev2 = cost[0]; // Cost to reach step 0

    for(int i = 2; i < n; i++) {
        int currentValue = cost[i] + Math.min(prev1, prev2);
        prev2 = prev1;
        prev1 = currentValue;
    }
    return Math.min(prev1, prev2);
   }
}


