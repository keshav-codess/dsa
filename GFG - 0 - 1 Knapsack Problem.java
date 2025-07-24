// Approach - recursive
class Solution {
    static int knapsack(int W, int val[], int wt[]) {
       
        return helper(W, 0, val, wt);
    }

    public static int helper(int W, int index, int val[], int wt[]) {
        if (W == 0 || index == val.length) {
            return 0;
        }

        int include = 0;
        if (W >= wt[index]) {
            include = val[index] + helper(W - wt[index], index + 1, val, wt);
        }

        int exclude = helper(W, index + 1, val, wt);

        return Math.max(include, exclude);
    }
}



// Approach - Memorization

class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(W, 0, val, wt, dp);
    }

    public static int helper(int W, int index, int val[], int wt[], int[][] dp) {
        if (W == 0 || index == val.length) {
            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int include = 0;
        if (W >= wt[index]) {
            include = val[index] + helper(W - wt[index], index + 1, val, wt, dp);
        }

        int exclude = helper(W, index + 1, val, wt, dp);
        dp[index][W] = Math.max(include, exclude);
        return dp[index][W];
    }
}



// Approach - Tabulation 

class Solution {
       static int knapsack(int W, int val[], int wt[]) {
    int n = val.length;
    int dp[][] = new int[n+1][W+1];
   
    for(int currentItem = 1; currentItem<=n; currentItem++){
        for(int currentCapacity = 1; currentCapacity<=W; currentCapacity++ ){
            // Choice - 1 Leave it
            int valueAfterLeave = dp[currentItem-1][currentCapacity];
            // Choice - 2 Take it
            int valueAfterTake = 0;
            if(wt[currentItem-1]<=currentCapacity){
                valueAfterTake = val[currentItem-1] + dp[currentItem-1][currentCapacity - wt[currentItem-1]];
            }
            dp[currentItem][currentCapacity] = Math.max(valueAfterLeave, valueAfterTake);
        }
    }
    return dp[n][W];
}

}
