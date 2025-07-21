class Solution {
    public int maximumLength(int[] nums) {
        int[][] dp = new int[2][2]; 
        int ans = 0;

        for (int num : nums) {
            int parity = num % 2;
            for (int i = 0; i < 2; i++) {
                dp[i][parity] = dp[parity][i] + 1;
                ans = Math.max(ans, dp[i][parity]);
            }
        }

        return ans;
    }
}
