class Solution {
    static final int MOD = 1_000_000_007;
    List<Integer> powers;
    Long[][] memo;

    public int numberOfWays(int n, int x) {
        powers = new ArrayList<>();
        int base = 1;
        while (true) {
            long val = (long) Math.pow(base, x);
            if (val > n) break;
            powers.add((int) val);
            base++;
        }

        memo = new Long[powers.size()][n + 1];
        return (int) dfs(0, n);
    }

    private long dfs(int i, int remaining) {
        if (remaining == 0) return 1;  
        if (remaining < 0 || i >= powers.size()) return 0;
        if (memo[i][remaining] != null) return memo[i][remaining];

        // choice: take or skip
        long take = dfs(i + 1, remaining - powers.get(i)) % MOD;
        long skip = dfs(i + 1, remaining) % MOD;

        return memo[i][remaining] = (take + skip) % MOD;
    }
}
