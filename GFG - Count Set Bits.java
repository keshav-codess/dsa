class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;

        int x = highestPowerOf2(n);
        int bitsUpTo2PowerX = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int rest = countSetBits(n - (1 << x));

        return bitsUpTo2PowerX + msbBits + rest;
    }

    private static int highestPowerOf2(int n) {
        int x = 0;
        while ((1 << x) <= n) {
            x++;
        }
        return x - 1;
    }
}
