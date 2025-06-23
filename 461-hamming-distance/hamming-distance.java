class Solution {
    public int hammingDistance(int x, int y) {
        // XOR will give bits that are different
        int xor = x ^ y;

        // Count number of 1s in xor result
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // check the last bit
            xor = xor >>> 1;  // logical right shift
        }

        return count;
    }
}
