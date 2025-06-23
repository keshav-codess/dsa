class Solution {
    public int findComplement(int num) {
        // Step 1: Get the number of bits in the binary representation of the number
        int numberOfBits = Integer.toBinaryString(num).length();

        // Step 2: Create a mask with all bits set to 1 of the same length
        int mask = (1 << numberOfBits) - 1;

        // Step 3: XOR the number with the mask to flip the bits
        return num ^ mask;
    }
}
