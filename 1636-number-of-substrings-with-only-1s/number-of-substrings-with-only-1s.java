class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;

        long ans = 0;
        int lastZeroIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                lastZeroIndex = i; 
            }
            ans = (ans + (i - lastZeroIndex)) % MOD;
        }

        return (int) ans;
    }
}
