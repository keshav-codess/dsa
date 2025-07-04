class Solution {
    int getOddOccurrence(int[] arr, int n) {
        // code here
        
        int result = 0;
        for (int num : arr) {
            result ^= num;  // XOR every element
        }
        return result;
        
    }
}


// approach 2- counting frequencies

class Solution {
    public int findOdd(int[] arr) {
        int max = 0;

        // Step 1: Find the max number in array to size the count array
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Step 2: Count frequencies
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        // Step 3: Find the one with odd count
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                return i;
            }
        }

        return -1;  // just in case no odd count exists
    }
}
