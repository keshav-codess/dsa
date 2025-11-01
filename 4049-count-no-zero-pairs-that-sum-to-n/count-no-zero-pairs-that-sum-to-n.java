class Solution {
    public long countNoZeroPairs(long n) {
        long[][][] dp = new long[2][2][2];
        dp[0][0][0] = 1;
        int start = 1;
        while (n > 0) {
            int d = (int)(n % 10);
            n /= 10;
            long[][][] newDp = new long[2][2][2];
            for (int c = 0; c < 2; ++c) {
                for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < 2; ++j) {
                        if (dp[c][i][j] == 0) continue;
                        for (int x = start; x <= (i == 0 ? 9 : 0); ++x) {
                            for (int y = start; y <= (j == 0 ? 9 : 0); ++y) {
                                if ((c + x + y) % 10 != d) continue;
                                int nc = (c + x + y) / 10;
                                int ni = (i == 1 || x == 0) ? 1 : 0;
                                int nj = (j == 1 || y == 0) ? 1 : 0;
                                newDp[nc][ni][nj] += dp[c][i][j];
                            }
                        }
                    }
                }
            }
            dp = newDp;
            start = 0;
        }
        long result = 0;
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j)
                result += dp[0][i][j];
        return result;
    }
}
