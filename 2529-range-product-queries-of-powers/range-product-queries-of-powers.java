class Solution {
    static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) powers.add(1 << bit);
            bit++;
            n >>= 1;
        }

        int m = powers.size();
        long[] prefix = new long[m];
        prefix[0] = powers.get(0);
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * powers.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == 0) {
                ans[i] = (int) prefix[r];
            } else {
                long val = (prefix[r] * modPow(prefix[l - 1], MOD - 2, MOD)) % MOD;
                ans[i] = (int) val;
            }
        }
        return ans;
    }

    private long modPow(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
