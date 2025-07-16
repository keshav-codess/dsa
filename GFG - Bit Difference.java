class Solution {
    public static int countBitsFlip(int a, int b) {
        int xor = a ^ b;
        int count = 0;

        while (xor != 0) {
            count += (xor & 1);  // check last bit
            xor >>= 1;           // shift right
        }

        return count;
    }
}
