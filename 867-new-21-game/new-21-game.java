class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 0.0;
        double res = 0.0;

        for (int i = 1; i <= n; i++) {
            if (i - 1 < k) windowSum += dp[i - 1];
            if (i - 1 - maxPts >= 0 && i - 1 - maxPts < k) windowSum -= dp[i - 1 - maxPts];

            dp[i] = windowSum / maxPts;

            if (i >= k) res += dp[i];
        }

        return res;
    }
}
