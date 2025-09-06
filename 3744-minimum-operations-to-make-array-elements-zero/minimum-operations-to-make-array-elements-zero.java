class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long sumSteps = prefix(q[1]) - prefix(q[0] - 1);
            ans += (sumSteps + 1) / 2; // ceil
        }
        return ans;
    }

    private long prefix(long n) {
        if (n <= 0) return 0;
        long res = 0;
        long base = 1;
        int step = 1;

        while (base <= n) {
            long end = Math.min(n, base * 4 - 1);
            long count = end - base + 1;
            res += count * step;
            base *= 4;
            step++;
        }
        return res;
    }
}
