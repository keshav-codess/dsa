class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] targetCount = countDigits(n);

        for (int i = 0; i < 31; i++) { 
            if (sameCount(targetCount, countDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] countDigits(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        return count;
    }

    private boolean sameCount(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
