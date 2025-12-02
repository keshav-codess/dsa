class Solution {
    static final long MOD = 1000000007L;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        List<Long> vals = new ArrayList<>();
        for (int c : map.values()) {
            if (c >= 2) {
                long v = (long)c * (c - 1) / 2;
                vals.add(v % MOD);
            }
        }

        long s = 0, ss = 0;
        for (long v : vals) {
            s = (s + v) % MOD;
            ss = (ss + v * v) % MOD;
        }

        long ans = ((s * s % MOD) - ss + MOD) % MOD;
        ans = ans * inv2() % MOD;
        return (int)ans;
    }

    long inv2() {
        return (MOD + 1) / 2;
    }
}
